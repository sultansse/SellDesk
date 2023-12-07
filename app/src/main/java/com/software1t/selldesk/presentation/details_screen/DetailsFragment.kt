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
import com.software1t.selldesk.common.delegates.DividerItemAdapter
import com.software1t.selldesk.databinding.FragmentDetailsBinding
import com.software1t.selldesk.presentation.details_screen.adapter.DetailsDescriptionAdapter
import com.software1t.selldesk.presentation.details_screen.adapter.DetailsHeaderAdapter
import com.software1t.selldesk.presentation.details_screen.adapter.DetailsImageAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailsBinding
        get() = FragmentDetailsBinding::inflate

    private val viewModel: DetailsViewModel by viewModel()
    private val args: DetailsFragmentArgs by navArgs()

    private val compositeAdapter by lazy {
        CompositeAdapter.Builder()
            .add(DetailsImageAdapter())
            .add(DetailsHeaderAdapter())
            .add(DividerItemAdapter())
            .add(DetailsDescriptionAdapter())
            .build()
    }

    override fun prepareView(savedInstanceState: Bundle?) {
        with(binding) {
            toolbar.likeClick = {
                Toast.makeText(requireContext(), "like", Toast.LENGTH_SHORT).show()
            }
            toolbar.shareClick = {
                Toast.makeText(requireContext(), "share", Toast.LENGTH_SHORT).show()
            }
            rvComposite.adapter = compositeAdapter
        }

        initObservers()
        with(viewModel) {
            setEvent(DetailsContract.Event.OnFetchCar(args.carId))
        }
    }

    private fun initObservers() {
        viewModel.adapterItems.observe(viewLifecycleOwner) {
            compositeAdapter.submitList(it)
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