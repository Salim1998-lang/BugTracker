package com.example.bugtracker.ui.list_bugs.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bugtracker.data.models.Bug
import com.example.bugtracker.databinding.BugsItemBinding
import com.example.bugtracker.ui.list_bugs.BugsFragmentDirections

class BugAdapter : PagingDataAdapter<Bug, BugAdapter.BugViewHolder>(BugComparator){

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: BugViewHolder, position: Int) {
        holder.binding.title.text = getItem(position)?.title
        holder.binding.state.text = getItem(position)?.status?.state
        holder.binding.version.text = "версия устройства: ${getItem(position)?.version}"
        holder.binding.item.setOnClickListener {
            it.findNavController().navigate(BugsFragmentDirections.actionBugsFragmentToBugDetailsFragment(
                getItem(position)!!
            ))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BugViewHolder {
        return BugViewHolder.from(parent)
    }

    class BugViewHolder(val binding: BugsItemBinding): RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): BugViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = BugsItemBinding.inflate(layoutInflater, parent, false)
                return BugViewHolder(binding)
            }
        }
    }

    object BugComparator : DiffUtil.ItemCallback<Bug>() {
        override fun areItemsTheSame(oldItem: Bug, newItem: Bug): Boolean {
            // Id is unique.
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Bug, newItem: Bug): Boolean {
            return oldItem == newItem
        }
    }
}

