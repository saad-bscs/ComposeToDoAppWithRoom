package com.example.todoappwithroom.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.todoappwithroom.Utils.ToDo

@Dao
interface ToDoDao {

    @Query("SELECT * FROM ToDo WHERE id = :id")
    fun getSingleToDo(id: Int): ToDo

    @Query("SELECT * FROM ToDo ORDER BY createdAt DESC")
    fun getAllToDo(): LiveData<List<ToDo>>

    @Insert
    fun addToDo(toDo: ToDo)

    @Query("DELETE from ToDo where id = :id")
    fun deleteToDo(id: Int)

    @Query("UPDATE ToDo SET title = :title WHERE id = :id")
    fun updateToDo(id: Int, title: String)

}