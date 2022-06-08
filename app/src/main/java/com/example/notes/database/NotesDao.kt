package com.example.notes.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notes.model.Notes

@Dao
interface NotesDao {

    @Query("Select * from Notes")
    fun getAllNotes(): LiveData<List<Notes>>

    @Query("Select * From Notes where priority = 3")
    fun getHighNotes():LiveData<List<Notes>>

    @Query("Select * From Notes where priority = 2")
    fun getMediumNotes():LiveData<List<Notes>>

    @Query("Select * From Notes where priority = 1")
    fun getLowNotes():LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes: Notes)

    @Query("Delete from Notes where id= :id")
    fun deleteNotes(id:Int)

    @Update
    fun updateNotes(notes: Notes)

}