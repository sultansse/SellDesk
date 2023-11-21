package com.software1t.selldesk.presentation.home_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.appsamurai.storyly.StorylyInit
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

        with(binding) {
            storylyView.storylyInit = StorylyInit(STORYLY_INSTANCE_TOKEN)
            rvCars.adapter = carsAdapter

//        binding.rvCars.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        }

        initObservers()
        viewModel.setEvent(HomeContract.Event.OnFetchCars)
    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()

                    when (val state = it.carsState) {
                        is HomeContract.CarsState.Idle -> {
                            binding.loadingPb.isVisible = false
                        }

                        is HomeContract.CarsState.Loading -> {
                            binding.loadingPb.isVisible = true
                        }

                        is HomeContract.CarsState.Success -> {
                            val data = state.cars
                            carsAdapter.submitList(data)
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

    private fun goToDetails(carId: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(carId)
        navigate(action)
    }
}