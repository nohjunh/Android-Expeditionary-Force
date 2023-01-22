package com.nohjunh.basiccoil

import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.Coil
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.nohjunh.basiccoil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.image1Btn.setOnClickListener {
            binding.image1.load(R.drawable.camping)
        }

        /* coil GIF 확장 라이브러리 */
        val imageLoader = this?.let {
            ImageLoader.Builder(it)
                .components {
                    if (SDK_INT >= 28) {
                        add(ImageDecoderDecoder.Factory())
                    } else {
                        add(GifDecoder.Factory())
                    }
                }
                .build()
        }
        if (imageLoader != null) {
            Coil.setImageLoader(imageLoader)
        }

        binding.image2Btn.setOnClickListener {
            binding.image2.load(R.drawable.airplane)
        }
        ////////////////////////////////////////

        /* fade in 애니메이션 */
        binding.image3Btn.setOnClickListener {
            binding.image3.load(R.drawable.dolphin) {
                crossfade(2000)
            }
        }

        /* 원형으로 자르기 */
        binding.image4Btn.setOnClickListener {
            binding.image4.load(R.drawable.tv) {
                transformations(CircleCropTransformation())
            }
        }

        /* 이미지 리사이징 and 모서리 라운드 */
        binding.image5Btn.setOnClickListener {
            binding.image5.load(R.drawable.recorder) {
                size(30)
                transformations(RoundedCornersTransformation(10f,10f, 20f, 20f)) // 모서리 라운드
            }
        }
    }
}