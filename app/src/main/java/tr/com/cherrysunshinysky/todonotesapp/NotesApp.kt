package tr.com.cherrysunshinysky.todonotesapp

import android.app.Application
import tr.com.cherrysunshinysky.todonotesapp.db.NotesDatabase

/**
 * Created by Emir U. Özen on 3/27/2021
 * emir.ozen@outlook.com
 */
class NotesApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    fun getNotesDB(): NotesDatabase {
        return NotesDatabase.getInstance(this)
    }

}