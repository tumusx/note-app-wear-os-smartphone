package com.github.tumusx.feature_note_createupdate.presenter.views.bottomSheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.common_design_system.ColorsBackgroundType
import com.github.tumusx.feature_note_createupdate.databinding.BottomSheetOptionsNoteBinding
import com.github.tumusx.common_design_system.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class OptionsNoteBottomSheet(private val callBack: (ColorsBackgroundType) -> Unit): BottomSheetDialogFragment() {
    private lateinit var binding: BottomSheetOptionsNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = BottomSheetOptionsNoteBinding.inflate(layoutInflater).also {view->
        binding = view
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.root.setOnClickListener {
            callBack.invoke(ColorsBackgroundType.GREEN)
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getTheme() = R.style.AppBottomSheetDialogTheme

}