package com.example.todoappwithroom.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.todoappwithroom.Utils.Converters
import com.example.todoappwithroom.Utils.ToDo

@Database(entities = [ToDo::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ToDoDatabase: RoomDatabase() {

    companion object {
        const val NAME = "ToDo_DB"
    }

    abstract fun getToDoDao(): ToDoDao


}