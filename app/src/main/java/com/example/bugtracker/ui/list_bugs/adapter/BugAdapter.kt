package com.example.bugtracker.ui.list_bugs.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bugtracker.R
import com.example.bugtracker.data.models.Bug
import com.example.bugtracker.databinding.BugsItemBinding
import com.example.bugtracker.ui.bug_details.BugDetailsFragmentDirections
import com.example.bugtracker.ui.list_bugs.BugsFragmentDirections

class BugAdapter(private var bugs: List<Bug>) : RecyclerView.Adapter<BugAdapter.BugViewHolder>() {

    class BugViewHolder(val binding: BugsItemBinding): RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun from(parent: ViewGroup): BugViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = BugsItemBinding.inflate(layoutInflater, parent, false)
                return BugViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BugViewHolder {
        return BugViewHolder.from(parent)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: BugViewHolder, position: Int) {
        holder.binding.title.text = bugs[position].title
        holder.binding.state.text = bugs[position].status.state
        holder.binding.version.text = "версия устройства: ${bugs[position].version}"
        holder.binding.item.setOnClickListener {
            it.findNavController().navigate(BugsFragmentDirections.actionBugsFragmentToBugDetailsFragment(bugs[position]))
        }
    }

    override fun getItemCount(): Int {
        return bugs.size
    }
}


