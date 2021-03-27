package tr.com.cherrysunshinysky.todonotesapp.view

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tr.com.cherrysunshinysky.todonotesapp.utils.PrefConstant
import tr.com.cherrysunshinysky.todonotesapp.R
import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE

/**
 * Created by Emir U. Özen on 3/12/21.
 * emir.ozen@outlook.com
 */
class SplashActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupSharedPreferences()
        checkLoginStatus()
    }

    private fun checkLoginStatus() {
        when (sharedPreferences.getBoolean(PrefConstant.IS_LOGGED_IN, false)) {
            TRUE -> {
                val intent = Intent(this@SplashActivity, MyNotesActivity::class.java)
                startActivity(intent)
            }
            FALSE -> {
                val intent = Intent(this@SplashActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun setupSharedPreferences() {
        sharedPreferences = getSharedPreferences(PrefConstant.SHARED_PREFERENCE_NAME, MODE_PRIVATE)
    }
}
