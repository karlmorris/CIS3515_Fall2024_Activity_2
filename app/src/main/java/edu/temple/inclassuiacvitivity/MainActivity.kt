package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* TODO Step 2: Populate this array with multiples of 5 from 5 - 100*/
        val numberArray = IntArray(20) { i -> (i + 1) * 5 }.toList()
        Log.d("array output",numberArray.toString())

        /* TODO Step 3: Create adapter to display items from array in Spinner */
        //spinner.adapter = ArrayAdapter...
        val numberList = numberArray.map { it.toString() }
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, numberList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter


        // TODO Step 4: Change TextView's text size to the number selected in the Spinner */
        //spinner.onItemSelectedListener = object: ...
        // TODO Step 4: Change TextView's text size to the number selected in the Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // Get the selected number
                val selectedNumber = numberArray[position]

                // Set the TextView's text to display the selected number
                displayTextView.text = "Selected: $selectedNumber"

                // Change the TextView's text size based on the selected number
                displayTextView.textSize = selectedNumber.toFloat() // Set text size
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                displayTextView.text = "Please select a number."
            }
        }


    }
}