package com.studydrive.task

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room

class CreateItemApp : Application() {

    var viewModelFactory: ViewModelProvider.AndroidViewModelFactory? = null

    lateinit var dao: CreateItemDao

    override fun onCreate() {
        super.onCreate()

        dao = Room.databaseBuilder(this, CreateItemDatabase::class.java, "createItem")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
                .dao()

        viewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(this)
    }

}