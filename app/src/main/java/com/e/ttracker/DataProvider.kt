package com.e.ttracker

import androidx.compose.ui.graphics.Color

object DataProvider {

    val TaskTimeSlot = listOf(
        " 11:00am",
        "11:15am",
        "11:30am",
        "11:45am",
        "12:00pm",
        "12:15pm",
        "12:30pm"

    )

    val extraTimeSlot = listOf("Add ", "Subtract", "Stop")

    val taskDescription = listOf(TaskModel("Contact the CEO of Decagon", Color(0xFFD9D9D9)),
        TaskModel("Design the on-boarding session of Task Tracker App", Color(0xFFCAB8FD)),
        TaskModel("Remind the technical team to include the micro-interaction delivered",  Color(0xFFFDB8B8)),
       )

    val progressTaskSlot = listOf(
        TaskProgressModel("Task 1", Color(0xFFB8FDBB), 60.5f),
        TaskProgressModel("Task 2", Color(0xFFCAB8FD), 40.7f),
        TaskProgressModel("Task 3", Color(0xFFFDB8B8B), 20.5f),
        TaskProgressModel("Task 4", Color(0xFFFDE1B8),30.5f),
        TaskProgressModel("Task 5", Color(0xFF5398FF),80.9f),
        TaskProgressModel("Task 6", Color(0xFFF4511E),50.9f))
}