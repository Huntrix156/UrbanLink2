package com.example.urbanlink2.ui.theme.Screens.SelectScreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyPolicyScreen(
    onBackClick: () -> Unit
) {

    val privacySections = listOf(
        "Information Collection" to
                "We may collect personal information such as names, emails, phone numbers, and location data for account creation and service improvement.",

        "Data Usage" to
                "Collected information is used to personalize services, improve performance, provide customer support, and maintain application security.",

        "Data Protection" to
                "UrbanLink uses secure technologies and encrypted systems to protect user information against unauthorized access.",

        "Third-Party Services" to
                "The application may use third-party platforms such as Firebase, Google Services, analytics providers, and payment systems.",

        "Cookies and Tracking" to
                "Cookies and similar technologies may be used to improve user experience and analyze application usage.",

        "User Rights" to
                "Users may request access, correction, or deletion of their personal data where applicable.",

        "Policy Updates" to
                "This Privacy Policy may be updated periodically. Continued use of the app indicates acceptance of updates."
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Privacy Policy")
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1565C0),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F7FA))
                .padding(padding)
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(privacySections) { section ->

                Card(
                    shape = RoundedCornerShape(18.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(18.dp)
                    ) {

                        Text(
                            text = section.first,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color(0xFF1565C0)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = section.second,
                            fontSize = 15.sp,
                            lineHeight = 23.sp
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "Last Updated: May 2026",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )
            }
        }
    }
}







@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutAppScreen(
    onBackClick: () -> Unit
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("About App")
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F7FA))
                .padding(padding)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {

            Card(
                shape = RoundedCornerShape(22.dp),
                elevation = CardDefaults.cardElevation(5.dp)
            ) {

                Column(
                    modifier = Modifier.padding(22.dp)
                ) {

                    Text(
                        text = "UrbanLink",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1565C0)
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "UrbanLink is a modern digital platform designed to connect users with smart services, opportunities, and community solutions.",
                        lineHeight = 24.sp
                    )
                }
            }

            Card {
                Column(
                    modifier = Modifier.padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {

                    Text(
                        text = "Application Information",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )

                    Text("Version: 1.0.0")
                    Text("Developer: Denis Technologies")
                    Text("Platform: Android")
                    Text("Built with Jetpack Compose")
                }
            }

            Card {
                Column(
                    modifier = Modifier.padding(18.dp)
                ) {
                    Text(
                        text = "Mission",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Our mission is to simplify digital experiences through secure, scalable, and user-friendly solutions.",
                        lineHeight = 24.sp
                    )
                }
            }
        }
    }
}






@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelpSupportScreen(
    onBackClick: () -> Unit
) {

    val supportItems = listOf(
        "Email Support" to "support@urbanlink.com",
        "Phone Support" to "+254 700 000 000",
        "Working Hours" to "Monday - Friday | 8:00 AM - 5:00 PM",
        "Live Chat" to "Available inside the application"
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Help & Support")
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F7FA))
                .padding(padding)
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            item {
                Text(
                    text = "How can we help you?",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1565C0)
                )
            }

            items(supportItems) { item ->

                Card(
                    shape = RoundedCornerShape(18.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(18.dp)
                    ) {

                        Text(
                            text = item.first,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = item.second,
                            fontSize = 15.sp
                        )
                    }
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FAQScreen(
    onBackClick: () -> Unit
) {

    val faqs = listOf(
        "How do I create an account?" to
                "You can create an account using your email and password through the sign up screen.",

        "How do I reset my password?" to
                "Use the forgot password option on the login screen.",

        "Is my data secure?" to
                "Yes. We use modern security systems and encrypted storage technologies.",

        "Can I contact support directly?" to
                "Yes. You can contact support through email, live chat, or phone support.",

        "Does the app require internet access?" to
                "Some features require internet connectivity for real-time synchronization."
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Frequently Asked Questions")
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F7FA))
                .padding(padding)
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(faqs) { faq ->

                Card(
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(18.dp)
                    ) {

                        Text(
                            text = faq.first,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color(0xFF1565C0)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = faq.second,
                            lineHeight = 23.sp
                        )
                    }
                }
            }
        }
    }
}







@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunityGuidelinesScreen(
    onBackClick: () -> Unit
) {

    val guidelines = listOf(
        "Respect Others" to
                "Users should treat others respectfully and avoid harassment, bullying, or abusive behavior.",

        "No Illegal Activities" to
                "Users must not engage in fraudulent, illegal, or harmful activities using the platform.",

        "Protect Privacy" to
                "Users should not share confidential or personal information belonging to others.",

        "No Harmful Content" to
                "Posting malware, violent content, hate speech, or inappropriate material is prohibited.",

        "Authentic Accounts" to
                "Users must not impersonate others or create misleading accounts.",

        "Follow Platform Rules" to
                "Repeated violations may lead to account suspension or permanent removal from the platform."
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Community Guidelines")
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { padding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F7FA))
                .padding(padding)
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            item {
                Text(
                    text = "Community Standards",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1565C0)
                )
            }

            items(guidelines) { guideline ->

                Card(
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(18.dp)
                    ) {

                        Text(
                            text = guideline.first,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color(0xFF1565C0)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = guideline.second,
                            lineHeight = 24.sp
                        )
                    }
                }
            }
        }
    }
}
