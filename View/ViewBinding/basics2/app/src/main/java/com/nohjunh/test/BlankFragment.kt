package com.nohjunh.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nohjunh.test.databinding.FragmentBlankBinding

class BlankFragment : Fragment() {

    // OnCreateView()에서 LayoutInflater(inflater:LayutInflater)를 받기에
    // null값으로 선언하고 시작
    private var _binding : FragmentBlankBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // binding.textView.text = "~~"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}