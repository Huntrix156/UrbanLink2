package com.example.urbanlink2.ui.theme.Screens.JobFinder

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.urbanlink2.data.model.JobModel.Job
import com.example.urbanlink2.data.viewmodel.SavedJobsViewModel
import com.example.urbanlink2.navigation.ROUTE_JOB_DASHBOARD
import com.example.urbanlink2.navigation.ROUTE_SAVED_JOBS


private val sampleJobs = listOf(
    Job("1", "Android Developer",    "Google",    "New York"),
    Job("2", "Backend Developer",    "Microsoft", "London"),
    Job("3", "UI/UX Designer",       "Meta",      "New York"),
    Job("4", "Cybersecurity Analyst","Cisco",     "Nairobi"),
    Job("5", "AI Engineer",          "OpenAI",    "San Francisco"),
    Job("6", "Software Engineer",    "Amazon",    "Seattle"),
    Job("7", "Flutter Developer",    "Spotify",   "New York")
)

// ------------------------------------------------------------------
// Search screen
// ------------------------------------------------------------------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchJobScreen(
    navController: NavController,
    savedJobsViewModel: SavedJobsViewModel = viewModel()
) {
    var jobTitle    by remember { mutableStateOf("") }
    var company     by remember { mutableStateOf("") }
    var location    by remember { mutableStateOf("") }
    var hasSearched by remember { mutableStateOf(false) }

    val filteredJobs = remember { mutableStateListOf<Job>() }
    val savedJobs    by savedJobsViewModel.savedJobs.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {

            TopAppBar(

                title = {

                    Column {

                        Text(
                            text = "Search Job",
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

            bottomBar = { SearchBottomBar(navController) }) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.dp)
        ) {
//            Text("Search Job",       fontSize = 38.sp, fontWeight = FontWeight.Bold)
//            Spacer(Modifier.height(8.dp))
//            Text("Find your dream job", fontSize = 20.sp, color = Color.Gray)
//            Spacer(Modifier.height(30.dp))

            OutlinedTextField(
                value = jobTitle, onValueChange = { jobTitle = it },
                modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(20.dp),
                label = { Text("Job Title") }, singleLine = true,
                leadingIcon = { Icon(Icons.Default.Work, null, tint = Color(0xFF1565C0)) }
            )
            Spacer(Modifier.height(20.dp))

            OutlinedTextField(
                value = company, onValueChange = { company = it },
                modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(20.dp),
                label = { Text("Company Name") }, singleLine = true,
                leadingIcon = { Icon(Icons.Default.Business, null, tint = Color(0xFF1565C0)) }
            )
            Spacer(Modifier.height(20.dp))

            OutlinedTextField(
                value = location, onValueChange = { location = it },
                modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(20.dp),
                label = { Text("Location") }, singleLine = true,
                leadingIcon = { Icon(Icons.Default.LocationOn, null, tint = Color(0xFF1565C0)) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF1565C0),
                    focusedLabelColor  = Color(0xFF1565C0)
                )
            )
            Spacer(Modifier.height(30.dp))

            Button(
                onClick = {
                    hasSearched = true
                    filteredJobs.clear()
                    filteredJobs.addAll(sampleJobs.filter { job ->
                        (jobTitle.isBlank() || job.title.contains(jobTitle,   ignoreCase = true)) &&
                                (company.isBlank()  || job.company.contains(company,  ignoreCase = true)) &&
                                (location.isBlank() || job.location.contains(location, ignoreCase = true))
                    })
                },
                modifier = Modifier.fillMaxWidth().height(60.dp),
                shape    = RoundedCornerShape(18.dp),
                colors   = ButtonDefaults.buttonColors(containerColor = Color(0xFF1565C0))
            ) {
                Icon(Icons.Default.Search, null)
                Spacer(Modifier.size(10.dp))
                Text("Search", fontSize = 22.sp)
            }
            Spacer(Modifier.height(30.dp))

            if (hasSearched && filteredJobs.isEmpty()) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Default.Search, null, Modifier.size(100.dp), tint = Color.LightGray)
                        Spacer(Modifier.height(16.dp))
                        Text("No jobs found", fontSize = 28.sp, fontWeight = FontWeight.Bold)
                        Spacer(Modifier.height(8.dp))
                        Text("Try different search terms", fontSize = 18.sp, color = Color.Gray)
                    }
                }
            } else if (filteredJobs.isNotEmpty()) {
                LazyColumn(
                    contentPadding      = PaddingValues(bottom = 100.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(filteredJobs) { job ->
                        val isSaved = savedJobs.any { it.id == job.id }
                        SaveableJobCard(
                            job          = job,
                            isSaved      = isSaved,
                            onSaveToggle = {
                                if (isSaved) savedJobsViewModel.removeJob(job)
                                else         savedJobsViewModel.saveJob(job)
                            }
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun SaveableJobCard(
    job: Job,
    isSaved: Boolean,
    onSaveToggle: () -> Unit
) {
    Card(
        modifier  = Modifier.fillMaxWidth(),
        shape     = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            modifier          = Modifier.padding(18.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(job.title,   fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(6.dp))
                Text(job.company, fontSize = 18.sp, color = Color.Gray)
                Spacer(Modifier.height(6.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.LocationOn, null, tint = Color(0xFF1565C0))
                    Spacer(Modifier.size(4.dp))
                    Text(job.location, fontSize = 16.sp)
                }
            }
            IconButton(onClick = onSaveToggle) {
                Icon(
                    imageVector        = if (isSaved) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                    contentDescription = if (isSaved) "Remove from saved" else "Save job",
                    tint               = if (isSaved) Color(0xFF1565C0) else Color.Gray,
                    modifier           = Modifier.size(28.dp)
                )
            }
        }
    }
}


@Composable
fun SearchBottomBar(navController: NavController) {
    NavigationBar(modifier = Modifier.navigationBarsPadding()) {
        NavigationBarItem(
            selected = false, onClick = { navController.navigate(ROUTE_JOB_DASHBOARD) },
            icon = { Icon(Icons.Default.Home, null) }, label = { Text("Home") }
        )
        NavigationBarItem(
            selected = true, onClick = { },
            icon = { Icon(Icons.Default.Search, null) }, label = { Text("Search") }
        )
        NavigationBarItem(
            selected = false, onClick = { navController.navigate(ROUTE_SAVED_JOBS) },
            icon = { Icon(Icons.Default.Bookmark, null) }, label = { Text("Saved") }
        )
        NavigationBarItem(
            selected = false, onClick = { navController.navigate("settings") },
            icon = { Icon(Icons.Default.Settings, null) }, label = { Text("Settings") }
        )
    }
}