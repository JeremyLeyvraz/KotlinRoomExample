package com.lj.app

import androidx.lifecycle.ViewModel
import com.lj.libraryExample.Example
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
) : ViewModel() {

    fun getText(): String = Example().test

}