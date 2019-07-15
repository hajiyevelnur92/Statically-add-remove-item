package com.studydrive.task

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CreateItem::class], version = 1)
abstract class CreateItemDatabase : RoomDatabase() {

    abstract fun dao(): CreateItemDao

}