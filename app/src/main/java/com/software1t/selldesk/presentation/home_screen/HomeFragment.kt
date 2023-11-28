package com.software1t.selldesk.presentation.home_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.appsamurai.storyly.StorylyInit
import com.appsamurai.storyly.config.StorylyConfig
import com.appsamurai.storyly.config.styling.group.StorylyStoryGroupStyling
import com.software1t.selldesk.base.BaseFragment
import com.software1t.selldesk.common.constants.Constants.Companion.STORYLY_INSTANCE_TOKEN
import com.software1t.selldesk.common.extenshions.navigate
import com.software1t.selldesk.databinding.FragmentHomeBinding
import com.software1t.selldesk.presentation.home_screen.adapter.CarsAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    private val viewModel: HomeViewModel by viewModel()

    private val carsAdapter: CarsAdapter by lazy {
        CarsAdapter {
            goToDetails(it)
        }
    }

    override fun prepareView(savedInstanceState: Bundle?) {
        initObservers()

        with(binding) {
            storylyView.storylyInit = StorylyInit(
                storylyId = STORYLY_INSTANCE_TOKEN,
                config = StorylyConfig.Builder()
                    .setStoryGroupStyling(
                        styling = StorylyStoryGroupStyling.Builder()
                            .setTitleVisibility(isVisible = false)
                            .build()
                    ).build()
            )


            swipeRefreshLayout.setOnRefreshListener {
                viewModel.setEvent(HomeContract.Event.OnFetchCars)
                swipeRefreshLayout.isRefreshing = false
            }
            setupAdapter()
        }

        with(viewModel) {
            setEvent(HomeContract.Event.OnFetchCars)
        }
    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {

                    when (val state = it.carsState) {
                        is HomeContract.CarsState.Idle -> {
                            binding.rvVeil.veil()
                        }

                        is HomeContract.CarsState.Loading -> {
                            binding.rvVeil.veil()
                        }

                        is HomeContract.CarsState.Success -> {
                            val data = state.cars
                            if (data.isEmpty()) {
                                binding.animationView.isVisible = true
                            }
                            binding.rvCars.isVisible = true
                            binding.rvVeil.unVeil()
                            carsAdapter.submitList(data)
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
                            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }

    private fun goToDetails(carId: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(carId)
        navigate(action)
    }

    private fun setupAdapter() {
        with(binding) {
            rvCars.adapter = carsAdapter
            rvVeil.setAdapter(carsAdapter)
            rvVeil.setLayoutManager(GridLayoutManager(requireContext(), 2))
            rvVeil.addVeiledItems(12)
        }
    }
}