package com.example.urbanlink2.ui.theme.Screens.SelectScreens

import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun JobInterestScreen(
    onBackClick: () -> Unit

) {

    val jobs = listOf(
        "Software Engineer",
        "Data Scientist",
        "Mobile Developer",
        "Frontend Developer",
        "Backend Developer",
        "Full Stack Developer",
        "DevOps Engineer",
        "QA Engineer",
        "Cloud Architect",
        "Machine Learning Engineer"
    )

    var selectedJob by remember {
        mutableStateOf("Full Stack Developer")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(20.dp)
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "What jobs interest you?",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Select one to personalize your feed",
            color = Color.Gray,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(25.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.weight(1f)
        ) {

            items(jobs) { job ->

                val isSelected = selectedJob == job

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = if (isSelected)
                                Color(0xFF00A884)
                            else
                                Color.Gray,
                            shape = RoundedCornerShape(14.dp)
                        )
                        .background(
                            if (isSelected)
                                Color(0xFF004D40)
                            else
                                Color.Transparent,
                            RoundedCornerShape(14.dp)
                        )
                        .clickable {
                            selectedJob = job
                        }
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = job,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF90CAF9)
            ),
            shape = RoundedCornerShape(16.dp)
        ) {

            Text(
                text = "Save",
                color = Color.Black,
                fontSize = 18.sp
            )
        }
    }
}