package com.software1t.selldesk.presentation.details_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.software1t.selldesk.base.BaseFragment
import com.software1t.selldesk.databinding.FragmentDetailsBinding

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    private val viewModel: DetailsViewModel by viewModels()

    val args: DetailsFragmentArgs by navArgs()


    override fun prepareView(savedInstanceState: Bundle?) {
        binding.textView.text = "some detailed text and ${args.carId}"
    }
}