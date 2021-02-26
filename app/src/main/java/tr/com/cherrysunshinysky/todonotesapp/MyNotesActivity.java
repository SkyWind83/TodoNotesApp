package tr.com.cherrysunshinysky.todonotesapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MyNotesActivity extends AppCompatActivity {

    String fullName;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_notes);
        Intent intent = getIntent();
         fullName = intent.getStringExtra("full_name");
         userName = intent.getStringExtra("user_name");

        Log.d("MyNotesActivity1", fullName);
        Log.d("MyNotesActivity2", userName);

        if (fullName != null){
            getSupportActionBar().setTitle(fullName);
        }

    }
}