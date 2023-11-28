package com.software1t.selldesk.presentation.profile_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.software1t.selldesk.base.BaseFragment
import com.software1t.selldesk.base.adapter.CompositeAdapter
import com.software1t.selldesk.common.delegates.ButtonItemAdapter
import com.software1t.selldesk.common.delegates.DividerItemAdapter
import com.software1t.selldesk.databinding.FragmentProfileBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentProfileBinding
        get() = FragmentProfileBinding::inflate

    private val viewModel: ProfileViewModel by viewModel()
    private val compositeAdapter by lazy {
        CompositeAdapter.Builder()
            .add(DividerItemAdapter())
            .add(ButtonItemAdapter())
            .build()
    }

    override fun prepareView(savedInstanceState: Bundle?) {

        with(binding) {
            rvComposite.adapter = compositeAdapter
        }

        with(viewModel) {
            adapterItems.observe(viewLifecycleOwner) {
                compositeAdapter.submitList(it)
            }
//
//            setEvent(DetailsContract.Event.OnFetchCars)
        }
    }
}