package com.software1t.selldesk.presentation.home_screen.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.software1t.selldesk.base.BaseViewHolder
import com.software1t.selldesk.base.adapter.DelegateAdapter
import com.software1t.selldesk.databinding.DelegateCategoriesBinding
import com.software1t.selldesk.presentation.home_screen.model.CategoryUiModel


class CategoryAdapter(
    private val clickFunc: (() -> Unit)? = null
) : DelegateAdapter<CategoryUiModel, DelegateCategoriesBinding, CategoryAdapter.CategoryViewHolder>(
    CategoryUiModel::class.java
) {

    override fun onCreateViewHolder(parent: ViewGroup): BaseViewHolder<CategoryUiModel, DelegateCategoriesBinding> {
        val binding = DelegateCategoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding = binding, click = clickFunc)
    }

    class CategoryViewHolder(
        private val binding: DelegateCategoriesBinding,
        private val click: (() -> Unit)? = null,
    ) : BaseViewHolder<CategoryUiModel, DelegateCategoriesBinding>(binding) {

        init {
//            binding.root.setOnClickListener {
//                click?.invoke()
//            }
            binding.squareLinearLayoutView1.rootClick = {
                Toast.makeText(binding.squareLinearLayoutView1.context, "1", Toast.LENGTH_SHORT).show()
                click?.invoke()
            }
            binding.squareLinearLayoutView2.rootClick = {
                Toast.makeText(binding.squareLinearLayoutView2.context, "2", Toast.LENGTH_SHORT).show()
                click?.invoke()
            }
            binding.squareLinearLayoutView3.rootClick = {
                Toast.makeText(binding.squareLinearLayoutView3.context, "3", Toast.LENGTH_SHORT).show()
                click?.invoke()
            }
            binding.squareLinearLayoutView4.rootClick = {
                Toast.makeText(binding.squareLinearLayoutView4.context, "4", Toast.LENGTH_SHORT).show()
                click?.invoke()
            }
            binding.squareLinearLayoutView5.rootClick = {
                Toast.makeText(binding.squareLinearLayoutView5.context, "5", Toast.LENGTH_SHORT).show()
                click?.invoke()
            }
            binding.squareLinearLayoutView6.rootClick = {
                Toast.makeText(binding.squareLinearLayoutView6.context, "6", Toast.LENGTH_SHORT).show()
                click?.invoke()
            }
        }

        override fun bind() {
            getRowItem()?.let {
                with(binding) {
                    squareLinearLayoutView1.squareBinding.ivIcon.setImageResource(it.icon1)
                    squareLinearLayoutView1.squareBinding.tvTitle.text = it.title1

                    squareLinearLayoutView2.squareBinding.ivIcon.setImageResource(it.icon2)
                    squareLinearLayoutView2.squareBinding.tvTitle.text = it.title2

                    squareLinearLayoutView3.squareBinding.ivIcon.setImageResource(it.icon3)
                    squareLinearLayoutView3.squareBinding.tvTitle.text = it.title3

                    squareLinearLayoutView4.squareBinding.ivIcon.setImageResource(it.icon4)
                    squareLinearLayoutView4.squareBinding.tvTitle.text = it.title4

                    squareLinearLayoutView5.squareBinding.ivIcon.setImageResource(it.icon5)
                    squareLinearLayoutView5.squareBinding.tvTitle.text = it.title5

                    squareLinearLayoutView6.squareBinding.ivIcon.setImageResource(it.icon6)
                    squareLinearLayoutView6.squareBinding.tvTitle.text = it.title6

                    Log.e("TAG", ">>> bind: model = $it");
                }
            }
        }
    }
}