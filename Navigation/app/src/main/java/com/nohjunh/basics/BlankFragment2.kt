package com.nohjunh.basics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.nohjunh.basics.databinding.FragmentBlank2Binding

class BlankFragment2 : Fragment() {

    private var _binding : FragmentBlank2Binding? = null
    private val binding get() = _binding!!

    // 이전 프래그먼트로부터 전달받은 데이터 받기(safeArgs)
    val safeArgs : BlankFragment2Args by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBlank2Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ShowTV.text = safeArgs.key

        binding.btn2.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_blankFragment2_to_blankFragment3)
        }

    }

}