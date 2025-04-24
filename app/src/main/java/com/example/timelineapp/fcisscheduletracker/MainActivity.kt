package com.example.timelineapp.fcisscheduletracker

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.timelineapp.R

class MainActivity : AppCompatActivity() {
    private lateinit var gradeSpinner: Spinner
    private lateinit var specializationSpinner: Spinner
    private lateinit var specializationLabel: TextView
    private lateinit var viewScheduleButton: Button
    
    private var selectedGrade = 1
    private var selectedSpecialization = "CS"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Initialize views
        gradeSpinner = findViewById(R.id.gradeSpinner)
        specializationSpinner = findViewById(R.id.specializationSpinner)
        specializationLabel = findViewById(R.id.specializationLabel)
        viewScheduleButton = findViewById(R.id.viewScheduleButton)
        
        // Set up grade spinner
        val grades = arrayOf("Year 1", "Year 2", "Year 3", "Year 4")
        val gradeAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, grades)
        gradeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        gradeSpinner.adapter = gradeAdapter
        
        // Set up specialization spinner
        val specializations = arrayOf("CS", "IT", "CN")
        val specializationAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, specializations)
        specializationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        specializationSpinner.adapter = specializationAdapter
        
        // Initially hide specialization options (only shown for 4th year)
        specializationLabel.visibility = View.GONE
        specializationSpinner.visibility = View.GONE
        
        // Set up listeners
        gradeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedGrade = position + 1
                
                // Show specialization options only for 4th year
                if (selectedGrade == 4) {
                    specializationLabel.visibility = View.VISIBLE
                    specializationSpinner.visibility = View.VISIBLE
                } else {
                    specializationLabel.visibility = View.GONE
                    specializationSpinner.visibility = View.GONE
                }
            }
            
            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }
        
        specializationSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedSpecialization = specializations[position]
            }
            
            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }
        
        viewScheduleButton.setOnClickListener {
            val intent = Intent(this, ScheduleActivity::class.java).apply {
                putExtra("GRADE", selectedGrade)
                putExtra("SPECIALIZATION", selectedSpecialization)
            }
            startActivity(intent)
        }
    }
}
