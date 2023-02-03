package com.nohjunh.simpletest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nohjunh.simpletest.R
import com.nohjunh.simpletest.adapter.ContentAdapter
import com.nohjunh.simpletest.database.entity.ContentEntity
import com.nohjunh.simpletest.databinding.ActivityMainBinding
import com.nohjunh.simpletest.viewModel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val viewModel : MainViewModel by viewModels()

    private var contentList = ArrayList<ContentEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 로딩 되었을 때 바로 content가 보이도록
        viewModel.getAllContent()

        viewModel.contentList.observe(this, Observer {
            contentList.clear()
            for (temp in it) {
                contentList.add(temp)
            }
            Timber.tag("TEST").e("observer")
            setContentListRV()
        })

        // content가 삭제된게 있는지 관찰
        viewModel.deleteCheck.observe(this, Observer {
            if(it == true){
                viewModel.getAllContent()
            }
        })

        binding.sendBtn.setOnClickListener {
            viewModel.insertContent(binding.ETview.text.toString())
            binding.ETview.setText("")
            viewModel.getAllContent()
        }
    }

    private fun setContentListRV() {
        val contentAdapter = ContentAdapter(this, contentList)
        binding.rvContainer.adapter = contentAdapter
        binding.rvContainer.layoutManager = LinearLayoutManager(this)
        // 맨 밑부터 보이게
        binding.rvContainer.scrollToPosition(contentList.size-1)
        // onClick 구현
        contentAdapter.delBtnClick = object : ContentAdapter.DelBtnClick {
            override fun onClick(view : View, position: Int) {
                Timber.tag("삭제버튼클릭").e("${contentList[position].id}")
                viewModel.delSelectContent(contentList[position].id)
            }
        }
    }
}