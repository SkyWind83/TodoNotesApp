package tr.com.cherrysunshinysky.todonotesapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText editTextUserName, editTextFullName;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextFullName = findViewById(R.id.edit_text_fullName);
        editTextUserName = findViewById(R.id.edit_text_userName);
        buttonLogin = findViewById(R.id.btn_login);

        View.OnClickListener clickAction = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("LoginActivity", "onClick performed");
            }
        };
        buttonLogin.setOnClickListener(clickAction);
    }
}