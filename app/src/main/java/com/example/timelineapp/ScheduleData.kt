package com.example.timelineapp

// Data class to represent a schedule item
data class ScheduleItem(
    val time: String,
    val course: String,
    val location: String,
    val doctor:String =""
)

// Static class to provide schedule data
object ScheduleData {
    // Days of the week
    private const val SUNDAY = 0
    private const val MONDAY = 1
    private const val TUESDAY = 2
    private const val WEDNESDAY = 3
    private const val THURSDAY = 4
    
    // Get schedule for a specific grade, specialization, and day
    fun getSchedule(grade: Int, specialization: String, day: Int): List<ScheduleItem> {
        return when (grade) {
            1 -> getFirstYearSchedule(day)
            2 -> getSecondYearSchedule(day)
            3 -> getThirdYearSchedule(day)
            4 -> getFourthYearSchedule(specialization, day)
            else -> emptyList()
        }
    }
    
    // First year schedule
    private fun getFirstYearSchedule(day: Int): List<ScheduleItem> {
        return when (day) {
            SUNDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Introduction to Computer Science", "Hall 1"),
                ScheduleItem("10:45 - 12:15", "Mathematics I", "Hall 2"),
                ScheduleItem("12:30 - 14:00", "Physics", "Lab 1")
            )
            MONDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "English for CS", "Hall 3"),
                ScheduleItem("10:45 - 12:15", "Programming Fundamentals", "Lab 2"),
                ScheduleItem("12:30 - 14:00", "Discrete Mathematics", "Hall 1")
            )
            TUESDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Mathematics I (Tutorial)", "Hall 4"),
                ScheduleItem("10:45 - 12:15", "Programming Fundamentals (Lab)", "Lab 3"),
                ScheduleItem("12:30 - 14:00", "Introduction to Computer Science (Tutorial)", "Hall 2")
            )
            WEDNESDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Physics (Lab)", "Lab 1"),
                ScheduleItem("10:45 - 12:15", "Discrete Mathematics (Tutorial)", "Hall 3"),
                ScheduleItem("12:30 - 14:00", "Professional Ethics", "Hall 4")
            )
            THURSDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Technical Writing", "Hall 1"),
                ScheduleItem("10:45 - 12:15", "Critical Thinking", "Hall 2")
            )
            else -> emptyList()
        }
    }
    
    // Second year schedule
    private fun getSecondYearSchedule(day: Int): List<ScheduleItem> {
        return when (day) {
            SUNDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Data Structures", "Hall 1"),
                ScheduleItem("10:45 - 12:15", "Object-Oriented Programming", "Lab 1"),
                ScheduleItem("12:30 - 14:00", "Mathematics II", "Hall 2")
            )
            MONDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Digital Logic Design", "Hall 3"),
                ScheduleItem("10:45 - 12:15", "Statistics & Probability", "Hall 4"),
                ScheduleItem("12:30 - 14:00", "Data Structures (Lab)", "Lab 2")
            )
            TUESDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Object-Oriented Programming (Lab)", "Lab 3"),
                ScheduleItem("10:45 - 12:15", "Mathematics II (Tutorial)", "Hall 1"),
                ScheduleItem("12:30 - 14:00", "Digital Logic Design (Lab)", "Lab 1")
            )
            WEDNESDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Statistics & Probability (Tutorial)", "Hall 2"),
                ScheduleItem("10:45 - 12:15", "Computer Organization", "Hall 3"),
                ScheduleItem("12:30 - 14:00", "Technical Report Writing", "Hall 4")
            )
            THURSDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Computer Organization (Tutorial)", "Hall 1"),
                ScheduleItem("10:45 - 12:15", "Algorithms Analysis", "Hall 2"),
                ScheduleItem("12:30 - 14:00", "Algorithms Analysis (Tutorial)", "Hall 3")
            )
            else -> emptyList()
        }
    }
    
    // Third year schedule
    private fun getThirdYearSchedule(day: Int): List<ScheduleItem> {
        return when (day) {
            SUNDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Database Systems", "Hall 1"),
                ScheduleItem("10:45 - 12:15", "Operating Systems", "Hall 2"),
                ScheduleItem("12:30 - 14:00", "Computer Networks", "Hall 3")
            )
            MONDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Software Engineering", "Hall 4"),
                ScheduleItem("10:45 - 12:15", "Database Systems (Lab)", "Lab 1"),
                ScheduleItem("12:30 - 14:00", "Operating Systems (Lab)", "Lab 2")
            )
            TUESDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Computer Networks (Lab)", "Lab 3"),
                ScheduleItem("10:45 - 12:15", "Web Programming", "Hall 1"),
                ScheduleItem("12:30 - 14:00", "Software Engineering (Tutorial)", "Hall 2")
            )
            WEDNESDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Web Programming (Lab)", "Lab 1"),
                ScheduleItem("10:45 - 12:15", "Artificial Intelligence", "Hall 3"),
                ScheduleItem("12:30 - 14:00", "Theory of Computation", "Hall 4")
            )
            THURSDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Artificial Intelligence (Lab)", "Lab 2"),
                ScheduleItem("10:45 - 12:15", "Theory of Computation (Tutorial)", "Hall 1"),
                ScheduleItem("12:30 - 14:00", "Project Management", "Hall 2")
            )
            else -> emptyList()
        }
    }
    
    // Fourth year schedule based on specialization
    private fun getFourthYearSchedule(specialization: String, day: Int): List<ScheduleItem> {
        return when (specialization) {
            "CS" -> getCSSchedule(day)
            "IT" -> getITSchedule(day)
            "CN" -> getCNSchedule(day)
            else -> emptyList()
        }
    }
    
    // Computer Science specialization schedule
