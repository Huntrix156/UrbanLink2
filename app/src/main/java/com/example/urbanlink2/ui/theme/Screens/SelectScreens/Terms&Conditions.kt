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
fun TermsAndConditionsScreen(
    onBackClick: () -> Unit
) {

    val termsSections = listOf(
        "Introduction" to
                "Welcome to UrbanLink. By accessing or using this application, you agree to comply with and be bound by these Terms and Conditions.",

        "User Eligibility" to
                "Users must be at least 13 years old and must provide accurate registration information when using this application.",

        "Account Responsibilities" to
                "Users are responsible for maintaining the confidentiality of their accounts, passwords, and all activities performed under their account.",

        "Acceptable Use" to
                "Users must not misuse the platform, upload malicious content, attempt unauthorized access, harass other users, or violate applicable laws.",

        "Privacy and Data Collection" to
                "UrbanLink may collect user information including names, emails, phone numbers, and location data to improve services. Data is handled securely and responsibly.",

        "Intellectual Property" to
                "All application content including logos, designs, graphics, source code, and trademarks remain the property of UrbanLink.",

        "Third-Party Services" to
                "This application may integrate third-party services such as Firebase, Google Maps, payment gateways, and analytics providers.",

        "Payments and Purchases" to
                "If purchases or subscriptions are offered, users agree to applicable billing terms, pricing, and refund policies.",

        "Limitation of Liability" to
                "UrbanLink shall not be held responsible for damages, interruptions, data loss, or unauthorized access resulting from misuse or technical issues.",

        "Account Suspension" to
                "Accounts violating these terms may be suspended or permanently terminated without prior notice.",

        "Updates to Terms" to
                "UrbanLink reserves the right to modify or update these Terms and Conditions at any time. Continued use of the app means acceptance of updated terms.",

        "Governing Law" to
                "These Terms and Conditions shall be governed according to applicable local and international laws.",

        "Contact Information" to
                "For support or legal inquiries, users may contact UrbanLink support through the official support channels provided within the app."
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Terms & Conditions",
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
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(5.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {
                        Text(
                            text = "UrbanLink Terms and Conditions",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF0D47A1)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = "Please read these Terms and Conditions carefully before using the application.",
                            fontSize = 15.sp,
                            color = Color.DarkGray
                        )
                    }
                }
            }

            items(termsSections) { section ->

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(18.dp)
                    ) {

                        Text(
                            text = section.first,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1565C0)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        HorizontalDivider(
                            thickness = 1.dp,
                            color = Color.LightGray
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = section.second,
                            fontSize = 15.sp,
                            lineHeight = 24.sp,
                            color = Color.DarkGray
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "Last Updated: May 2026",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.Gray,
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}







