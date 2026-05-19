package com.example.urbanlink2.ui.theme.Screens.SelectScreens


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeedbackScreen(
    onBackClick: () -> Unit
) {

    var rating by remember {
        mutableIntStateOf(0)
    }

    var feedbackMessage by remember {
        mutableStateOf("")
    }

    var selectedCategory by remember {
        mutableStateOf("UI Design")
    }

    var selectedEmoji by remember {
        mutableStateOf("😊")
    }

    var allowContact by remember {
        mutableStateOf(true)
    }

    var expanded by remember {
        mutableStateOf(false)
    }

    var submitted by remember {
        mutableStateOf(false)
    }

    val emojis = listOf(
        "😡", "😕", "😐", "😊", "😍"
    )

    val categories = listOf(
        "UI Design",
        "Performance",
        "Features",
        "Security",
        "Bugs",
        "Notifications",
        "Customer Support",
        "Suggestions"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Send Feedback",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1565C0),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F7FA))
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    elevation = CardDefaults.cardElevation(5.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(22.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "We Value Your Feedback",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1565C0)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Help us improve UrbanLink by sharing your experience, suggestions, and ideas.",
                            textAlign = TextAlign.Center,
                            lineHeight = 24.sp,
                            color = Color.DarkGray
                        )
                    }
                }
            }

            item {

                Card(
                    shape = RoundedCornerShape(22.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Text(
                            text = "Rate Your Experience",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color(0xFF1565C0)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {

                            for (i in 1..5) {

                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = "Star",
                                    tint = if (i <= rating)
                                        Color(0xFFFFC107)
                                    else
                                        Color.LightGray,
                                    modifier = Modifier
                                        .size(40.dp)
                                        .clickable {
                                            rating = i
                                        }
                                )
                            }
                        }
                    }
                }
            }

            item {

                Card(
                    shape = RoundedCornerShape(22.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Text(
                            text = "How do you feel?",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color(0xFF1565C0)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),


                        ) {

                            emojis.forEach { emoji ->

                                Card(
                                    modifier = Modifier
                                        .size(58.dp)
                                        .clickable {
                                            selectedEmoji = emoji
                                        },
                                    colors = CardDefaults.cardColors(
                                        containerColor = if (selectedEmoji == emoji)
                                            Color(0xFFE3F2FD)
                                        else
                                            Color.White
                                    ),
                                    shape = RoundedCornerShape(18.dp)
                                ) {

                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = emoji,
                                            fontSize = 28.sp
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            item {

                Card(
                    shape = RoundedCornerShape(22.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Text(
                            text = "Feedback Category",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color(0xFF1565C0)
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        ExposedDropdownMenuBox(
                            expanded = expanded,
                            onExpandedChange = {
                                expanded = !expanded
                            }
                        ) {

                            OutlinedTextField(
                                value = selectedCategory,
                                onValueChange = {},
                                readOnly = true,
                                modifier = Modifier
                                    .menuAnchor()
                                    .fillMaxWidth(),
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded)
                                }
                            )

                            ExposedDropdownMenu(
                                expanded = expanded,
                                onDismissRequest = {
                                    expanded = false
                                }
                            ) {

                                categories.forEach { category ->

                                    DropdownMenuItem(
                                        text = {
                                            Text(category)
                                        },
                                        onClick = {
                                            selectedCategory = category
                                            expanded = false
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
            }

            item {

                Card(
                    shape = RoundedCornerShape(22.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Text(
                            text = "Your Feedback",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color(0xFF1565C0)
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        OutlinedTextField(
                            value = feedbackMessage,
                            onValueChange = {
                                feedbackMessage = it
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(170.dp),
                            placeholder = {
                                Text("Tell us your thoughts, issues, or suggestions...")
                            },
                            shape = RoundedCornerShape(18.dp)
                        )
                    }
                }
            }

            item {

                Card(
                    shape = RoundedCornerShape(22.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {

                        Text(
                            text = "Attachments",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color(0xFF1565C0)
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        OutlinedButton(
                            onClick = {
                                // Open gallery or file picker
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(18.dp)
                        ) {

                            Icon(
                                imageVector = Icons.Default.AttachFile,
                                contentDescription = "Attach"
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            Text("Attach Screenshot")
                        }
                    }
                }
            }

            item {

                Card(
                    shape = RoundedCornerShape(22.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(18.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column {

                            Text(
                                text = "Allow Contact",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Allow support team to contact you",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                        }

                        Switch(
                            checked = allowContact,
                            onCheckedChange = {
                                allowContact = it
                            }
                        )
                    }
                }
            }

            item {

                Button(
                    onClick = {
                        submitted = true
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(58.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF1565C0)
                    )
                ) {

                    Text(
                        text = "Submit Feedback",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            item {

                AnimatedVisibility(visible = submitted) {

                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFE8F5E9)
                        ),
                        shape = RoundedCornerShape(22.dp)
                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(22.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "Feedback Submitted",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF2E7D32)
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = "Thank you for helping us improve UrbanLink.",
                                textAlign = TextAlign.Center,
                                lineHeight = 24.sp,
                                color = Color.DarkGray
                            )
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}