// Computer Science specialization schedule
    private fun getCSSchedule(day: Int): List<ScheduleItem> {
        return when (day) {
            SUNDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Parallel Programming", "Hall 1","Dr. Alnomery"),
                ScheduleItem("10:45 - 12:15", "Android Programming", "Hall 2", "Dr. Rania Nashaat"),
            )
            MONDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Pattern Recognition", "Hall 3","Dr. Rania Ramadan"),
                ScheduleItem("10:45 - 12:15", "Android Programming (Lab)", "Lab 2", "Dr. Toaa"),
                ScheduleItem("12:30 - 14:00", "Parallel Programming (Tutorial)", "Hall 4","Dr. Abo Al-Saud")
            )
            TUESDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Pattern Recognition (Lab)", "Lab 3","Dr. Nourhan"),
                ScheduleItem("10:45 - 12:15", "Image Processing", "Hall 1","Dr. Rania Ramadan"),
            )
            WEDNESDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Image Processing (Lab)", "Lab 2","Dr. Zyad Bahaa"),
                ScheduleItem("10:45 - 12:15", "Computer Automation", "Hall 2","Dr. Seham"),
            )
            THURSDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Computer Automation (Lab)", "Lab 1","Dr. Saber"),
            )
            else -> emptyList()
        }
    }
    
    // Information Technology specialization schedule
    private fun getITSchedule(day: Int): List<ScheduleItem> {
        return when (day) {
            SUNDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Cloud Computing", "Hall 1"),
                ScheduleItem("10:45 - 12:15", "IT Project Management", "Hall 2"),
                ScheduleItem("12:30 - 14:00", "Graduation Project", "Lab 1")
            )
            MONDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Information Security", "Hall 3"),
                ScheduleItem("10:45 - 12:15", "Cloud Computing (Lab)", "Lab 2"),
                ScheduleItem("12:30 - 14:00", "IT Project Management (Tutorial)", "Hall 4")
            )
            TUESDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Information Security (Lab)", "Lab 3"),
                ScheduleItem("10:45 - 12:15", "Enterprise Systems", "Hall 1"),
                ScheduleItem("12:30 - 14:00", "Graduation Project", "Lab 1")
            )
            WEDNESDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Enterprise Systems (Lab)", "Lab 2"),
                ScheduleItem("10:45 - 12:15", "Mobile Application Development", "Hall 2"),
                ScheduleItem("12:30 - 14:00", "IT Service Management", "Hall 3")
            )
            THURSDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Mobile Application Development (Lab)", "Lab 1"),
                ScheduleItem("10:45 - 12:15", "IT Service Management (Tutorial)", "Hall 1"),
                ScheduleItem("12:30 - 14:00", "Graduation Project", "Lab 2")
            )
            else -> emptyList()
        }
    }
    
    // Computer Networks specialization schedule
    private fun getCNSchedule(day: Int): List<ScheduleItem> {
        return when (day) {
            SUNDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Advanced Networks", "Hall 1"),
                ScheduleItem("10:45 - 12:15", "Network Security", "Hall 2"),
                ScheduleItem("12:30 - 14:00", "Graduation Project", "Lab 1")
            )
            MONDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Wireless Networks", "Hall 3"),
                ScheduleItem("10:45 - 12:15", "Advanced Networks (Lab)", "Lab 2"),
                ScheduleItem("12:30 - 14:00", "Network Security (Tutorial)", "Hall 4")
            )
            TUESDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Wireless Networks (Lab)", "Lab 3"),
                ScheduleItem("10:45 - 12:15", "Network Administration", "Hall 1"),
                ScheduleItem("12:30 - 14:00", "Graduation Project", "Lab 1")
            )
            WEDNESDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Network Administration (Lab)", "Lab 2"),
                ScheduleItem("10:45 - 12:15", "Internet of Things", "Hall 2"),
                ScheduleItem("12:30 - 14:00", "Network Programming", "Hall 3")
            )
            THURSDAY -> listOf(
                ScheduleItem("09:00 - 10:30", "Internet of Things (Lab)", "Lab 1"),
                ScheduleItem("10:45 - 12:15", "Network Programming (Lab)", "Lab 3"),
                ScheduleItem("12:30 - 14:00", "Graduation Project", "Lab 2")
            )
            else -> emptyList()
        }
    }
}
