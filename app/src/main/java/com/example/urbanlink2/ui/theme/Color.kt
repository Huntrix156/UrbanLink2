package com.example.urbanlink2.ui.theme
//
//import androidx.compose.ui.graphics.Color
//
//val Purple80 = Color(0xFFD0BCFF)
//val PurpleGrey80 = Color(0xFFCCC2DC)
//val Pink80 = Color(0xFFEFB8C8)
//
//val Purple40 = Color(0xFF6650a4)
//val PurpleGrey40 = Color(0xFF625b71)
//val Pink40 = Color(0xFF7D5260)



import androidx.compose.ui.graphics.Color

// ── Brand blue (your existing app accent) ─────────────────────────────────
val BrandBlue       = Color(0xFF1E88E5)   // your current top bar color
val BrandBlueDark   = Color(0xFF1565C0)   // deeper blue for dark mode surfaces
val BrandBlueLight  = Color(0xFF42A5F5)   // lighter blue for dark mode primary

// ── Light mode palette ─────────────────────────────────────────────────────
val LightPrimary        = Color(0xFF1E88E5)   // blue buttons, FABs, key UI
val LightOnPrimary      = Color(0xFFFFFFFF)   // text/icons ON blue
val LightPrimaryContainer   = Color(0xFFD3E9FF)   // chips, tonal buttons
val LightOnPrimaryContainer = Color(0xFF001E36)

val LightBackground     = Color(0xFFF5F7FA)   // screen background (off-white)
val LightOnBackground   = Color(0xFF1A1C1E)   // primary text on background
val LightSurface        = Color(0xFFFFFFFF)   // cards, sheets
val LightOnSurface      = Color(0xFF1A1C1E)   // text on cards
val LightSurfaceVariant = Color(0xFFE2E8F0)   // dividers, secondary cards
val LightOnSurfaceVariant = Color(0xFF44474F) // secondary text

val LightSecondary      = Color(0xFF0D47A1)   // navy — job tags, badges
val LightOnSecondary    = Color(0xFFFFFFFF)
val LightTertiary       = Color(0xFF00897B)   // teal — "Hired", "Active" badges
val LightOnTertiary     = Color(0xFFFFFFFF)

val LightError          = Color(0xFFBA1A1A)
val LightOnError        = Color(0xFFFFFFFF)
val LightOutline        = Color(0xFF74777F)   // borders, dividers

// ── Dark mode palette ──────────────────────────────────────────────────────
val DarkPrimary         = Color(0xFF90CAF9)   // soft blue — readable on dark
val DarkOnPrimary       = Color(0xFF003258)   // dark text ON the blue
val DarkPrimaryContainer    = Color(0xFF004880)
val DarkOnPrimaryContainer  = Color(0xFFD3E9FF)

val DarkBackground      = Color(0xFF0F1114)   // near-black screen background
val DarkOnBackground    = Color(0xFFE2E4E9)   // primary text
val DarkSurface         = Color(0xFF1A1D21)   // cards, bottom sheet
val DarkOnSurface       = Color(0xFFE2E4E9)   // text on cards
val DarkSurfaceVariant  = Color(0xFF252830)   // secondary cards, dividers
val DarkOnSurfaceVariant = Color(0xFFC4C6CF)  // secondary text

val DarkSecondary       = Color(0xFF90CAF9)   // light blue for tags
val DarkOnSecondary     = Color(0xFF003258)
val DarkTertiary        = Color(0xFF80CBC4)   // soft teal for badges
val DarkOnTertiary      = Color(0xFF00363D)

val DarkError           = Color(0xFFFFB4AB)
val DarkOnError         = Color(0xFF690005)
val DarkOutline         = Color(0xFF8E9099)