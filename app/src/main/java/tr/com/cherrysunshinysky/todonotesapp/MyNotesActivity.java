package tr.com.cherrysunshinysky.todonotesapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notes);
        fabAddNotes = findViewById(R.id.fab_add_notes);
        textViewTitle = findViewById(R.id.tv_title);
        textViewDescription = findViewById(R.id.tv_description);

        Intent intent = getIntent();
        fullName = intent.getStringExtra("full_name");
        userName = intent.getStringExtra("user_name");

        fabAddNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupDialogBox();
            }
        });


        Log.d("MyNotesActivity1", fullName);
        Log.d("MyNotesActivity2", userName);

        if (fullName != null) {
            getSupportActionBar().setTitle(fullName);
        }

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

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewTitle.setText(editTextTitle.getText().toString());
                textViewDescription.setText(editTextDescription.getText().toString());
                dialog.hide();
            }
        });
        dialog.show();
    }
}