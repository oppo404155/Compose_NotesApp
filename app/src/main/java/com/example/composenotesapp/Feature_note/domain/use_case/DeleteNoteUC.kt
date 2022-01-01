package com.example.composenotesapp.Feature_note.domain.use_case

import com.example.composenotesapp.Feature_note.domain.model.Note
import com.example.composenotesapp.Feature_note.domain.reposity.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}