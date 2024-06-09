package com.example.historyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.historyapp.R.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    private lateinit var editTextAge: EditText
    private lateinit var textViewHistory: TextView
    private lateinit var matchButton: Button
    private lateinit var clearButton: Button
    private lateinit var exitButton: Button
    private lateinit var textView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        editTextAge = findViewById(R.id.editTextAge)
        textViewHistory = findViewById(R.id.textViewHistory)
        matchButton = findViewById(R.id.macthButton)
        clearButton = findViewById(R.id.clearButton)
        exitButton = findViewById(R.id.exitButton)
        textView = findViewById(R.id.textView)


        matchButton.setOnClickListener {
            matchButton()
        }
        clearButton.setOnClickListener {
            editTextAge.text?.clear()
            textView.text = ""
        }
        exitButton.setOnClickListener {
            moveTaskToBack(true)
            android.os.Process.killProcess(android.os.Process.myPid())
            exitProcess(1)
        }
    }

    private fun matchButton() {
        // check if the inputAge is empty
         val inputAge = editTextAge.text.toString()
        if (inputAge.isEmpty()) {
            textView.text = getString(R.string.text)
            return
        }
            //check if the age is valid
        val age = inputAge.toIntOrNull()
        if (age == null){
            textView.text = getString(R.string.invalid_range_message)
            return
        }
            // check if the age is out of the range
        if (age < 20 || age > 100) {
            textView.text = getString(R.string.incorrect_age)
            return
        }

        val matchedPerson = personHistory(age)
        textView.text = matchedPerson
    }

        // declaration of an array
    private fun personHistory(age: Int): String {
        // initialize the mapOf
        val personHistory = mapOf(
             "Anne Bronte" to 29 ,
            " Wolfgang Lincoln " to 35,
            " Cleopatra  " to 39,
            " Edgar Allan Peo " to 40,
            " Steve Jobs " to 56,
            " Marie Curie " to 66,
            " Leonardo da Vinci " to 67,
            " Albert Einstein " to 76,
            " Mother Teresa " to 87,
            " Pablo Picasso " to 92
        )
        // check if the age is in the array
        for ((person, personAge) in personHistory) {
            if (age == personAge) {
                return "You have the same age with $person when they passed away"
            }
        }

        return "No Match!"
    }

}






























