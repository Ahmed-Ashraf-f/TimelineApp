package com.example.timelineapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ScheduleActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dayTabs: Array<TextView>
    private var currentDay = 0 // 0 = Sunday, 1 = Monday, etc.
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)
        
        // Get data from intent
        val grade = intent.getIntExtra("GRADE", 1)
        val specialization = intent.getStringExtra("SPECIALIZATION") ?: "CS"
        
        // Set title based on grade and specialization
        val title = if (grade == 4) {
            "Year $grade - $specialization"
        } else {
            "Year $grade"
        }
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        
        // Initialize day tabs
        dayTabs = arrayOf(
            findViewById(R.id.sundayTab),
            findViewById(R.id.mondayTab),
            findViewById(R.id.tuesdayTab),
            findViewById(R.id.wednesdayTab),
            findViewById(R.id.thursdayTab)
        )
        
        // Set up tab click listeners
        for (i in dayTabs.indices) {
            dayTabs[i].setOnClickListener {
                selectDay(i)
            }
        }
        
        // Initialize RecyclerView
        recyclerView = findViewById(R.id.scheduleRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        
        // Select Sunday by default
        selectDay(0)
    }
    
    private fun selectDay(day: Int) {
        // Update tab selection UI
        for (i in dayTabs.indices) {
            if (i == day) {
                dayTabs[i].setBackgroundResource(R.drawable.selected_tab_background)
            } else {
                dayTabs[i].setBackgroundResource(R.drawable.unselected_tab_background)
            }
        }
        
        currentDay = day
        
        // Get schedule data for the selected day, grade, and specialization
        val grade = intent.getIntExtra("GRADE", 1)
        val specialization = intent.getStringExtra("SPECIALIZATION") ?: "CS"
        val scheduleItems = ScheduleData.getSchedule(grade, specialization, day)
        
        // Update RecyclerView
        recyclerView.adapter = ScheduleAdapter(scheduleItems)
    }
    
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    
    // Adapter for the RecyclerView
    inner class ScheduleAdapter(private val items: List<ScheduleItem>) : 
            RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {
        
        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val timeTextView: TextView = view.findViewById(R.id.timeTextView)
            val courseTextView: TextView = view.findViewById(R.id.courseTextView)
            val locationTextView: TextView = view.findViewById(R.id.locationTextView)
            val DrTextView: TextView = view.findViewById(R.id.DrTextView)
        }
        
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.schedule_item, parent, false)
            return ViewHolder(view)
        }
        
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = items[position]
            holder.timeTextView.text = item.time
            holder.courseTextView.text = item.course
            holder.locationTextView.text = item.location
            holder.DrTextView.text = item.doctor
        }
        
        override fun getItemCount() = items.size
    }
}
