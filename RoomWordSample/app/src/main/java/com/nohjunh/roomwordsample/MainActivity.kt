package com.nohjunh.roomwordsample

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val newWordActivityRequestCode = 1 // 요청코드 정의
    /*
    To create the ViewModel you used the viewModels delegate,
    passing in an instance of our WordViewModelFactory.
     This is constructed based on the repository retrieved from the WordsApplication.
     */
    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((application as WordsApplication).repository)
    }

    // MainActivity의 onCreate() 메소드에 RecyclerView 추가
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = WordListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        // fab를 터치 시 NewWordActivity Intent(열림)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, NewWordActivity::class.java)
            startActivityForResult(intent, newWordActivityRequestCode)
        }


        // DB로부터 최신화된 data를 display하기 위해 onCreate()에서
        // ViewModel에서 LiveData를 observe하는 observer를 추가
        // -> 여기서는 WordViewModel의 allWords LiveData observer 추가
        // observe하고 있는 data가 변경될 때마다 onChanged()콜백 메소드(람다의 디폴트 메소드)가 호출되므로
        // Adapter의 setWords()를 호출하여 Adapter의 캐시된 data를 업데이트 -> displayed list를 새로 고침.
        wordViewModel.allWords.observe(owner = this) { words ->
            // Update the cached copy of the words in the adapter.
            words.let { adapter.submitList(it) }
        }
    }

    // MainActivity에서 NewWordActivity의 onActivityResult() 추가
    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        // Activity가 RESULT_OK로 반환되면 (NewWordActivity에서 RESULT_OK를 반환하면)
        // WordViewModel의 insert()를호출하여 반환된 word를 DB에 삽입
        if (requestCode == newWordActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.getStringExtra(NewWordActivity.EXTRA_REPLY)?.let { reply ->
                val word = Word(reply)
                wordViewModel.insert(word)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}