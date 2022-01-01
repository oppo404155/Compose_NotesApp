package com.example.composenotesapp.Feature_note.domain.use_case

//import com.example.composenotesapp.Feature_note.domain.reposity.NoteRepositry
import com.example.composenotesapp.Feature_note.domain.model.Note
import com.example.composenotesapp.Feature_note.domain.reposity.NoteRepository
import com.example.composenotesapp.Feature_note.domain.util.NoteOrder
import com.example.composenotesapp.Feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.map
import java.util.concurrent.Flow

class GetNotes(
    private val repository: NoteRepository
) {

    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): kotlinx.coroutines.flow.Flow<List<Note>> {
        return repository.getNotes().map { notes ->
            when(noteOrder.orderType) {
                is OrderType.Ascending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}