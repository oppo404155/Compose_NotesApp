package com.example.composenotesapp.Feature_note.domain.use_case

import com.example.composenotesapp.Feature_note.domain.model.Note
import com.example.composenotesapp.Feature_note.domain.reposity.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}