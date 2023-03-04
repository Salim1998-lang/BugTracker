package com.example.bugtracker.ui.bug_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.bugtracker.databinding.BugDetailsFragmentBinding

class BugDetailsFragment : Fragment() {

    private var _binding: BugDetailsFragmentBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<BugDetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BugDetailsFragmentBinding.inflate(inflater, container, false)
        with(binding) {
            titleDet.text = args.currentItem.title
            descriptionDet.text = args.currentItem.description
            product.text = args.currentItem.product.name
            sender.text = args.currentItem.sender.userName
            version.text = args.currentItem.version
            stateDet.text = args.currentItem.status.state
        }

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}