package com.example.notes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notes.model.Notes

@Database(entities = [Notes::class],version=1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase()
{
    abstract fun notesDao(): NotesDao

    companion object
    {
       var INSTANCE : NotesDatabase ?= null

       fun getDatabaseInstance(context: Context): NotesDatabase
       {
              val temporaryInstance = INSTANCE
               if (temporaryInstance == null)
               {
                   synchronized(this)
                   {
                       val roomDatabaseInstance = Room.databaseBuilder(context,NotesDatabase::class.java,"Notes").allowMainThreadQueries().build()
                       INSTANCE = roomDatabaseInstance
                       return INSTANCE!!
                   }
               }
           else
               {
                   return temporaryInstance
               }
       }
    }
}