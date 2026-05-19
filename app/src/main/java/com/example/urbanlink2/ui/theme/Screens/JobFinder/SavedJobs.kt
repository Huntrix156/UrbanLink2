package com.example.urbanlink2.ui.theme.Screens.JobFinder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.urbanlink2.data.viewmodel.SavedJobsViewModel
import com.example.urbanlink2.navigation.ROUTE_SEARCH_JOB

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedJobScreen(
    navController: NavController,
    savedJobsViewModel: SavedJobsViewModel = viewModel()
) {
    val savedJobs by savedJobsViewModel.savedJobs.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {

            TopAppBar(

                title = {

                    Column {

                        Text(
                            text = "Saved Job",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Text(
                            text = "Search your dream job",
                            fontSize = 12.sp,
                            color = Color.White.copy(alpha = 0.7f)
                        )
                    }
                },

                navigationIcon = {

                    IconButton(onClick = { }) {

                        Icon(
                            Icons.Default.Menu,
                            contentDescription = "Menu",
                            tint = Color.White
                        )
                    }
                },

                actions = {

                    IconButton(onClick = { }) {

                        Icon(
                            Icons.Default.Notifications,
                            contentDescription = "Notifications",
                            tint = Color.White
                        )
                    }

                    IconButton(onClick = { }) {

                        Icon(
                            Icons.Default.AccountCircle,
                            contentDescription = "Profile",
                            tint = Color.White
                        )
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1565C0)
                )
            )
        },


        bottomBar = { SavedBottomBar(navController) }) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.dp)
        ) {
//            Text("Saved Jobs", fontSize = 38.sp, fontWeight = FontWeight.Bold)
//            Spacer(Modifier.height(8.dp))
            Text(
                text     = "${savedJobs.size} job${if (savedJobs.size == 1) "" else "s"} saved",
                fontSize = 18.sp,
                color    = Color.Gray
            )
            Spacer(Modifier.height(24.dp))

            if (savedJobs.isEmpty()) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            Icons.Default.BookmarkBorder, null,
                            Modifier.size(100.dp), tint = Color.LightGray
                        )
                        Spacer(Modifier.height(16.dp))
                        Text("No saved jobs yet", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(8.dp))
                        Text(
                            "Tap the bookmark on any job to save it",
                            fontSize = 16.sp, color = Color.Gray
                        )
                    }
                }
            } else {
                LazyColumn(
                    contentPadding      = PaddingValues(bottom = 100.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // key = id works because id is now a non-null String
                    items(savedJobs, key = { it.id }) { job ->
                        SaveableJobCard(
                            job          = job,
                            isSaved      = true,
                            onSaveToggle = { savedJobsViewModel.removeJob(job) }
                        )
                    }
                }
            }
        }
    }
}

// ------------------------------------------------------------------
// Bottom nav (Saved tab selected)
// ------------------------------------------------------------------
@Composable
fun SavedBottomBar(navController: NavController) {
    NavigationBar(modifier = Modifier.navigationBarsPadding()) {
        NavigationBarItem(
            selected = false, onClick = { navController.navigate("job_dashboard") },
            icon = { Icon(Icons.Default.Home, null) }, label = { Text("Home") }
        )
        NavigationBarItem(
            selected = false, onClick = { navController.navigate(ROUTE_SEARCH_JOB) },
            icon = { Icon(Icons.Default.Search, null) }, label = { Text("Search") }
        )
        NavigationBarItem(
            selected = true, onClick = { },
            icon = { Icon(Icons.Default.Bookmark, null) }, label = { Text("Saved") }
        )
        NavigationBarItem(
            selected = false, onClick = { navController.navigate("settings") },
            icon = { Icon(Icons.Default.Settings, null) }, label = { Text("Settings") }
        )
    }
}