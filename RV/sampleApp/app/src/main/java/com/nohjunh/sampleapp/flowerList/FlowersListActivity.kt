package com.nohjunh.sampleapp.flowerList

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nohjunh.sampleapp.R
import com.nohjunh.sampleapp.addFlower.AddFlowerActivity
import com.nohjunh.sampleapp.addFlower.FLOWER_DESCRIPTION
import com.nohjunh.sampleapp.addFlower.FLOWER_NAME
import com.nohjunh.sampleapp.data.Flower
import com.nohjunh.sampleapp.flowerDetail.FlowerDetailActivity

const val FLOWER_ID = "flower id"

class FlowersListActivity : AppCompatActivity() {

    private val newFlowerActivityRequestCode = 1
    private val flowerListViewModel by viewModels<FlowersListViewModel> {
        FlowersListViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ConcatAdapter는 여러 개의 Adapter들을 담는 틀과 같은 역할을 함.
        val headerAdapter = HeaderAdapter()
        val flowersAdapter = FlowersAdapter { flower -> adapterOnClick(flower) }
        val concatAdapter = ConcatAdapter(headerAdapter, flowersAdapter)
        val recylcerView : RecyclerView = findViewById(R.id.recycler_view)
        recylcerView.adapter = concatAdapter

        flowerListViewModel.flowersLiveData.observe(this) {
            it?.let {
                flowersAdapter.submitList(it as MutableList<Flower>)
                headerAdapter.updateFLowerCount(it.size)
            }
        }

        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener {
            fabOnClick()
        }

    }

    // fab View 클릭했을 때 flower 추가하는 Activity open
    private fun fabOnClick() {
        val intent = Intent(this, AddFlowerActivity::class.java)
        startActivityForResult(intent, newFlowerActivityRequestCode)
    }


    // 해당 RecyclerView item에 클릭이벤트 발생 시 FlowerDetailActivity Open
    private fun adapterOnClick(flower : Flower) {
        Log.d("RecycleView Item", "Click!!!")
        val intent = Intent(this, FlowerDetailActivity::class.java)
        intent.putExtra(FLOWER_ID, flower.id)
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        /* Insert flower into viewModel */
        if (requestCode == newFlowerActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.let { data ->
                val flowerName = data.getStringExtra(FLOWER_NAME)
                val flowerDescription = data.getStringExtra(FLOWER_DESCRIPTION)

                flowerListViewModel.insertFlower(flowerName, flowerDescription)
            }
        }
    }
}