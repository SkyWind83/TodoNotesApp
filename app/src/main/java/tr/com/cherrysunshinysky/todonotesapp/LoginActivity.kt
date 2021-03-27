package tr.com.cherrysunshinysky.todonotesapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Emir U. Özen on 3/27/2021
 * emir.ozen@outlook.com
 */
class LoginActivity : AppCompatActivity() {
    private lateinit var editTextFullName: EditText
    private lateinit var editTextUserName: EditText
    private lateinit var fullName: String
    private lateinit var userName: String
    private lateinit var buttonLogin: Button
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        bindViews()
        setupSharedPreferences()
        handleLoginButtonClick()
    }

    private fun handleLoginButtonClick() {
        buttonLogin.setOnClickListener {
            fullName = editTextFullName.text.toString()
            userName = editTextUserName.text.toString()
            Log.i("LoginActivity", "ButtonLogin Click Performed!!!")

            if (fullName.isNotEmpty() && userName.isNotEmpty()) {
                val intent = Intent(this@LoginActivity, MyNotesActivity::class.java)
                intent.putExtra("full_name", fullName)
                intent.putExtra("user_name", userName)
                startActivity(intent)
                saveLoginStatus()
                saveFullName(fullName)
            } else {
                Toast.makeText(this@LoginActivity, "Username and Fullname can not be empty", Toast.LENGTH_SHORT).show()
            }
        }


    }

    private fun saveLoginStatus() {
        editor = sharedPreferences.edit()
        editor.putBoolean(PrefConstant.IS_LOGGED_IN, true)
        editor.apply()
    }

    private fun saveFullName(userFullName: String) {
        editor = sharedPreferences.edit()
        editor.putString(PrefConstant.FULL_NAME, userFullName)
        editor.apply()
    }

    private fun bindViews() {
        editTextFullName = findViewById(R.id.et_full_name_login)
        editTextUserName = findViewById(R.id.et_user_name_login)
        buttonLogin = findViewById(R.id.btn_login)

    }

    private fun setupSharedPreferences() {
        sharedPreferences = getSharedPreferences(PrefConstant.SHARED_PREFERENCE_NAME, MODE_PRIVATE)
    }
}