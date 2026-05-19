package com.example.urbanlink2.ui.theme.Screens.JobApplication


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.urbanlink2.data.model.JobModel.Job   // ← correct import
import com.example.urbanlink2.navigation.ROUTE_HOME
import com.example.urbanlink2.navigation.ROUTE_JOB_DASHBOARD
import com.example.urbanlink2.navigation.ROUTE_SAVED_JOBS
import com.example.urbanlink2.navigation.ROUTE_SEARCH_JOB
import com.example.urbanlink2.navigation.ROUTE_SETTINGS

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobDashboardScreen(navController: NavController) {

    val currentRoute = navController.currentBackStackEntryAsState()
        .value?.destination?.route

    var query by remember { mutableStateOf("") }

    // Fixed: proper id strings, commas, and non-null fields
    val jobs = listOf(
        Job(
            id       = "d1",
            title    = "Android Developer",
            company  = "Google",
            location = "Nairobi"
        ),
        Job(
            id       = "d2",
            title    = "UI/UX Designer",
            company  = "Safaricom",
            location = "Mombasa"
        ),
        Job(
            id       = "d3",
            title    = "Cyber Security Intern",
            company  = "KCB",
            location = "Kisumu"
        )
    )

    val filteredJobs = jobs.filter {
        it.title.contains(query, ignoreCase = true)
    }


    // ✅ Shared item colors — same as SearchBottomBar
//    val itemColors = NavigationBarItemDefaults.colors(
//        selectedIconColor   = Color.White,
//        selectedTextColor   = Color.White,
//        unselectedIconColor = Color.White.copy(alpha = 0.6f),
//        unselectedTextColor = Color.White.copy(alpha = 0.6f),
//        indicatorColor      = Color(0xFF0D47A1)
//    )
    val itemColors = NavigationBarItemDefaults.colors(

        selectedIconColor = Color.Black,
        selectedTextColor = Color.Black,

        unselectedIconColor = Color.Black.copy(alpha = 0.7f),
        unselectedTextColor = Color.Black.copy(alpha = 0.7f),

        indicatorColor = Color.LightGray
    )

    Scaffold(
        topBar = {
            Column(
//                modifier = Modifier.background(color = Color(0xFF1E88E5)
//                )
            ) {
                TopAppBar(
                    title = {
                        Column {
                            Text(
                                text = "Urban Link",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Find your dream job",
                                color = Color.White.copy(alpha = 0.7f),
                                fontSize = 12.sp
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

                SearchBar(
                    query         = query,
                    onQueryChange = { query = it },
                    onSearch      = { },
                    active        = false,
                    onActiveChange = {},
                    placeholder   = { Text("Search jobs...") },
                    modifier      = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
//                        .background(color = Color(0xFF1E88E5))
//                        .background(color = MaterialTheme.colorScheme.primary)

                ) { }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {navController.navigate(ROUTE_HOME) }) { Text("+") }
        },
        bottomBar = {
            NavigationBar(
//                containerColor =Color(0xFF1565C0),
                contentColor   = Color.Gray,
                modifier       = Modifier.navigationBarsPadding()
            ) {

                NavigationBarItem(
                    selected = currentRoute == ROUTE_JOB_DASHBOARD,
                    onClick  = {
                        navController.navigate(ROUTE_JOB_DASHBOARD) {
                            popUpTo(ROUTE_JOB_DASHBOARD); launchSingleTop = true
                        }
                    },
                    icon  = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    colors = itemColors
                )

                NavigationBarItem(
                    selected = currentRoute == ROUTE_SEARCH_JOB,
                    onClick  = {
                        navController.navigate(ROUTE_SEARCH_JOB) {
                            popUpTo(ROUTE_JOB_DASHBOARD); launchSingleTop = true
                        }
                    },
                    icon  = { Icon(Icons.Filled.Search, contentDescription = "Search Job") },
                    label = { Text("Search") },
                    colors = itemColors
                )

                NavigationBarItem(
                    selected = currentRoute == ROUTE_SAVED_JOBS,
                    onClick  = {
                        navController.navigate(ROUTE_SAVED_JOBS) {
                            popUpTo(ROUTE_JOB_DASHBOARD); launchSingleTop = true
                        }
                    },
                    icon  = { Icon(Icons.Filled.Bookmark, contentDescription = "Saved Jobs") },
                    label = { Text("Saved") },
                    colors = itemColors
                )

                NavigationBarItem(
                    selected = currentRoute == ROUTE_SETTINGS,
                    onClick  = {
                        navController.navigate(ROUTE_SETTINGS) {
                            popUpTo(ROUTE_JOB_DASHBOARD); launchSingleTop = true
                        }
                    },
                    icon  = { Icon(Icons.Filled.Settings, contentDescription = "Settings") },
                    label = { Text("Settings") }
                )
            }
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            items(filteredJobs.size) { index ->
                DashboardJobCard(job = filteredJobs[index])
            }
        }
    }
}

// Renamed to DashboardJobCard to avoid clashing with JobCard in SearchJob.Screen.kt
@Composable
fun DashboardJobCard(job: Job) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 6.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
//        colors = CardDefaults.cardColors(
//            containerColor = Color(0xFF2196F3))
    ) {
        Column(modifier = Modifier.padding(16.dp),) {

            Divider()

            Text(
                text  = job.title,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text  = job.company,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text  = job.location,
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(onClick = { },
                modifier = Modifier,
                        colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("Apply Now")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun JobDashboardScreenPreview() {
    JobDashboardScreen(navController = rememberNavController())
}