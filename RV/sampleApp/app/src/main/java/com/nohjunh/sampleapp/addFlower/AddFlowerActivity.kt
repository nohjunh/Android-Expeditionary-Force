package com.nohjunh.sampleapp.addFlower

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.nohjunh.sampleapp.R

const val FLOWER_NAME = "name"
const val FLOWER_DESCRIPTION = "description"

class AddFlowerActivity : AppCompatActivity() {

    private lateinit var addFlowerName : TextInputEditText
    private lateinit var addFlowerDescription : TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_flower_layout)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addFlower()
        }
        addFlowerName = findViewById(R.id.add_flower_name)
        addFlowerDescription = findViewById(R.id.add_flower_description)
    }

    /* The onClick action for the done button. Closes the activity and returns the new flower name
    and description as part of the intent. If the name or description are missing, the result is set
     to cancelled. */

    private fun addFlower() {
        val resultIntent = Intent()

        if(addFlowerName.text.isNullOrEmpty() || addFlowerDescription.text.isNullOrEmpty()) {
            setResult(Activity.RESULT_CANCELED, resultIntent)
        } else {
            val name = addFlowerName.text.toString()
            val description = addFlowerDescription.text.toString()
            resultIntent.putExtra(FLOWER_NAME, name)
            resultIntent.putExtra(FLOWER_DESCRIPTION, description)
            setResult(Activity.RESULT_OK, resultIntent)
        }
        finish()
    }

}