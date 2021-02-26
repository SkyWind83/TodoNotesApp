package tr.com.cherrysunshinysky.todonotesapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static tr.com.cherrysunshinysky.todonotesapp.PrefConstant.IS_LOGGED_IN;
import static tr.com.cherrysunshinysky.todonotesapp.PrefConstant.SHARED_PREFERENCE_NAME;


public class LoginActivity extends AppCompatActivity {

    EditText editTextUserName, editTextFullName;
    Button buttonLogin;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    // name -> Emir
    // company -> Mindorks

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextFullName = findViewById(R.id.edit_text_title);
        editTextUserName = findViewById(R.id.edit_text_description);
        buttonLogin = findViewById(R.id.btn_login);
        setupSharedPreferences();


        View.OnClickListener clickAction = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName = editTextFullName.getText().toString();
                String userName = editTextUserName.getText().toString();
                Log.d("LoginActivity", "onClick performed");

                if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(fullName)) {
                    Intent intent = new Intent(LoginActivity.this, MyNotesActivity.class);
                    intent.putExtra("full_name", fullName);
                    intent.putExtra("user_name", userName);
                    startActivity(intent);
                    saveLoginStatus();
                    saveFullName(userName);
                } else {
                    Toast.makeText(LoginActivity.this, "Username and Fullname can not be empty!", Toast.LENGTH_SHORT).show();
                }
            }
        };
        buttonLogin.setOnClickListener(clickAction);
    }

    private void saveFullName(String fullName) {
        editor = sharedPreferences.edit();
        editor.putString(PrefConstant.FULL_NAME, fullName);
        editor.apply();
    }

    private void saveLoginStatus() {
        editor = sharedPreferences.edit();
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.apply();
    }

    private void setupSharedPreferences() {
        sharedPreferences = getSharedPreferences(SHARED_PREFERENCE_NAME, MODE_PRIVATE);
    }
}