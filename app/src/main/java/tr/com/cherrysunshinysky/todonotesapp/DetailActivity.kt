package tr.com.cherrysunshinysky.todonotesapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Emir U. Özen on 3/12/21.
 * emir.ozen@outlook.com
 */
class DetailActivity : AppCompatActivity() {
    private lateinit var tvDetailTitle: TextView
    private lateinit var tvDetailDescription: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        bindViews()
        getDataFromMyNotesActivity()
    }

    private fun getDataFromMyNotesActivity() {
        val intent = intent
        val title: String? = intent.getStringExtra(PrefConstant.TITLE)
        val description: String? = intent.getStringExtra(PrefConstant.DESCRIPTION)

        tvDetailTitle.text = title
        tvDetailDescription.text = description
    }

    private fun bindViews() {
        tvDetailTitle = findViewById(R.id.tv_detail_title)
        tvDetailDescription = findViewById(R.id.tv_detatil_description)
    }
}