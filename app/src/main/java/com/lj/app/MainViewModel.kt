package com.lj.app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lj.libraryExample.User
import com.lj.libraryExample.UserDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userDao: UserDao
) : ViewModel() {

    private var _allUsers by mutableStateOf(emptyList<User>())

    /**
     * All saved bankrolls
     */
    val allUsers : List<User>
        get() = _allUsers

    /**
     * Load all saved bankrolls.
     */
    fun loadAllUser() {
        viewModelScope.launch(Dispatchers.IO) {
            getUsers().collect {
                _allUsers = it
            }
        }
    }






    fun getUsers(): Flow<List<User>> = userDao.getAllUsers()

    fun addUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            userDao.insert(user)
        }
    }
}
