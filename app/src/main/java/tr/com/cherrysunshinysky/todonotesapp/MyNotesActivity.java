package tr.com.cherrysunshinysky.todonotesapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MyNotesActivity extends AppCompatActivity {

    String fullName;
    String userName;
    FloatingActionButton fabAddNotes;
    TextView textViewTitle;
    TextView textViewDescription;
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

    private void setupSharedPreference() {
        sharedPreferences = getSharedPreferences(PrefConstant.SHARED_PREFERENCE_NAME, MODE_PRIVATE);


    }

    private void getIntentData() {
        Intent intent = getIntent();
        fullName = intent.getStringExtra("full_name");
        userName = intent.getStringExtra("user_name");
        if (TextUtils.isEmpty(fullName)) {
            fullName = sharedPreferences.getString(PrefConstant.FULL_NAME, "");
        }
    }

    private void bindViews() {
        fabAddNotes = findViewById(R.id.fab_add_notes);
        textViewTitle = findViewById(R.id.tv_title);
        textViewDescription = findViewById(R.id.tv_description);
    }

    private void setupDialogBox() {
        View view = LayoutInflater.from(MyNotesActivity.this).inflate(R.layout.add_notes_dialog_layout, null);
        EditText editTextTitle = view.findViewById(R.id.edit_text_title);
        EditText editTextDescription = view.findViewById(R.id.edit_text_description);
        Button buttonSubmit = view.findViewById(R.id.btn_submit);
        AlertDialog dialog = new AlertDialog.Builder(MyNotesActivity.this)
                .setView(view)
                .setCancelable(false)
                .create();

        buttonSubmit.setOnClickListener(view1 -> {
            textViewTitle.setText(editTextTitle.getText().toString());
            textViewDescription.setText(editTextDescription.getText().toString());
            dialog.hide();
        });
        dialog.show();
    }
}