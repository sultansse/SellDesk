package com.software1t.selldesk.presentation.favorites_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.software1t.selldesk.base.BaseFragment
import com.software1t.selldesk.common.extenshions.navigate
import com.software1t.selldesk.databinding.FragmentFavoritesBinding
import com.software1t.selldesk.presentation.favorites_screen.adapter.FavoriteCarsAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>() {

    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentFavoritesBinding
        get() = FragmentFavoritesBinding::inflate

    private val viewModel: FavoritesViewModel by viewModel()
    private val carsAdapter: FavoriteCarsAdapter by lazy {
        FavoriteCarsAdapter {
            goToDetails(it)
        }
    }

    override fun prepareView(savedInstanceState: Bundle?) {
        initObservers()
        with(binding) {
            swipeRefreshLayout.setOnRefreshListener {
                viewModel.setEvent(FavoritesContract.Event.OnFetchCars)
                swipeRefreshLayout.isRefreshing = false
            }
            setupAdapter()
        }

        with(viewModel) {
            setEvent(FavoritesContract.Event.OnFetchCars)
        }
    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {

                    when (val state = it.carsState) {
                        is FavoritesContract.CarsState.Idle -> {
                            // remove if want to update without animation
                            binding.rvCars.isVisible = false
                            binding.rvVeil.veil()
                        }

                        is FavoritesContract.CarsState.Loading -> {
                            // remove if want to update without animation
                            binding.rvCars.isVisible = false
                            binding.rvVeil.veil()
                        }

                        is FavoritesContract.CarsState.Success -> {
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
                        is FavoritesContract.Effect.ShowError -> {
                            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }


    private fun goToDetails(carId: Int) {
        val action = FavoritesFragmentDirections.actionFavoritesFragmentToDetailsFragment(carId)
        navigate(action)
    }

    private fun setupAdapter() {
        with(binding) {
            rvCars.adapter = carsAdapter
            rvVeil.setAdapter(carsAdapter)
            rvVeil.setLayoutManager(LinearLayoutManager(requireContext()))
            rvVeil.addVeiledItems(6)
        }
    }
}