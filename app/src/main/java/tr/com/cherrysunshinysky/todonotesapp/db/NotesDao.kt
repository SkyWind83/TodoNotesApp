package tr.com.cherrysunshinysky.todonotesapp.db

import androidx.room.*

/**
 * Created by Emir U. Özen on 4/24/2021
 * emir.ozen@outlook.com
 */
@Dao
interface NotesDao {

    @Query("SELECT * FROM notesData")
    fun getAll(): List<Notes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(notes: Notes)

    @Update
    fun updateNotes(notes: Notes)

    @Delete
    fun delete(notes: Notes)

}