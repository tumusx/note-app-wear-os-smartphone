package com.github.tumusx.note_list.presenter.views

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.github.tumusx.core_navigation.model.NoteNavVO
import com.github.tumusx.feature_note_list.R
import java.io.Serializable
import kotlin.Int
import kotlin.Suppress

public class ListNotesFragmentDirections private constructor() {
  private data class ActionToCreateNote(
    public val noteNav: NoteNavVO? = null
  ) : NavDirections {
    public override val actionId: Int = R.id.action_to_create_note

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(NoteNavVO::class.java)) {
          result.putParcelable("noteNav", this.noteNav as Parcelable?)
        } else if (Serializable::class.java.isAssignableFrom(NoteNavVO::class.java)) {
          result.putSerializable("noteNav", this.noteNav as Serializable?)
        }
        return result
      }
  }

  public companion object {
    public fun actionToCreateNote(noteNav: NoteNavVO? = null): NavDirections =
        ActionToCreateNote(noteNav)
  }
}
