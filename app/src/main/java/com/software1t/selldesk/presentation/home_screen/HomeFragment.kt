package com.software1t.selldesk.presentation.home_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.appsamurai.storyly.StorylyInit
import com.appsamurai.storyly.StorylyView
import com.software1t.selldesk.base.BaseFragment
import com.software1t.selldesk.common.constants.Constants.Companion.STORYLY_INSTANCE_TOKEN
import com.software1t.selldesk.databinding.FragmentHomeBinding
import com.software1t.selldesk.presentation.home_screen.adapter.CarsAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    private val adapter : CarsAdapter by lazy {
        CarsAdapter {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment()
            findNavController().navigate(action)
        }
    }
    private val viewModel: HomeViewModel by viewModel()

    override fun prepareView(savedInstanceState: Bundle?) {
        binding.rvCars.adapter = adapter
        initObservers()
        viewModel.setEvent(HomeContract.Event.OnFetchCars)
//        viewModel.setEvent(HomeContract.Event.OnCarsItemClicked(car = null))


        binding.storylyView.storylyInit = StorylyInit(STORYLY_INSTANCE_TOKEN)
    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when (val state = it.carsState) {
                        is HomeContract.CarsState.Idle -> {
                            binding.loadingPb.isVisible = false
                        }
                        is HomeContract.CarsState.Loading -> {
                            binding.loadingPb.isVisible = true
                        }
                        is HomeContract.CarsState.Success -> {
                            val data = state.posts
                            adapter.submitList(data)
                            binding.loadingPb.isVisible = false
                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.effect.collect {
                    when (it) {
                        is HomeContract.Effect.ShowError -> {
                            val msg = it.message
                            Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}