package com.lj.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import com.lj.libraryExample.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var text by remember { mutableStateOf("") }

            Column {
                Row {
                    TextField(
                        value = text,
                        onValueChange = { newText: String ->
                            text = newText
                        }
                    )
                }
                Row {
                    Button(onClick = {
                        mainViewModel.addUser(
                            User(
                                name = text,
                                age = 30,
                                id = 0
                            )
                        )
                    }) {
                        Text(text = "Add user")
                    }
                }
                Row {
                    // Load all bankrolls
                    LaunchedEffect(mainViewModel) {
                        mainViewModel.loadAllUser()
                    }
                    // Display each bankroll
                    LazyColumn {
                        items(mainViewModel.allUsers) {
                            Text(text = it.name)
                        }
                    }
                }
            }

        }
    }
}
