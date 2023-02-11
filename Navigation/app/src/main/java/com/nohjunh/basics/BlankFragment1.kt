package com.nohjunh.basics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.nohjunh.basics.databinding.FragmentBlank1Binding

/*
 Navigation animation
1. enter A->B : A가 B로 갈 때 B가 어느 방향에서 오는 지를 연출
2. exit A->B : A가 B로 갈 때 A가 어느 방향으로 사라질 지 연출
3. PopEnter B->A : B에서 A로 뒤로 갈 때 A가 어느 방향에서 들어오는 지를 연출
4. PopExit B->A : B에서 A로 뒤로 갈 때 B가 어느 방향으로 사라질 지 연출
*/

class BlankFragment1 : Fragment() {

    private var _binding : FragmentBlank1Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlank1Binding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 프래그먼트 전환 시 데이터 전달하기
        val action = BlankFragment1Directions.actionBlankFragment1ToBlankFragment2("이거 보낼게요")

        binding.btn1.setOnClickListener {
        //  Navigation.findNavController(view).navigate(R.id.action_blankFragment1_to_blankFragment2)
            Navigation.findNavController(view).navigate(action)
        }
    }


}