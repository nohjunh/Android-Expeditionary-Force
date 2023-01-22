package com.nohjunh.basicviewpager2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.nohjunh.basicviewpager2.R
import com.nohjunh.basicviewpager2.adapter.AdBannerAdapter
import com.nohjunh.basicviewpager2.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        
        /* Banner 배너 관련 코드 진행부 */
        var viewPagerId = binding.advertisingBanner

        // 데이터
        var bannerItems: Array<Int> =
            arrayOf(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3) // 보여줄 배너가 3개인 상황
        
        // Adapter 초기화 ( bannerItems DataSet 삽입 )
        var adBannerAdapter = AdBannerAdapter(bannerItems)

        // Adapter 적용
        viewPagerId.adapter = adBannerAdapter

        // 가로방향
        viewPagerId.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // 배너 몇 페이지인지 text 출력값
        var currentPosition = 0
        var txtCurrentBannerPage = binding.txtCurrentBanner
        txtCurrentBannerPage.text = getString(R.string.viewpager2_banner, 1, bannerItems.size)
        viewPagerId.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            // 사용자가 배너를 스크롤 했을 때 그에 따른 position 수정
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                txtCurrentBannerPage.text = getString(
                    R.string.viewpager2_banner,
                    position + 1,
                    bannerItems.size
                )
                if (currentPosition > 2) currentPosition = 0 // 보여줄 배너가 3개인 상황
            }
        })

        // 페이지 변경하기
        fun setPage() {
            if (currentPosition > 2) currentPosition = 0 // 보여줄 배너가 3개인 상황
            viewPagerId.setCurrentItem(currentPosition, true)
            currentPosition += 1
        }

        // 1.5초마다 페이지 자동 슬라이드 (Activity)
        CoroutineScope(Dispatchers.Main).launch {
            while(true) {
                setPage()
                delay(1500)
            }
        }

        /* // 1.5초마다 페이지 자동 슬라이드 (Fragment)
                // 1.5초마다 페이지 자동 슬라이드
        viewLifecycleOwner.lifecycleScope.launch {
            while (true) {
                setPage()
                delay(1500)
            }
        }
        */

    }

}