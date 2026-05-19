package com.example.urbanlink2.ui.theme.Screens.SelectScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onBackClick: () -> Unit
) {

    val sheetState = rememberModalBottomSheetState()

    var showBottomSheet by remember {
        mutableStateOf(false)
    }

    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // MAIN SCREEN CONTENT
        Scaffold(

            bottomBar = {

                NavigationBar {

                    // HOME
                    NavigationBarItem(
                        selected = true,
                        onClick = {
                            // Normal navigation
                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = "Home"
                            )
                        }
                    )

                    // MENU ITEM -> OPEN DRAWER
                    NavigationBarItem(
                        selected = false,
                        onClick = {


                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Flag,
                                contentDescription = "Flag"
                            )
                        }
                    )

                    // PROFILE
                    NavigationBarItem(
                        selected = false,
                        onClick = {

                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Profile"
                            )
                        }
                    )
                    // MENU ITEM -> OPEN DRAWER
                    NavigationBarItem(
                        selected = false,
                        onClick = {

                            showBottomSheet = true

                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    )
                }
            }

        ) { paddingValues ->

        }

        // BOTTOM DRAWER
        if (showBottomSheet) {

            ModalBottomSheet(

                onDismissRequest = {
                    showBottomSheet = false
                },

                sheetState = sheetState

            ) {

                // Drawer Content
                Card(modifier = Modifier.fillMaxWidth()
                    .padding(10.dp)) {
                    Text(
                        text = "Profile",
                        style = MaterialTheme.typography.headlineSmall
                    )
                }
                HorizontalDivider()
                Card(modifier = Modifier.fillMaxWidth()  .padding(10.dp)) {
                    Text(
                        text = "Video Call"
                    )
                }
                HorizontalDivider()
                    Card(modifier = Modifier.fillMaxWidth()  .padding(10.dp)) {

                    Text(
                        text = "Practice Hub"
                    )
                }

                Button(
                    onClick = {

                        coroutineScope.launch {
                            sheetState.hide()
                            showBottomSheet = false
                        }

                    }
                ) {
                    Text("Close")
                }
            }
        }
    }
}