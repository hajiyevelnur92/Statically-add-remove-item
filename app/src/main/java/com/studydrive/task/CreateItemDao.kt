package com.studydrive.task

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
abstract class CreateItemDao {

    @Query("SELECT * FROM createItem")
    abstract fun query(): LiveData<List<CreateItem>>

    @Insert
    abstract fun insert(createItem: CreateItem)

    @Query("delete from CreateItem where id = :id")
    abstract fun deleteById(id: String)

    @Query("delete from CreateItem")
    abstract fun deleteAll()

}