package com.target.targetcasestudy.feature.deals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.target.targetcasestudy.databinding.DealListItemBinding
import com.target.targetcasestudy.domain.entity.ProductEntity
import com.target.targetcasestudy.R


class DealItemAdapter(private val listener: OnDealItemClickListener) :
    ListAdapter<ProductEntity, DealItemAdapter.DealItemViewHolder>(DealsDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealItemViewHolder {
        val binding = DataBindingUtil.inflate<DealListItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.deal_list_item,
            parent,
            false
        )
        return DealItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DealItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

  inner class DealItemViewHolder(private val binding: DealListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(entity: ProductEntity) {
           binding.entity = entity
           binding.viewItem.setOnClickListener {
               listener.onDealItemClick(entity)
           }
        }
    }


    class DealsDiffCallback : DiffUtil.ItemCallback<ProductEntity>() {
        override fun areItemsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
            return oldItem == newItem
        }
    }

    interface OnDealItemClickListener{
        fun onDealItemClick(productEntity: ProductEntity)
    }
}