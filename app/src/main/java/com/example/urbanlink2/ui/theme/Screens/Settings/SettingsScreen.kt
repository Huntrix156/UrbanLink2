//package com.example.urbanlink2.ui.theme.Screens.Settings
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.layout.widthIn
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.automirrored.filled.ArrowBack
//import androidx.compose.material.icons.filled.ChevronRight
//import androidx.compose.material.icons.filled.DarkMode
//import androidx.compose.material.icons.filled.Email
//import androidx.compose.material.icons.filled.LightMode
//import androidx.compose.material.icons.filled.PermMedia
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material.icons.filled.Share
//import androidx.compose.material.icons.filled.Star
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.DropdownMenuItem
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.ExposedDropdownMenuBox
//import androidx.compose.material3.ExposedDropdownMenuDefaults
//import androidx.compose.material3.HorizontalDivider
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.RadioButton
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Switch
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.painter.Painter
//import androidx.compose.ui.input.pointer.motionEventSpy
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//import com.example.urbanlink2.R
//import com.example.urbanlink2.navigation.ROUTE_FEEDBACK
//import com.example.urbanlink2.navigation.ROUTE_PRIVACY_POLICY
//import com.example.urbanlink2.navigation.ROUTE_RATE_US
//import com.example.urbanlink2.navigation.ROUTE_SELECT_COUNTRY
//import com.example.urbanlink2.navigation.ROUTE_SELECT_LANGUAGE
//import com.example.urbanlink2.navigation.ROUTE_SHARE
//import com.example.urbanlink2.navigation.ROUTE_TERMS
//
//
////package com.example.urbanlink2.ui.theme.Screens.Settings
////
////
////
////import androidx.compose.foundation.*
////import androidx.compose.foundation.layout.*
////import androidx.compose.foundation.lazy.LazyColumn
////import androidx.compose.foundation.shape.CircleShape
////import androidx.compose.foundation.shape.RoundedCornerShape
////import androidx.compose.material.icons.Icons
////import androidx.compose.material.icons.outlined.*
////import androidx.compose.material3.*
////import androidx.compose.runtime.*
////import androidx.compose.ui.Alignment
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.draw.clip
////import androidx.compose.ui.graphics.Color
////import androidx.compose.ui.graphics.vector.ImageVector
////import androidx.compose.ui.text.font.FontFamily
////import androidx.compose.ui.text.font.FontWeight
////import androidx.compose.ui.tooling.preview.Preview
////import androidx.compose.ui.unit.dp
////import androidx.compose.ui.unit.sp
////import androidx.navigation.NavController
////import androidx.navigation.compose.rememberNavController
////
////// ─── Theme colors (matches dark UI in screenshot) ───────────────────────────
////
////val BackgroundDark   = Color(0xFF1A1A1A)
////val SurfaceDark      = Color(0xFF252525)
////val SurfaceVariant   = Color(0xFF2E2E2E)
////val DividerColor     = Color(0xFF3A3A3A)
////val TextPrimary      = Color(0xFFE8E8E8)
////val TextSecondary    = Color(0xFF9A9A9A)
////val TextTertiary     = Color(0xFF666666)
////val AccentPurple     = Color(0xFF7F77DD)
////val SidebarActive    = Color(0xFF2A2A2A)
////
////// ─── Data model ─────────────────────────────────────────────────────────────
////
////data class NavItem(val label: String, val icon: ImageVector, val panel: String)
////
////// ─── Root screen ────────────────────────────────────────────────────────────
////
////@Composable
////fun SettingsScreen(navController: NavController) {
////    var selectedPanel by remember { mutableStateOf("personalization") }
////    var sidebarExpanded by remember { mutableStateOf(true) }
////
////    val navItems = listOf(
////        NavItem("Personalization", Icons.Outlined.Palette,        "personalization"),
////        NavItem("Security",        Icons.Outlined.Lock,           "security"),
////        NavItem("Performance",     Icons.Outlined.Speed,          "performance"),
////        NavItem("Accessibility",   Icons.Outlined.Accessibility,  "accessibility"),
////        NavItem("Data & Storage",  Icons.Outlined.Storage,        "data"),
////        NavItem("Notifications",   Icons.Outlined.Notifications,  "notifications"),
////        NavItem("Account",         Icons.Outlined.AccountCircle,  "account"),
////        NavItem("Behavior",        Icons.Outlined.Settings,       "behavior"),
////        NavItem("System",          Icons.Outlined.Memory,         "system"),
////    )
////
////    Surface(color = BackgroundDark, modifier = Modifier.fillMaxSize()) {
////        Row(Modifier.fillMaxSize()) {
////
////            // ── Sidebar ──────────────────────────────────────────────────
////            SettingsSidebar(
////                items = navItems,
////                selected = selectedPanel,
////                onSelect = { selectedPanel = it }
////            )
////
////            // ── Divider ──────────────────────────────────────────────────
////            Box(
////                Modifier
////                    .fillMaxHeight()
////                    .width(1.dp)
////                    .background(DividerColor)
////            )
////
////            // ── Content ──────────────────────────────────────────────────
////            Box(Modifier.fillMaxSize().background(BackgroundDark)) {
////                when (selectedPanel) {
////                    "personalization" -> PersonalizationPanel()
////                    "security"        -> SecurityPanel()
////                    "performance"     -> PerformancePanel()
////                    "accessibility"   -> AccessibilityPanel()
////                    "data"            -> DataStoragePanel()
////                    "notifications"   -> NotificationsPanel()
////                    "account"         -> AccountPanel()
////                    "behavior"        -> BehaviorPanel()
////                    "system"          -> SystemPanel()
////                }
////            }
////        }
////    }
////}
////
////// ─── Sidebar ────────────────────────────────────────────────────────────────
////
////@Composable
////fun SettingsSidebar(
////    items: List<NavItem>,
////    selected: String,
////    onSelect: (String) -> Unit
////) {
////
////    Column(
////        Modifier
////            .width(100.dp)
////            .fillMaxHeight()
////            .background(SurfaceDark)
////            .verticalScroll(rememberScrollState())
////            .padding(vertical = 50.dp)
////    ) {
////        Text(
////            "SETTINGS",
////            color = TextTertiary,
////            fontSize = 10.sp,
////            fontWeight = FontWeight.Medium,
////            letterSpacing = 1.sp,
////            modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
////        )
////        Spacer(Modifier.height(4.dp))
////        items.forEach { item ->
////            SidebarNavItem(
////                item = item,
////                isSelected = selected == item.panel,
////                onClick = { onSelect(item.panel) }
////            )
////        }
////    }
////}
////
////@Composable
////fun SidebarNavItem(item: NavItem, isSelected: Boolean, onClick: () -> Unit) {
////    val bg     = if (isSelected) SidebarActive else Color.Transparent
////    val tint   = if (isSelected) TextPrimary   else TextSecondary
////
////    Box(
////        Modifier
////            .fillMaxWidth()
////            .background(bg)
////            .then(
////                if (isSelected) Modifier.border(
////                    width = 2.dp,
////                    color = AccentPurple,
////                    shape = RoundedCornerShape(topEnd = 0.dp, bottomEnd = 0.dp)
////                ) else Modifier
////            )
////            .clickable(onClick = onClick)
////            .padding(horizontal = 7.dp, vertical = 10.dp)
////    ) {
////        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
////            Icon(item.icon, contentDescription = null, tint = tint, modifier = Modifier.size(8.dp))
////            Text(item.label, color = tint, fontSize = 13.sp,
////                fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal)
////        }
////    }
////}
////
////// ─── Shared primitives ──────────────────────────────────────────────────────
////
////@Composable
////fun PanelTitle(title: String, icon: ImageVector) {
////    Row(
////        verticalAlignment = Alignment.CenterVertically,
////        horizontalArrangement = Arrangement.spacedBy(8.dp),
////        modifier = Modifier
////            .fillMaxWidth()
////            .padding(bottom = 16.dp)
////    ) {
////        Icon(icon, contentDescription = null, tint = TextPrimary, modifier = Modifier.size(18.dp))
////        Text(title, color = TextPrimary, fontSize = 16.sp, fontWeight = FontWeight.Medium)
////    }
////    HorizontalDivider(color = DividerColor, thickness = 0.5.dp)
////    Spacer(Modifier.height(16.dp))
////}
////
////@Composable
////fun SectionLabel(text: String) {
////    Text(
////        text.uppercase(),
////        color = TextTertiary,
////        fontSize = 13.sp,
////        fontWeight = FontWeight.Medium,
////        letterSpacing = 0.8.sp,
////        modifier = Modifier.padding(bottom = 6.dp, top = 4.dp)
////    )
////}
////
////@Composable
////fun SettingRow(
////    name: String,
////    description: String? = null,
////    control: @Composable () -> Unit
////) {
////    Row(
////        Modifier
////            .fillMaxWidth()
////            .clip(RoundedCornerShape(8.dp))
////            .background(SurfaceVariant)
////            .padding(horizontal = 12.dp, vertical = 10.dp),
////        verticalAlignment = Alignment.CenterVertically
////    ) {
////        Column(Modifier.weight(1f)) {
////            Text(name, color = TextPrimary, fontSize = 13.sp)
////            if (description != null)
////                Text(description, color = TextTertiary, fontSize = 12.sp)
////        }
////        Spacer(Modifier.width(12.dp))
////        control()
////    }
////    Spacer(Modifier.height(6.dp))
////}
////
////@Composable
////fun SettingsToggle(checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
////    Switch(
////        checked = checked,
////        onCheckedChange = onCheckedChange,
////        colors = SwitchDefaults.colors(
////            checkedThumbColor   = Color.White,
////            checkedTrackColor   = AccentPurple,
////            uncheckedThumbColor = Color.White,
////            uncheckedTrackColor = DividerColor
////        )
////    )
////}
////
////@OptIn(ExperimentalMaterial3Api::class)
////@Composable
////fun SettingsDropdown(options: List<String>, selected: String, onSelect: (String) -> Unit) {
////    var expanded by remember { mutableStateOf(false) }
////    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = it }) {
////        OutlinedTextField(
////            value = selected,
////            onValueChange = {},
////            readOnly = true,
////            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
////            modifier = Modifier.menuAnchor().width(160.dp),
////            textStyle = LocalTextStyle.current.copy(fontSize = 13.sp, color = TextPrimary),
////            colors = OutlinedTextFieldDefaults.colors(
////                unfocusedBorderColor  = DividerColor,
////                focusedBorderColor    = AccentPurple,
////                unfocusedContainerColor = SurfaceVariant,
////                focusedContainerColor   = SurfaceVariant,
////            ),
////            singleLine = true
////        )
////        ExposedDropdownMenu(
////            expanded = expanded,
////            onDismissRequest = { expanded = false },
////            modifier = Modifier.background(SurfaceVariant)
////        ) {
////            options.forEach { opt ->
////                DropdownMenuItem(
////                    text = { Text(opt, color = TextPrimary, fontSize = 13.sp) },
////                    onClick = { onSelect(opt); expanded = false }
////                )
////            }
////        }
////    }
////}
////
////// ─── Personalization panel (matches screenshot exactly) ─────────────────────
////
////@Composable
////fun PersonalizationPanel() {
////    val accentColors = listOf(
////        Color(0xFF7F77DD), // purple
////        Color(0xFF1D9E75), // teal
////        Color(0xFFD85A30), // coral
////        Color(0xFF378ADD), // blue
////        Color(0xFF639922), // green
////        Color(0xFFBA7517), // amber
////    )
////    var selectedAccent by remember { mutableStateOf(0) }
////    var fontSize by remember { mutableStateOf(14f) }
////    var compact by remember { mutableStateOf(false) }
////    var theme by remember { mutableStateOf("System default") }
////    var language by remember { mutableStateOf("English (US)") }
////    var dateFormat by remember { mutableStateOf("DD/MM/YYYY") }
////    var timezone by remember { mutableStateOf("Africa/Nairobi (EAT)") }
////
////    LazyColumn(
////        Modifier.fillMaxSize().padding(4.dp),
////        verticalArrangement = Arrangement.spacedBy(0.dp)
////    ) {
////        item { PanelTitle("Personalization", Icons.Outlined.Palette) }
////
////        // Appearance
////        item { SectionLabel("Appearance") }
////        item {
////            SettingRow("Theme", "Choose your preferred color scheme") {
////                SettingsDropdown(
////                    listOf("System default", "Light", "Dark", "High contrast"),
////                    theme
////                ) { theme = it }
////            }
////        }
////        item {
////            SettingRow("Accent color", "Used for buttons and highlights") {
////                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
////                    accentColors.forEachIndexed { index, color ->
////                        Box(
////                            Modifier
////                                .size(24.dp)
////                                .clip(CircleShape)
////                                .background(color)
////                                .border(
////                                    width = if (selectedAccent == index) 2.dp else 0.dp,
////                                    color = TextPrimary,
////                                    shape = CircleShape
////                                )
////                                .clickable { selectedAccent = index }
////                        )
////                    }
////                }
////            }
////        }
////        item {
////            SettingRow("Font size", "Base UI text size") {
////                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
////                    Slider(
////                        value = fontSize,
////                        onValueChange = { fontSize = it },
////                        valueRange = 12f..20f,
////                        modifier = Modifier.width(100.dp),
////                        colors = SliderDefaults.colors(
////                            thumbColor      = AccentPurple,
////                            activeTrackColor = AccentPurple
////                        )
////                    )
////                    Text("${fontSize.toInt()}px", color = TextSecondary, fontSize = 12.sp, modifier = Modifier.width(32.dp))
////                }
////            }
////        }
////        item {
////            SettingRow("Compact layout", "Reduce spacing between UI elements") {
////                SettingsToggle(compact) { compact = it }
////            }
////        }
////
////        item { Spacer(Modifier.height(16.dp)) }
////
////        // Language & Region
////        item { SectionLabel("Language & Region") }
////        item {
////            SettingRow("Language") {
////                SettingsDropdown(listOf("English (US)", "English (UK)", "Swahili", "French"), language) { language = it }
////            }
////        }
////        item {
////            SettingRow("Date format") {
////                SettingsDropdown(listOf("DD/MM/YYYY", "MM/DD/YYYY", "YYYY-MM-DD"), dateFormat) { dateFormat = it }
////            }
////        }
////        item {
////            SettingRow("Time zone") {
////                SettingsDropdown(listOf("Africa/Nairobi (EAT)", "UTC", "Europe/London"), timezone) { timezone = it }
////            }
////        }
////
////        item { Spacer(Modifier.height(16.dp)) }
////
////        // Keyboard shortcuts
////        item { SectionLabel("Keyboard Shortcuts") }
////        item {
////            val shortcuts = listOf("Search" to "Ctrl + K", "New item" to "Ctrl + N",
////                "Save" to "Ctrl + S", "Settings" to "Ctrl + ,", "Help" to "F1")
////            Column(
////                Modifier.fillMaxWidth()
////                    .clip(RoundedCornerShape(8.dp))
////                    .background(SurfaceVariant)
////                    .padding(horizontal = 12.dp, vertical = 4.dp)
////            ) {
////                shortcuts.forEachIndexed { i, (action, key) ->
////                    Row(
////                        Modifier.fillMaxWidth().padding(vertical = 8.dp),
////                        horizontalArrangement = Arrangement.SpaceBetween,
////                        verticalAlignment = Alignment.CenterVertically
////                    ) {
////                        Text(action, color = TextPrimary, fontSize = 13.sp)
////                        Surface(
////                            shape = RoundedCornerShape(4.dp),
////                            color = BackgroundDark,
////                            border = BorderStroke(0.5.dp, DividerColor)
////                        ) {
////                            Text(key, color = TextSecondary, fontSize = 11.sp,
////                                fontFamily = FontFamily.Monospace,
////                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
////                        }
////                    }
////                    if (i < shortcuts.size - 1)
////                        HorizontalDivider(color = DividerColor, thickness = 0.5.dp)
////                }
////            }
////        }
////    }
////}
////
////// ─── Security panel ──────────────────────────────────────────────────────────
////
////@Composable
////fun SecurityPanel() {
////    var biometric by remember { mutableStateOf(true) }
////    var loginAlerts by remember { mutableStateOf(true) }
////    var analytics by remember { mutableStateOf(true) }
////    var crashReports by remember { mutableStateOf(false) }
////    var timeout by remember { mutableStateOf("5 minutes") }
////
////    val sessions = listOf(
////        Triple("Chrome — Nairobi, KE", "Current session · just now", true),
////        Triple("Safari — iPhone", "2 hours ago", false),
////        Triple("Firefox — Mombasa, KE", "Yesterday", false),
////    )
////
////    LazyColumn(Modifier.fillMaxSize().padding(4.dp)) {//change here//
////        item { PanelTitle("Security", Icons.Outlined.Lock) }
////        item { SectionLabel("Authentication") }
////        item {
////            SettingRow("Two-factor authentication", "Add a second layer of verification") {
////                Surface(shape = RoundedCornerShape(20.dp), color = Color(0xFF1B3A1B)) {
////                    Text("Enabled", color = Color(0xFF63992A), fontSize = 11.sp, fontWeight = FontWeight.Medium,
////                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp))
////                }
////            }
////        }
////        item { SettingRow("Biometric login", "Use fingerprint or face ID") { SettingsToggle(biometric) { biometric = it } } }
////        item { SettingRow("Auto-lock timeout", "Lock after inactivity") {
////            SettingsDropdown(listOf("5 minutes","15 minutes","30 minutes","1 hour","Never"), timeout) { timeout = it }
////        }}
////        item { SettingRow("Login activity alerts", "Email on new sign-ins") { SettingsToggle(loginAlerts) { loginAlerts = it } } }
////
////        item { Spacer(Modifier.height(4.dp)) }//changed here//
////        item { SectionLabel("Active Sessions") }
////        items(sessions.size) { i ->
////            val (name, time, active) = sessions[i]
////            Row(
////                Modifier.fillMaxWidth().padding(bottom = 6.dp)
////                    .clip(RoundedCornerShape(8.dp)).background(SurfaceVariant)
////                    .padding(8.dp),//changed here//
////                verticalAlignment = Alignment.CenterVertically
////            ) {
////                Box(
////                    Modifier.size(8.dp).clip(CircleShape)
////                        .background(if (active) Color(0xFF63992A) else DividerColor)
////                )
////                Spacer(Modifier.width(10.dp))
////                Column(Modifier.weight(1f)) {
////                    Text(name, color = TextPrimary, fontSize = 13.sp, fontWeight = FontWeight.Medium)
////                    Text(time, color = TextTertiary, fontSize = 12.sp)
////                }
////                OutlinedButton(
////                    onClick = {},
////                    border = BorderStroke(0.5.dp, DividerColor),
////                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
////                ) { Text("End", color = TextSecondary, fontSize = 12.sp) }
////            }
////        }
////
////        item { Spacer(Modifier.height(16.dp)) }
////        item { SectionLabel("Privacy") }
////        item { SettingRow("Usage analytics", "Help improve the app (anonymous)") { SettingsToggle(analytics) { analytics = it } } }
////        item { SettingRow("Crash reports", "Send error details automatically") { SettingsToggle(crashReports) { crashReports = it } } }
////    }
////}
////
////// ─── Stub panels for the remaining sections ──────────────────────────────────
////// Each follows the same SettingRow / SettingsToggle / SettingsDropdown pattern.
////
////@Composable fun PerformancePanel()    = StubPanel("Performance",    Icons.Outlined.Speed)
////@Composable fun AccessibilityPanel() = StubPanel("Accessibility",   Icons.Outlined.Accessibility)
////@Composable fun DataStoragePanel()   = StubPanel("Data & Storage",  Icons.Outlined.Storage)
////@Composable fun NotificationsPanel() = StubPanel("Notifications",   Icons.Outlined.Notifications)
////@Composable fun AccountPanel()       = StubPanel("Account",         Icons.Outlined.AccountCircle)
////@Composable fun BehaviorPanel()      = StubPanel("Behavior",        Icons.Outlined.Settings)
////@Composable fun SystemPanel()        = StubPanel("System",          Icons.Outlined.Memory)
////
////@Composable
////fun StubPanel(title: String, icon: ImageVector) {
////    Column(Modifier.fillMaxSize().padding(4.dp)) {
////        PanelTitle(title, icon)
////        // Add your SettingRow blocks here following the same pattern as PersonalizationPanel
////        Text("Configure $title settings here.", color = TextSecondary, fontSize = 14.sp)
////    }
////}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun SettingsScreen(navController: NavController,
//    darkMode: Boolean,              // received from above
//    onDarkModeToggle: (Boolean) -> Unit  // callback to update it
//) {
//
//
//
//
//
//    Scaffold(
//
//        topBar = {
//
//            TopAppBar(
//
//                title = {
//
//                    Text(
//                        text = "Settings",
//                        fontSize = 24.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = Color.White
//                    )
//                },
//
//                navigationIcon = {
//
//                    IconButton(
//                        onClick = { navController.popBackStack() }
//                    ) {
//
//                        Icon(
//                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                            contentDescription = "Back",
//                            tint = Color.White
//                        )
//                    }
//                },
//
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color(0xFF1E88E5)
//                )
//            )
//        }
//
//    ) { paddingValues ->
//
//
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .verticalScroll(rememberScrollState())
//                .background(color = Color(0xFF1E88E5))
//                .padding(paddingValues),
//
////            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//
//
//        ) {
//
//            Spacer(modifier = Modifier.width(20.dp))
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//            ) {
//                Card(
//                    modifier = Modifier
//                        .padding(10.dp)
//                        .fillMaxWidth()
//                        .background(color = Color(0xFF1E88E5))) {
//                Row(modifier = Modifier.padding(10.dp)) {
//                    Image(
//                        painter = painterResource(R.drawable.ic_launcher_background),
//                        contentDescription = "logo", modifier = Modifier.size(40.dp),
//
//                        )
//                    Spacer(modifier = Modifier.width(10.dp))
//                    Column() {
//                        Text(text = "JobsFinder")
//                        Spacer(modifier = Modifier.height(10.dp))
//                        Text(text = "Version 1 .0")
//                    }
//                }
//
//            }}
//            Text(
//                text = "General",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 1.dp)
//            )
//
//
////            var darkMode by remember {
////                mutableStateOf(false)
////            }
////
////            Card(
////                modifier = Modifier
////                    .fillMaxWidth()
////                    .padding(16.dp)
////            ) {
////
////                Row(
////                    modifier = Modifier
////                        .fillMaxWidth()
////                        .padding(20.dp),
////
////                    verticalAlignment = Alignment.CenterVertically
////                ) {
////
////                    Column(
////                        modifier = Modifier.weight(1f)
////                    ) {
////                        Row() {
////                            Icon(
////                                imageVector = Icons.Default.Person,
////                                contentDescription = "Person"
////                            )
////                            Text(
////                                text = "Toggle dark/light theme",
////                                fontSize = 18.sp
////                            )
////                        }
////                        Spacer(modifier = Modifier.height(4.dp))
////
////                        Text(
////                            text =
////                                if (darkMode)
////                                    "Dark theme enabled"
////                                else
////                                    "Light theme enabled",
////
////                            fontSize = 14.sp
////                        )
////                    }
////
////                    Switch(
////                        checked = darkMode,
////
////                        onCheckedChange = {
////                            darkMode = it
////                        },
////
////                        thumbContent = {
////                            Icon(
////                                imageVector =
////                                    if (darkMode)
////                                        Icons.Default.DarkMode
////                                    else
////                                        Icons.Default.LightMode,
//
////                                contentDescription = null,
////                                modifier = Modifier.size(16.dp)
////                            )
////                        }
////                    )
//                }
//                HorizontalDivider(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(start = 80.dp),
//                    thickness = 1.dp
//                )
//
//                Card(
//                    onClick = { navController.navigate(ROUTE_SELECT_COUNTRY) },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(16.dp)
//                ) {
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(16.dp),
//                        horizontalArrangement = Arrangement.SpaceBetween,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//
//                        Text(
//                            text = "Choose Country",
//                            fontSize = 15.sp
//                        )
//
//                        Icon(
//                            imageVector = Icons.Default.ChevronRight,
//                            contentDescription = "ChevronRight"
//                        )
//                    }
//                }
//                HorizontalDivider(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(start = 80.dp),
//                    thickness = 1.dp
//                )
//
//                Card(
//                    onClick = { navController.navigate(ROUTE_SELECT_LANGUAGE) },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(16.dp)
//                ) {
//                    Spacer(modifier = Modifier.height(5.dp))
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(16.dp),
//                        horizontalArrangement = Arrangement.SpaceBetween,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Text(text = "Language")
//
//                        Icon(
//                            imageVector = Icons.Default.ChevronRight,
//                            contentDescription = "ChevronRight"
//                        )
//
//                    }
//                }
//                HorizontalDivider(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(start = 80.dp),
//                    thickness = 1.dp
//                )
//                Row() {
//                    Card(
//                        onClick = {},
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(16.dp)
//                    ) {
//                        Spacer(modifier = Modifier.height(5.dp))
//                        Row(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(16.dp),
//                            horizontalArrangement = Arrangement.SpaceBetween,
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//                            Text(text = "Job Preference")
//
//                            Icon(
//                                imageVector = Icons.Default.ChevronRight,
//                                contentDescription = "ChevronRight"
//                            )
//
//                        }
//                    }
//
//                }
//
//            }
//            Text(
//                text = "Support", modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 1.dp)
//            )
//            Card(modifier = Modifier
//                .padding(20.dp)){
//            Card(onClick = {navController.navigate(ROUTE_RATE_US)},
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            )
//            {
//                Row() {
//                    Icon(
//                        imageVector = Icons.Default.Star,
//                        contentDescription = "Star"
//                    )
//                    Text(text = "Rate Us ", fontSize = 20.sp)
//                }
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(2.dp),
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Text(
//                        text = "Love the app? Rate us on Play Store ",
//                        modifier = Modifier.padding(start = 22.dp)
//                    )
//
//                    Icon(
//                        imageVector = Icons.Default.ChevronRight,
//                        contentDescription = "ChevronRight"
//                    )
//                }
//            }
//
//                HorizontalDivider(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(start = 80.dp),
//                    thickness = 1.dp
//                )
//                Card(onClick = {navController.navigate(ROUTE_SHARE)}) {
//                    Row() {
//
//                        Icon(
//                            imageVector = Icons.Default.Share,
//                            contentDescription = "ChevronRight"
//                        )
//                        Text(text = "Share", fontSize = 20.sp)
//                    }
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(2.dp),
//                        horizontalArrangement = Arrangement.SpaceBetween,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//
//                        Text(
//                            text = "Share this app with friends",
//                            modifier = Modifier.padding(start = 22.dp)
//                        )
//                    }
//                    HorizontalDivider(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(start = 80.dp),
//                        thickness = 1.dp
//                    )}
//                    Card(onClick = {navController.navigate(ROUTE_FEEDBACK)}) {
//                        Row() {
//
//                            Icon(
//                                imageVector = Icons.Default.Email,
//                                contentDescription = "Email"
//                            )
//                            Text(text = "Feedback", fontSize = 20.sp)
//                        }
//                        Row(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(2.dp),
//                            horizontalArrangement = Arrangement.SpaceBetween,
//                            verticalAlignment = Alignment.CenterVertically
//                        ) {
//
//                            Text(
//                                text = "Send us your feedback",
//                                modifier = Modifier.padding(start = 22.dp)
//                            )
//                        }
//                    }
//
//
////                HorizontalDivider(
////                    modifier = Modifier
////                        .fillMaxWidth()
////                        .padding(start = 80.dp),
////                    thickness = 1.dp
////                )
//                }
//            Text(
//                text = "Legal", modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 22.dp)
//            )
//            Card() {
//            Card(onClick = {navController.navigate(ROUTE_TERMS)},
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp)
//            ) {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(16.dp),
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//
//                    Text(
//                        text = "Terms & Conditions",
//                        fontSize = 15.sp
//                    )
//
//                    Icon(
//                        imageVector = Icons.Default.ChevronRight,
//                        contentDescription = "ChevronRight"
//                    )
//                }
//            }
//            HorizontalDivider(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 80.dp),
//                thickness = 1.dp
//            )
//
//
//
//                Spacer(modifier= Modifier.height(10.dp))
//
//                Card(
//                    onClick = { navController.navigate(ROUTE_PRIVACY_POLICY) },
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(16.dp)
//                ) {
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(16.dp),
//                        horizontalArrangement = Arrangement.SpaceBetween,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//
//                        Text(
//                            text = "Privacy Policy",
//                            fontSize = 15.sp
//                        )
//
//                        Icon(
//                            imageVector = Icons.Default.ChevronRight,
//                            contentDescription = "ChevronRight"
//                        )
//                    }
//                }
//                HorizontalDivider(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(start = 80.dp),
//                    thickness = 1.dp
//                )
//
//            }
//
//            }
//
//        }
//    }
//
//
//
//
//
//
//
//
//
//// @Preview(showBackground = true, widthDp = 900, heightDp = 700)
//// @Composable
//// fun SettingsScreenPreview() {
////     SettingsScreen(navController = rememberNavController())
//// }
//
package com.example.urbanlink2.ui.theme.Screens.Settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.urbanlink2.R
import com.example.urbanlink2.navigation.ROUTE_FEEDBACK
import com.example.urbanlink2.navigation.ROUTE_PREFERENCE
import com.example.urbanlink2.navigation.ROUTE_PRIVACY_POLICY
import com.example.urbanlink2.navigation.ROUTE_RATE_US
import com.example.urbanlink2.navigation.ROUTE_SELECT_COUNTRY
import com.example.urbanlink2.navigation.ROUTE_SELECT_LANGUAGE
import com.example.urbanlink2.navigation.ROUTE_SHARE
import com.example.urbanlink2.navigation.ROUTE_TERMS

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    navController: NavController,
    darkMode: Boolean,                       // ← received from MainActivity
    onDarkModeToggle: (Boolean) -> Unit      // ← callback to update theme
) {
    Scaffold( topBar = {

        TopAppBar(

            title = {

                Column {

                    Text(
                        text = "Urban Link Settings",
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

                IconButton(onClick = { navController.popBackStack() }) {

                    Icon(
                        Icons.Default.ArrowBack,
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
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(
//                        text = "Settings",
//                        fontSize = 24.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = Color.White
//                    )
//                },
//                navigationIcon = {
//                    IconButton(onClick = { navController.popBackStack() }) {
//                        Icon(
//                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                            contentDescription = "Back",
//                            tint = Color.White
//                        )
//                    }
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color(0xFF1E88E5)
//                )
//            )
//        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
//                .background(color = Color(0xFF1E88E5))
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // ── App info card ──────────────────────────────────────────
            Spacer(modifier = Modifier.width(20.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    Row(modifier = Modifier.padding(10.dp)) {
                        Image(
                            painter = painterResource(R.drawable.ic_launcher_background),
                            contentDescription = "logo",
                            modifier = Modifier.size(40.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(text = "JobsFinder")
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = "Version 1.0")
                        }
                    }
                }
            }

            // ── General section label ──────────────────────────────────
            Text(
                text = "General",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, bottom = 4.dp),
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )

            // ── Dark / Light mode toggle card ──────────────────────────
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Theme icon"
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Toggle dark/light theme",
                                fontSize = 18.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = if (darkMode) "Dark theme enabled" else "Light theme enabled",
                            fontSize = 14.sp
                        )
                    }

                    // ← This is where the real theme switch lives
                    Switch(
                        checked = darkMode,
                        onCheckedChange = { onDarkModeToggle(it) },
                        thumbContent = {
                            Icon(
                                imageVector = if (darkMode)
                                    Icons.Default.DarkMode
                                else
                                    Icons.Default.LightMode,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 80.dp),
                thickness = 1.dp
            )

            // ── Choose Country ─────────────────────────────────────────
            Card(
                onClick = { navController.navigate(ROUTE_SELECT_COUNTRY) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Choose Country", fontSize = 15.sp)
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "ChevronRight"
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 80.dp),
                thickness = 1.dp
            )

            // ── Language ───────────────────────────────────────────────
            Card(
                onClick = { navController.navigate(ROUTE_SELECT_LANGUAGE) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Language", fontSize = 15.sp)
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "ChevronRight"
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 80.dp),
                thickness = 1.dp
            )

            // ── Job Preference ─────────────────────────────────────────
            Card(
                onClick = {navController.navigate(ROUTE_PREFERENCE)},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Job Preference", fontSize = 15.sp)
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "ChevronRight"
                    )
                }
            }

            // ── Support section ────────────────────────────────────────
            Text(
                text = "Support",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 8.dp, bottom = 4.dp),
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )

            Card(modifier = Modifier.padding(20.dp)) {

                // Rate Us
                Card(
                    onClick = { navController.navigate(ROUTE_RATE_US) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(12.dp)) {
                        Icon(imageVector = Icons.Default.Star, contentDescription = "Star")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Rate Us", fontSize = 20.sp)
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Love the app? Rate us on Play Store",
                            modifier = Modifier.padding(start = 22.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = "ChevronRight"
                        )
                    }
                }

                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 80.dp),
                    thickness = 1.dp
                )

                // Share
                Card(onClick = { navController.navigate(ROUTE_SHARE) },
                    modifier = Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(12.dp)) {
                        Icon(imageVector = Icons.Default.Share, contentDescription = "Share")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Share", fontSize = 20.sp)
                    }
                    Text(
                        text = "Share this app with friends",
                        modifier = Modifier.padding(start = 22.dp, bottom = 12.dp)
                    )
                }

                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 80.dp),
                    thickness = 1.dp
                )

                // Feedback
                Card(onClick = { navController.navigate(ROUTE_FEEDBACK) },
                    modifier = Modifier.fillMaxWidth()) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(12.dp)) {
                        Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = "Feedback", fontSize = 20.sp)
                    }
                    Text(
                        text = "Send us your feedback",
                        modifier = Modifier.padding(start = 22.dp, bottom = 12.dp)
                    )
                }
            }

            // ── Legal section ──────────────────────────────────────────
            Text(
                text = "Legal",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 8.dp, bottom = 4.dp),
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )

            Card(modifier = Modifier.padding(16.dp)) {

                // Terms & Conditions
                Card(
                    onClick = { navController.navigate(ROUTE_TERMS) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Terms & Conditions", fontSize = 15.sp)
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = "ChevronRight"
                        )
                    }
                }

                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 80.dp),
                    thickness = 1.dp
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Privacy Policy
                Card(
                    onClick = { navController.navigate(ROUTE_PRIVACY_POLICY) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Privacy Policy", fontSize = 15.sp)
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = "ChevronRight"
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}