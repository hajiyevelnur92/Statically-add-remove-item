package com.studydrive.task

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val dao = (application as CreateItemApp).dao

    val items = dao.query()

    fun addItem(todo: CreateItem) {
        dao.insert(todo)
    }

    fun deleteById(id: String) {
        dao.deleteById(id)
    }

    fun deleteAll() {
        dao.deleteAll()
    }

}