package com.example.notes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notes.database.NotesDatabase
import com.example.notes.model.Notes
import com.example.notes.repository.NotesRepository

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    val repository: NotesRepository

    init {
        val dao = NotesDatabase.getDatabaseInstance(application).notesDao()
        repository = NotesRepository(dao)
    }

    fun insertNotes(notes: Notes)
    {
        repository.insertNotes(notes)
    }

    fun getAllNotes():LiveData<List<Notes>> = repository.getAllNotes()
    fun getHighNotes():LiveData<List<Notes>> = repository.getHighNotes()
    fun getMediumNotes():LiveData<List<Notes>> = repository.getMediumNotes()
    fun getLowNotes(): LiveData<List<Notes>> = repository.getLowNotes()

    fun updateNotes(notes: Notes)
    {
        repository.updateNotes(notes)
    }

    fun deleteNotes(id:Int)
    {
        repository.deleteNotes(id)
    }
}