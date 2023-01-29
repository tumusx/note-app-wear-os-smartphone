package com.github.tumusx.feature_note_createupdate.presenter.views

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.github.tumusx.core_navigation.model.NoteNavVO
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class CreateOrUpdateNoteFragmentArgs(
  public val noteNav: NoteNavVO
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(NoteNavVO::class.java)) {
      result.putParcelable("noteNav", this.noteNav as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(NoteNavVO::class.java)) {
      result.putSerializable("noteNav", this.noteNav as Serializable)
    } else {
      throw UnsupportedOperationException(NoteNavVO::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(NoteNavVO::class.java)) {
      result.set("noteNav", this.noteNav as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(NoteNavVO::class.java)) {
      result.set("noteNav", this.noteNav as Serializable)
    } else {
      throw UnsupportedOperationException(NoteNavVO::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): CreateOrUpdateNoteFragmentArgs {
      bundle.setClassLoader(CreateOrUpdateNoteFragmentArgs::class.java.classLoader)
      val __noteNav : NoteNavVO?
      if (bundle.containsKey("noteNav")) {
        if (Parcelable::class.java.isAssignableFrom(NoteNavVO::class.java) ||
            Serializable::class.java.isAssignableFrom(NoteNavVO::class.java)) {
          __noteNav = bundle.get("noteNav") as NoteNavVO?
        } else {
          throw UnsupportedOperationException(NoteNavVO::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__noteNav == null) {
          throw IllegalArgumentException("Argument \"noteNav\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"noteNav\" is missing and does not have an android:defaultValue")
      }
      return CreateOrUpdateNoteFragmentArgs(__noteNav)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        CreateOrUpdateNoteFragmentArgs {
      val __noteNav : NoteNavVO?
      if (savedStateHandle.contains("noteNav")) {
        if (Parcelable::class.java.isAssignableFrom(NoteNavVO::class.java) ||
            Serializable::class.java.isAssignableFrom(NoteNavVO::class.java)) {
          __noteNav = savedStateHandle.get<NoteNavVO?>("noteNav")
        } else {
          throw UnsupportedOperationException(NoteNavVO::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__noteNav == null) {
          throw IllegalArgumentException("Argument \"noteNav\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"noteNav\" is missing and does not have an android:defaultValue")
      }
      return CreateOrUpdateNoteFragmentArgs(__noteNav)
    }
  }
}
