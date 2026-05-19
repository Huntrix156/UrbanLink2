package com.example.urbanlink2.ui.theme.Screens.SelectScreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.intellij.lang.annotations.Language


private val languages = listOf(
    "English",
    "French",
    "Spanish",
    "German",
    "Italian",
    "Portuguese",
    "Russian",
    "Chinese (Mandarin)",
    "Japanese",
    "Korean",
    "Arabic",
    "Hindi",
    "Swahili",
    "Turkish",
    "Dutch",
    "Greek",
    "Hebrew",
    "Thai",
    "Vietnamese",
    "Indonesian"
)
@Composable
fun SelectLanguageScreen(navController: NavController){


    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(languages) { language ->
            LanguageCard(language)
        }
    }

}

@Composable
fun LanguageCard(country: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
//            containerColor = Color(0xFFF5F7FA)
            ),
        onClick ={}
    ) {
        Box(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = country,
                style = MaterialTheme.typography.bodyLarge,
//                color = Color(0xFF1565C0)
            )
        }
    }
}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun SelectLanguageScreenPreview(){
//    SelectLanguageScreen(navController = rememberNavController())
//}
