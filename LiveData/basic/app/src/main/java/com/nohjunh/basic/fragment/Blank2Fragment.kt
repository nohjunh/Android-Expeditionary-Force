package com.nohjunh.basic.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.nohjunh.basic.databinding.FragmentBlank2Binding

class Blank2Fragment : Fragment() {

    private var _binding : FragmentBlank2Binding? = null
    private val binding get() = _binding!!

    private val viewModel : BlankViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBlank2Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.minusbtn2.setOnClickListener {
            viewModel.minusCountfunc()
        }

        viewModel.liveCount.observe(viewLifecycleOwner, Observer{
            binding.text2.text = it.toString()
        })
    }

}