package tr.com.cherrysunshinysky.todonotesapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import tr.com.cherrysunshinysky.todonotesapp.adapter.NotesAdapter;
import tr.com.cherrysunshinysky.todonotesapp.clicklistener.ItemClickListener;
import tr.com.cherrysunshinysky.todonotesapp.model.Notes;

public class MyNotesActivity extends AppCompatActivity {

    String fullName;
    FloatingActionButton fabAddNotes;
    RecyclerView rvNotes;
    ArrayList<Notes> notesList = new ArrayList<>();
    EditText editTextTitle;
    EditText editTextDescription;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notes);
        bindViews();
        setupSharedPreference();
        getIntentData();


        fabAddNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupDialogBox();
            }
        });


        if (fullName != null) {
            getSupportActionBar().setTitle(fullName);
        }

    }

    private void setupRecyclerView() {

        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onClick() {
                Log.i("OnClick", "OnClick Clicked!");
            }
        };


        NotesAdapter notesAdapter = new NotesAdapter(notesList, itemClickListener);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyNotesActivity.this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        rvNotes.setLayoutManager(linearLayoutManager);
        rvNotes.setAdapter(notesAdapter);
    }

    private void setupSharedPreference() {
        sharedPreferences = getSharedPreferences(PrefConstant.SHARED_PREFERENCE_NAME, MODE_PRIVATE);


    }

    private void getIntentData() {
        Intent intent = getIntent();
        fullName = intent.getStringExtra("full_name");
        if (TextUtils.isEmpty(fullName)) {
            fullName = sharedPreferences.getString(PrefConstant.FULL_NAME, "");
        }
    }

    private void bindViews() {
        fabAddNotes = findViewById(R.id.fab_add_notes);
        rvNotes = findViewById(R.id.rv_notes);

    }

    private void setupDialogBox() {
        View view = LayoutInflater.from(MyNotesActivity.this).inflate(R.layout.add_notes_dialog_layout, null);
        Button buttonSubmit = view.findViewById(R.id.btn_submit);
        editTextTitle = view.findViewById(R.id.et_title_add_notes);
        editTextDescription = view.findViewById(R.id.et_description_add_notes);
        AlertDialog dialog = new AlertDialog.Builder(MyNotesActivity.this)
                .setView(view)
                .setCancelable(false)
                .create();

        buttonSubmit.setOnClickListener(view1 -> {
            String title = editTextTitle.getText().toString();
            String description = editTextDescription.getText().toString();
            Notes notes = new Notes();
            notes.setTitle(title);
            notes.setDescription(description);
            notesList.add(notes);
            Log.d("MyNotesActivity", String.valueOf(notesList.size()));
            setupRecyclerView();
            dialog.hide();
        });
        dialog.show();
    }
}