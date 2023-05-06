package fakes.repository

import com.example.model.Note
import com.github.tumusx.note_list.domain.repository.IListNoteRepository

class ListNoteFakeRepository : IListNoteRepository {

    companion object {
        val noteList = mutableListOf(
            Note(1, "um homem na floresta", "1222233", "Floresta", "23/02/2023"),
            Note(2, "um homem no mar", "252222", "Mar", "24/02/2023")
        )
    }

    override suspend fun getAllNotes() = noteList

    override suspend fun deleteNote(note: Note): Boolean {
        noteList.forEach {
            if (it == note) {
                noteList.remove(note)
                return true
            }
        }
        return false
    }
}