package com.software1t.selldesk.presentation.details_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.software1t.selldesk.base.BaseFragment
import com.software1t.selldesk.base.adapter.CompositeAdapter
import com.software1t.selldesk.databinding.FragmentDetailsBinding
import com.software1t.selldesk.presentation.details_screen.adapter.DetailsHeaderAdapter
import com.software1t.selldesk.presentation.details_screen.adapter.DividerItemAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    private val viewModel: DetailsViewModel by viewModel()
    private val args: DetailsFragmentArgs by navArgs()

    private val compositeAdapter by lazy {
        CompositeAdapter.Builder()
            .add(DetailsHeaderAdapter())
            .add(DividerItemAdapter())
            .build()
    }

    override fun prepareView(savedInstanceState: Bundle?) {
        initObservers()

        with(binding) {
            rvComposite.adapter = compositeAdapter
        }
        with(viewModel) {
            adapterItems.observe(viewLifecycleOwner) {
                compositeAdapter.submitList(it)
            }

//            setEvent(DetailsContract.Event.OnFetchCars)
        }
    }


    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {

//                    when (val state = it.carsState) {
//                        is HomeContract.CarsState.Idle -> {
//                            binding.loadingPb.isVisible = false
//                        }
//
//                        is HomeContract.CarsState.Loading -> {
//                            binding.loadingPb.isVisible = true
//                        }
//
//                        is HomeContract.CarsState.Success -> {
//                            val data = state.cars
//                            carsAdapter.submitList(data)
//                            binding.loadingPb.isVisible = false
//                        }
//                    }

                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.effect.collect {
                    when (it) {
                        is DetailsContract.Effect.ShowError -> {
                            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}