package com.memebattle.flexible_control.feature.main.task_list.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
class Task {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var _id: String? = null
    var created_at: String? = null
    var updated_at: String? = null
    var status: String? = null
    var lat: Float = 0.toFloat()
    var lng: Float = 0.toFloat()
    var name: String? = null
    var description: String? = null
    var isDone: Boolean = false
    var isChosen: Boolean = false
}