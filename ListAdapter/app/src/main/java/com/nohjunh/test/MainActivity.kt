package com.nohjunh.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.nohjunh.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var adapterEx : AdapterEx

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val view : View = binding.root

        setUpRecylcerView()
        setupTouchHelper(view)

        viewModel.liveDataSet.observe(this, Observer {
            adapterEx.submitList(it)
        })

        viewModel.start()

    }

    private fun setUpRecylcerView() {
        adapterEx = AdapterEx()

        binding.rvView.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.VERTICAL
                )
            )
        }

        binding.rvView.adapter = adapterEx

        // click리스너 설정
        adapterEx.exHolderClickListener =
            object : AdapterEx.ExHolderClickListener {
                override fun onClick(view: View, position: Int, data: DataEx) {
                    Snackbar.make(view, "${data.name}을(를) 클릭했습니다.", Snackbar.LENGTH_SHORT).show()
                }
            }
    }

    // RecyclerView의 item을 스와이프 하는데에 SimpleCallback을 사용
    // 우선 SimpleCallback의 인스턴스를 만들고
    // attachToRecyclerView로 RecyclerView를 연결해주면
    // 각 아이템이 스와이프나 드래그 동작을 인식할 수 있게 된다.
    private fun setupTouchHelper(view : View) {
        // simpleCallback 정의
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            // 인식할 드래그 방향은 dragDirs로 설정하는데 여기서는 드래그는
            // 사용하지 않으므로 0으로 설정
            // 스와이프 방향은 LEFT만 인식시킴
            0, ItemTouchHelper.LEFT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                // onMove는 사용하지 않을 것이므로 return true로 설정
                return true
            }

            // onSwiped에서는 스와이프 동작이 발생했을 떄 동작을 정의한다.
            // 스와이프가 이루어지면 데이터가 삭제 된다.
            // 터치한 ViewHolder 위치를 getbindingAdapterPosition으로
            // 획득한 다음에 Adapter의 currentList에 넣어
            // 해당하는 item의 데이터 인스턴스를 획득한다.
            // 그 후 delete를 진행한다.
            // 만약, 데이터를 지운 상태를 되돌리고 싶은 경우를 위해
            // SnackBar의 setAction의 "Undo"를 이용하면 된다. ("Undo"는 사용자 지정이기에 마음대로 바꿔도 됨.)
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val dataInstance = adapterEx.currentList[position]
                /*
                    스와이프를 취했을 때 동작 정의
                 */
                //dataSet.removeAt(position)
                //_liveDataSet.value = dataSet

                Snackbar.make(view, "${dataInstance.name}의 스와이프 감지", Snackbar.LENGTH_SHORT).apply {
                    setAction("취소") {
                        /*
                            취소를 눌렀을 때 취할 동작 정의
                         */
                        viewModel.addData(adapterEx.currentList)
                    }
                }.show()
            }
        }
        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(binding.rvView)
        }
    }

}