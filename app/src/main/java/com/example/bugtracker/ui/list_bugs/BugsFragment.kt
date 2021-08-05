package com.example.bugtracker.ui.list_bugs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bugtracker.databinding.BugsFragmentBinding
import com.example.bugtracker.ui.list_bugs.adapter.BugAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class BugsFragment : Fragment() {

    private lateinit var viewModel: BugsViewModel
    private var _binding: BugsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BugsFragmentBinding.inflate(inflater, container, false)
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel = ViewModelProvider(this).get(BugsViewModel::class.java)
        loadBugs(recyclerView)
        return binding.root
    }

    private fun loadBugs(recyclerView: RecyclerView) {
        val bugAdapter = BugAdapter()
        with(recyclerView) {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = bugAdapter
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.bugs.collectLatest {
                bugAdapter.submitData(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}