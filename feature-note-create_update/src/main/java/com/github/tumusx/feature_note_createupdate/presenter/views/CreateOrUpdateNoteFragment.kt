package com.github.tumusx.feature_note_createupdate.presenter.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.common_design_system.ColorsBackgroundType
import com.example.common_extensions.fragments.callOnBackDispatcher
import com.example.common_extensions.fragments.configureBackPressedFragment
import com.github.tumusx.feature_note_createupdate.databinding.FragmentCreateOrUpdateNoteBinding
import com.github.tumusx.feature_note_createupdate.presenter.views.bottomSheet.OptionsNoteBottomSheet
import com.google.android.material.snackbar.Snackbar

class CreateOrUpdateNoteFragment : Fragment() {

    private lateinit var binding: FragmentCreateOrUpdateNoteBinding
    private val args by navArgs<CreateOrUpdateNoteFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentCreateOrUpdateNoteBinding.inflate(layoutInflater).also { rootView ->
        binding = rootView
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureBackPressedExtension()
        configureListener()
    }

    private fun configureBottomSheet() {
        val bottomSheet = OptionsNoteBottomSheet { colorsBackgroundType ->
            receiveColorConfigure(colorsBackgroundType)
        }
        bottomSheet.show(childFragmentManager, bottomSheet.tag)
    }

    private fun receiveColorConfigure(colorBackgroundType: ColorsBackgroundType) {
        Log.d("COLOR TYPE", colorBackgroundType.toString())
        binding.root.setBackgroundColor(ColorsBackgroundType.WHITE.color)
    }

    private fun configureListener() {
        binding.imgBackScreen.setOnClickListener { callOnBackDispatcher() }
        binding.icMoreOption.setOnClickListener {
            configureBottomSheet()
        }
    }

    private fun configureBackPressedExtension() {
        this.configureBackPressedFragment {
            Snackbar.make(binding.root, "calling", Snackbar.LENGTH_LONG).show()
        }
    }
}