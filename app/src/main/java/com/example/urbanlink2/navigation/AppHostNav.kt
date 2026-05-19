package com.example.urbanlink2.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.urbanlink2.data.viewmodel.SavedJobsViewModel
import com.example.urbanlink2.ui.theme.Screens.JobApplication.JobDashboardScreen
import com.example.urbanlink2.ui.theme.Screens.JobFinder.SavedJobScreen
import com.example.urbanlink2.ui.theme.Screens.JobFinder.SearchJobScreen
import com.example.urbanlink2.ui.theme.Screens.SelectScreens.FeedbackScreen
import com.example.urbanlink2.ui.theme.Screens.SelectScreens.HomeScreen
import com.example.urbanlink2.ui.theme.Screens.SelectScreens.JobInterestScreen
import com.example.urbanlink2.ui.theme.Screens.SelectScreens.RateUsScreen
import com.example.urbanlink2.ui.theme.Screens.SelectScreens.SelectCountryScreen
import com.example.urbanlink2.ui.theme.Screens.SelectScreens.SelectLanguageScreen
import com.example.urbanlink2.ui.theme.Screens.SelectScreens.ShareScreen
import com.example.urbanlink2.ui.theme.Screens.SelectScreens.TermsAndConditionsScreen
import com.example.urbanlink2.ui.theme.Screens.Settings.SettingsScreen

@Composable
fun AppNavHost(

    darkMode: Boolean,
    onDarkModeToggle: (Boolean) -> Unit,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_JOB_DASHBOARD
) {
    // Single ViewModel instance shared across the whole nav graph
    val savedJobsViewModel: SavedJobsViewModel = viewModel()

    NavHost(navController = navController,
        startDestination = startDestination) {

        composable(ROUTE_JOB_DASHBOARD) {
            JobDashboardScreen(navController)
        }

        composable(ROUTE_SEARCH_JOB) {
            SearchJobScreen(
                navController      = navController,
                savedJobsViewModel = savedJobsViewModel
            )
        }

        composable(ROUTE_SAVED_JOBS) {
            SavedJobScreen(
                navController      = navController,
                savedJobsViewModel = savedJobsViewModel
            )
        }

        composable(ROUTE_SETTINGS) {
            SettingsScreen(navController,
                    darkMode = darkMode,
                onDarkModeToggle = onDarkModeToggle
            )
        }
        composable(ROUTE_SELECT_COUNTRY) {
            SelectCountryScreen(navController)
        }
        composable(ROUTE_SELECT_LANGUAGE) {
            SelectLanguageScreen(navController)
        }
        composable(ROUTE_TERMS) {
            TermsAndConditionsScreen(
                onBackClick = {
                    navController.popBackStack()
                })
        }
        composable(ROUTE_PRIVACY_POLICY) {
                    TermsAndConditionsScreen(
                        onBackClick = {
                            navController.popBackStack()
                        }
            )
        }
        composable(ROUTE_RATE_US) {
            RateUsScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable(ROUTE_FEEDBACK) {
            FeedbackScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable(ROUTE_SHARE) {
            ShareScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable(ROUTE_PREFERENCE) {
            JobInterestScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable(ROUTE_HOME) {
            HomeScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }


    }
}