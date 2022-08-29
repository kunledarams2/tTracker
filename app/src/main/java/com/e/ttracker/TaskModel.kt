package com.e.ttracker

import androidx.compose.ui.graphics.Color

data class TaskModel(
    val description:String,
    val color: Color
)

data class TaskProgressModel(
    val task:String,
    val color: Color,
    val progress: Float
)
