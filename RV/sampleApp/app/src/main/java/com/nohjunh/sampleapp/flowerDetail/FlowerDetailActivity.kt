package com.nohjunh.sampleapp.flowerDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import com.nohjunh.sampleapp.R
import com.nohjunh.sampleapp.flowerList.FLOWER_ID

class FlowerDetailActivity : AppCompatActivity() {

    private val flowerDetailViewModel by viewModels<FlowerDetailViewModel> {
        FlowerDetailViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flower_detail)

        var currentFlowerId : Long? = null

        /* Connect variables to UI elements */
        val flowerName : TextView = findViewById(R.id.flower_detail_name)
        val flowerDescription : TextView = findViewById(R.id.flower_detail_description)
        val flowerImage : ImageView = findViewById(R.id.flower_detail_image)
        val removeFlowerBtn : Button = findViewById(R.id.remove_button)

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            currentFlowerId = bundle.getLong(FLOWER_ID)
        }

        /* currentFlowerId가 null이 아니라면, 해당하는 flower의 data를 얻고, name과 image, description을 setting*/
        currentFlowerId?.let {
            val currentFlower = flowerDetailViewModel.getFlowerForId(it)
            if (currentFlower?.image == null) { // 이미지가 없으면 rose 이미지로 통일
                flowerImage.setImageResource(R.drawable.rose)
            } else { // 있으면 해당 이미지로 이미지리소스 셋팅
                flowerImage.setImageResource(currentFlower.image)
            }
            flowerDescription.text = currentFlower?.description

            removeFlowerBtn.setOnClickListener {
                if (currentFlower != null) {
                    flowerDetailViewModel.removeFlower(currentFlower)
                }
                finish()
            }
        }


    }
}