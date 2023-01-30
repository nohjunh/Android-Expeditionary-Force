package com.nohjunh.basic.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nohjunh.basic.R
import com.nohjunh.basic.databinding.FragmentShowBinding
import com.nohjunh.basic.viewModel.MainViewModel

class ShowFragment : Fragment() {

    private var _binding : FragmentShowBinding? = null
    private val binding get() = _binding!!

    private val viewModel : MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentShowBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.countView.text= viewModel.getNumber().toString()

        binding.countPlus.setOnClickListener {
            viewModel.plus()
            binding.countView.text = viewModel.getNumber().toString()
        }

        binding.countMinus.setOnClickListener {
            viewModel.minus()
            binding.countView.text = viewModel.getNumber().toString()
        }
    }

}