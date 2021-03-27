package tr.com.cherrysunshinysky.todonotesapp

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import tr.com.cherrysunshinysky.todonotesapp.adapter.NotesAdapter
import tr.com.cherrysunshinysky.todonotesapp.clicklistener.ItemClickListener
import tr.com.cherrysunshinysky.todonotesapp.model.Notes

/**
 * Created by Emir U. Özen on 3/18/2021
 * emir.ozen@outlook.com
 */
class MyNotesActivity : AppCompatActivity() {
    private lateinit var fullName: String
    private lateinit var fabAddNotes: FloatingActionButton
    private lateinit var rvNotes: RecyclerView
    private var notesList = ArrayList<Notes>()
    private lateinit var editTextTitle: EditText
    private lateinit var editTextDescription: EditText
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_notes)
        setupSharedPreference()
        bindViews()
        getIntentData()


    }

    private fun setTitle() {
        supportActionBar?.title = sharedPreferences.getString(PrefConstant.FULL_NAME,"")
    }

    private fun getIntentData() {
        val intent = intent
        fullName = intent.getStringExtra("full_name").toString()
        if (fullName.isEmpty()) {
            fullName = sharedPreferences.getString(PrefConstant.FULL_NAME, "").toString()
        }

    }

    private fun setupRecyclerView() {
        val itemClickListener = object : ItemClickListener {
            override fun onClick(notes: Notes) {
                val intent = Intent(this@MyNotesActivity, DetailActivity::class.java)
                intent.putExtra(PrefConstant.TITLE, notes.title)
                intent.putExtra(PrefConstant.DESCRIPTION, notes.description)
                startActivity(intent)
            }
        }

        val notesAdapter = NotesAdapter(notesList, itemClickListener)
        val linearLayoutManager = LinearLayoutManager(this@MyNotesActivity)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        rvNotes.layoutManager = linearLayoutManager
        rvNotes.adapter = notesAdapter
    }

    private fun bindViews() {
        fabAddNotes = findViewById(R.id.fab_add_notes)
        rvNotes = findViewById(R.id.rv_notes)
        fabAddNotes.setOnClickListener { setupDialogBox() }
    }

    private fun setupSharedPreference() {
        sharedPreferences = getSharedPreferences(PrefConstant.SHARED_PREFERENCE_NAME, MODE_PRIVATE)
        setTitle()
    }

    private fun setupDialogBox() {
        val view = LayoutInflater.from(this@MyNotesActivity).inflate(R.layout.add_notes_dialog_layout, null)
        val submitButton = view.findViewById<Button>(R.id.btn_submit)
        val editTextTitle = view.findViewById<EditText>(R.id.et_full_name_login)
        val editTextDescription = view.findViewById<EditText>(R.id.et_user_name_login)
        val dialog: AlertDialog = AlertDialog.Builder(this@MyNotesActivity)
                .setView(view)
                .setCancelable(false)
                .create()

        submitButton.setOnClickListener {
            val title = editTextTitle.text.toString()
            val description = editTextDescription.text.toString()
            if (title.isNotEmpty() && description.isNotEmpty()) {
                val notes = Notes(title, description)
                notesList.add(notes)
                setupRecyclerView()
                dialog.hide()
            } else {
                Toast.makeText(this@MyNotesActivity, "Title or description can not be empty", Toast.LENGTH_SHORT).show()
            }
        }
        dialog.show()
    }

}