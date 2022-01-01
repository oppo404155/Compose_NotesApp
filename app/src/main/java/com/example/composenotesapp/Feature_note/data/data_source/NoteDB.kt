package com.example.composenotesapp.Feature_note.data.data_source

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.composenotesapp.Feature_note.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase: RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }
}