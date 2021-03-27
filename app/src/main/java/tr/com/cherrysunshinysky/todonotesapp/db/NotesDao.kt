package tr.com.cherrysunshinysky.todonotesapp.db

import androidx.room.*

/**
 * Created by Emir U. Özen on 3/27/2021
 * emir.ozen@outlook.com
 */

// DATA Access Objects

@Dao
interface NotesDao {
    @Query("SELECT * FROM NotesData")
    fun getAll(): List<Notes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(notes: Notes)

    @Update
    fun updateNotes(notes: Notes)

    @Delete
    fun deleteNote(notes: Notes)
}