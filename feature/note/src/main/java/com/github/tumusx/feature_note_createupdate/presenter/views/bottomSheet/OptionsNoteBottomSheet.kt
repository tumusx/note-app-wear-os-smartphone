package com.github.tumusx.feature_note_createupdate.presenter.views.bottomSheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.common_design_system.ColorsBackgroundType
import com.github.tumusx.common_design_system.R
import com.github.tumusx.feature_note_createupdate.databinding.BottomSheetOptionsNoteBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class OptionsNoteBottomSheet(private val callBack: (ColorsBackgroundType) -> Unit) :
    BottomSheetDialogFragment() {
    private lateinit var binding: BottomSheetOptionsNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = BottomSheetOptionsNoteBinding.inflate(layoutInflater).also { view ->
        binding = view
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        configureRadioItemListener()
        super.onViewCreated(view, savedInstanceState)
    }


    private fun configureRadioItemListener() {
        binding.rdBackgroundColor.setOnCheckedChangeListener { _, radioIdSelect ->
            val selectColor = when (radioIdSelect) {
                binding.rdBlueColor.id -> ColorsBackgroundType.BLUE
                binding.rdRedColor.id -> ColorsBackgroundType.RED
                binding.rdColorBlack.id -> ColorsBackgroundType.DARK_COLOR
                binding.rdGreenColor.id -> ColorsBackgroundType.GREEN
                binding.rdColorPurple.id -> ColorsBackgroundType.PURPLE
                binding.rdTealBlueColor.id -> ColorsBackgroundType.TEAL_BLUE
                else -> ColorsBackgroundType.DARK_COLOR
            }
            callBack.invoke(selectColor)
        }
    }

    override fun getTheme() = R.style.AppBottomSheetDialogTheme

}