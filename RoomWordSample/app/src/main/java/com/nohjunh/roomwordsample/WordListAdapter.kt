package com.nohjunh.roomwordsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nohjunh.roomwordsample.WordListAdapter.WordViewHolder


// ListAdapter를 확장하는 WordListAdapter Class 정의
class WordListAdapter : ListAdapter<Word, WordViewHolder>(WORDS_COMPARATOR) {

    // onCreateViewHolder에서 WordViewHolder를 만들고
    // onBindViewHolder에서 바인딩을 진행하는 구조

    // The ViewHolder that will display each word in our list.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.word)
    }

    // WordViewHolder 클래스를 통해 텍스트를 TextView에 바인딩
    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val wordItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            wordItemView.text = text
        }

        //The class exposes a static create() function that handles inflating the layout.
        companion object {
            fun create(parent: ViewGroup): WordViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return WordViewHolder(view)
            }
        }
    }

    //The WordsComparator defines how to compute if two words are the same or if the contents are the same.
    companion object {
        private val WORDS_COMPARATOR = object : DiffUtil.ItemCallback<Word>() {
            override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
                return oldItem.word == newItem.word
            }
        }
    }
}