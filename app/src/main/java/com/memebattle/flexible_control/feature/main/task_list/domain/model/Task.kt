package com.memebattle.flexible_control.feature.main.task_list.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(var id: String) {
    @PrimaryKey
    lateinit var idKey: String
}