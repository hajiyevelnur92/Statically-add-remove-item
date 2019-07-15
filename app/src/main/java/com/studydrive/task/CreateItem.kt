package com.studydrive.task

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CreateItem(
        @PrimaryKey
        val id: String,
        val text: String
)
