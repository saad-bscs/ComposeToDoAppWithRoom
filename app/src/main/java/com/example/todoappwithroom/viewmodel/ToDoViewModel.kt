package com.example.todoappwithroom.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoappwithroom.Utils.MainApplication
import com.example.todoappwithroom.Utils.ToDo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant
import java.util.Date

class ToDoViewModel : ViewModel() {

    val toDoDao = MainApplication.toDoDatabase.getToDoDao()
    val toDoList: LiveData<List<ToDo>> = toDoDao.getAllToDo()

    @RequiresApi(Build.VERSION_CODES.O)
    fun addToDo(title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            toDoDao.addToDo(ToDo(title = title, createdAt = Date.from(Instant.now())))
        }
    }

    fun deleteToDo(id: Int) {

        viewModelScope.launch(Dispatchers.IO) {
            toDoDao.deleteToDo(id)
        }
    }

    fun updateToDo(id: Int, title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            toDoDao.updateToDo(id, title)
        }
    }

    fun singleToDo(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            toDoDao.getSingleToDo(id)
        }
    }

}