package com.uth.week3.jetpacknavigation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uth.week3.jetpacknavigation.ui.theme.JetpackNavigationTheme
import androidx.core.net.toUri


// ---------------- ROUTES ----------------
object AppRoutes {
    const val ONBOARDING_SCREEN = "onboarding"
    const val COMPONENTS_LIST_SCREEN = "components_list"
    const val TEXT_DETAIL_SCREEN = "text_detail"
    const val IMAGE_SCREEN = "image_screen"
    const val TEXTFIELD_SCREEN = "textfield_screen"
    const val PASSWORDFIELD_SCREEN = "passwordfield_screen"
    const val COLUMN_SCREEN = "column_screen"
    const val ROW_SCREEN = "row_screen"
    const val CHECKBOX_SCREEN = "checkbox_screen"
    const val RADIO_SCREEN = "radio_screen"
    const val DROPDOWNLIST_SCREEN = "dropdownlist_screen"
    const val TOGGLE_SCREEN = "toggle_screen"
    const val SLIDER_SCREEN = "slider_screen"
    const val HYPERLINK_SCREEN = "hyperink_screen"
}

//TopBar with Arrow Back and Title of Features
@Composable
fun SimpleTopAppBar(title: String, onBackClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Turn back button
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }
        // Title
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
    }
}


// ---------------- MAIN ACTIVITY ----------------
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackNavigationTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = AppRoutes.ONBOARDING_SCREEN
                ) {
                    composable(AppRoutes.ONBOARDING_SCREEN) {
                        OnboardingScreen(onNavigate = {
                            navController.navigate(AppRoutes.COMPONENTS_LIST_SCREEN)
                        })
                    }
                    composable(AppRoutes.COMPONENTS_LIST_SCREEN) {
                        ComponentsListScreen(navController)
                    }
                    //6 features required (Homework)
                    composable(AppRoutes.TEXT_DETAIL_SCREEN) { TextDetailScreen(navController) }
                    composable(AppRoutes.IMAGE_SCREEN) { ImageScreen(navController) }
                    composable(AppRoutes.TEXTFIELD_SCREEN) { TextFieldScreen(navController) }
                    composable(AppRoutes.PASSWORDFIELD_SCREEN) { PasswordFieldScreen(navController) }
                    composable(AppRoutes.COLUMN_SCREEN) { ColumnScreen(navController) }
                    composable(AppRoutes.ROW_SCREEN) { RowScreen(navController) }
                    composable(AppRoutes.CHECKBOX_SCREEN) { CheckboxScreen(navController) }
                    composable(AppRoutes.RADIO_SCREEN) { RadioScreen(navController) }
                    composable(AppRoutes.DROPDOWNLIST_SCREEN){ DropDownListScreen(navController) }
                    composable(AppRoutes.TOGGLE_SCREEN){ ToggleScreen(navController) }
                    composable(AppRoutes.SLIDER_SCREEN){ SliderScreen(navController) }
                    composable(AppRoutes.HYPERLINK_SCREEN){ HyperLinkScreen(navController) }
                }
            }
        }
    }
}



// ---------------- ONBOARDING SCREEN ----------------
@Composable


fun OnboardingScreen(onNavigate: () -> Unit) {

    //Logo, title and content
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.jetpack_compose_logo),
                contentDescription = "Jetpack Compose Logo",
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Jetpack Compose",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color.Gray
            )
        }


        //Continue button, click it. It moves to UI Components List
        Button(
            onClick = onNavigate,
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3797EF)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "I'm ready", fontSize = 18.sp, color = Color.White)
        }
    }
}


// ---------------- COMPONENT LIST SCREEN ----------------
@Composable
fun ComponentsListScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "UI Components List",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        //List of Homework

        //Display
        Spacer(modifier = Modifier.height(24.dp))

        SectionTitle("Display")

        Spacer(modifier = Modifier.height(8.dp))
        ComponentItem("Text", "Displays text") {
            navController.navigate(AppRoutes.TEXT_DETAIL_SCREEN)
        }
        Spacer(modifier = Modifier.height(8.dp))
        ComponentItem("Image", "Displays an image") {
            navController.navigate(AppRoutes.IMAGE_SCREEN)
        }

        //Input
        Spacer(modifier = Modifier.height(24.dp))

        SectionTitle("Input")

        Spacer(modifier = Modifier.height(8.dp))
        ComponentItem("TextField", "Input field for text") {
            navController.navigate(AppRoutes.TEXTFIELD_SCREEN)
        }
        Spacer(modifier = Modifier.height(8.dp))
        ComponentItem("PasswordField", "Input field for passwords") {
            navController.navigate(AppRoutes.PASSWORDFIELD_SCREEN)
        }

        Spacer(modifier = Modifier.height(24.dp))



        //Layout
        SectionTitle("Layout")

        Spacer(modifier = Modifier.height(8.dp))
        ComponentItem("Column", "Arranges elements vertically") {
            navController.navigate(AppRoutes.COLUMN_SCREEN)
        }
        Spacer(modifier = Modifier.height(8.dp))
        ComponentItem("Row", "Arranges elements horizontally") {
            navController.navigate(AppRoutes.ROW_SCREEN)
        }

        Spacer(modifier = Modifier.height(24.dp))


        //More
        SectionTitle("More")

        Spacer(modifier = Modifier.height(8.dp))

        ComponentItem("Checkbox", "Choose many options") {
            navController.navigate(AppRoutes.CHECKBOX_SCREEN)
        }

        Spacer(modifier = Modifier.height(8.dp))

        ComponentItem("Radio", "Choose only one option") {
            navController.navigate(AppRoutes.RADIO_SCREEN)
        }

        Spacer(modifier = Modifier.height(8.dp))

        ComponentItem("Drop Down", "Display a list of options or content after click") {
            navController.navigate(AppRoutes.DROPDOWNLIST_SCREEN)
        }

        Spacer(modifier = Modifier.height(8.dp))

        ComponentItem("Toggle", "Allows users to turn a setting on or off") {
            navController.navigate(AppRoutes.TOGGLE_SCREEN)
        }

        Spacer(modifier = Modifier.height(8.dp))

        ComponentItem("Slider", "Sliding like volume") {
            navController.navigate(AppRoutes.SLIDER_SCREEN)
        }

        Spacer(modifier = Modifier.height(8.dp))

        ComponentItem("Hyper Link", "Click links to locate of the link") {
            navController.navigate(AppRoutes.HYPERLINK_SCREEN)
        }
    }
}


// A title for a section in the components list.
@Composable
fun SectionTitle(title: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(CircleShape)
                .background(Color.Red)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
    }
}


//An individual, clickable item in the components list.
@Composable
fun ComponentItem(title: String, description: String, onClick: () -> Unit) {
    Surface(
        color = Color(0xFFD0E6FF),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = title,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

// ---------------- FEATURES SCREENS ----------------

// Text Detail
@Composable
fun TextDetailScreen(navController: NavController) {
    val dancingFont = FontFamily(Font(R.font.dancingscript_variablefont_wght))

    Column(modifier = Modifier.fillMaxSize()) {

        SimpleTopAppBar(title = "Text Detail",
            onBackClick = { navController.popBackStack() }
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = buildAnnotatedString {
                    append("The ")
                    withStyle(SpanStyle(textDecoration = TextDecoration.LineThrough)){
                        append("quick")
                    }
                    withStyle(SpanStyle(
                        color = Color(0xFF8B4513),
                        fontSize = 45.sp,
                        fontWeight = FontWeight.Bold )){
                        append(" Brown ")
                    }
                    append("fox j\u00A0u\u00A0m\u00A0p\u00A0s ")
                    withStyle(SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic)
                    ) {
                        append("over ")
                    }
                    withStyle(SpanStyle(textDecoration = TextDecoration.Underline)){
                        append("the")
                    }
                    withStyle(SpanStyle(
                        fontFamily = dancingFont
                    )){
                        append(" lazy ")
                    }
                    append("dog.")
                },
                fontSize = 40.sp,
                lineHeight = 40.sp,
                textAlign = TextAlign.Center
            )
        }

    }
}


//Image Screen
@Composable
fun ImageScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        SimpleTopAppBar(
            title = "Image", onBackClick = { navController.popBackStack() }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.frog_it), // Giả sử bạn có ảnh này
                contentDescription = "Local Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Frog is coding",
                fontSize = 16.sp
            )
        }
    }
}


//Text Field Screen
@Composable
fun TextFieldScreen(navController: NavController) {
    var text by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()) {
        SimpleTopAppBar(title = "TextField",
            onBackClick = { navController.popBackStack() }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Thông tin nhập") },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    cursorColor = Color.Black,
                    focusedTextColor = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Tự động cập nhật dữ liệu theo textfield",
                color = Color.Red
            )
        }
    }
}


//Password Field Screen
@Composable
fun PasswordFieldScreen(navController: NavController) {
    var password by remember { mutableStateOf("") }
    var visible by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        SimpleTopAppBar(title = "Password Field",
            onBackClick = { navController.popBackStack() }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Nhập mật khẩu") },
                visualTransformation = if (visible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (visible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    IconButton(onClick = { visible = !visible }) {
                        Icon(imageVector = image, contentDescription = "Toggle password visibility")
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    focusedLabelColor = Color.Black,
                    unfocusedLabelColor = Color.Black,
                    cursorColor = Color.Black,
                    focusedTextColor = Color.Black
                )
            )
        }
    }
}


//Column Screen
@Composable
fun ColumnScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        SimpleTopAppBar(title = "Column",
            onBackClick = { navController.popBackStack() }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(5) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(Color(0xFFADD8E6), RoundedCornerShape(12.dp))
                )
            }
        }
    }
}


//Row Screen
@Composable
fun RowScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        SimpleTopAppBar(title = "Row",
            onBackClick = { navController.popBackStack() }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(3) {
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .background(Color(0xFF90CAF9), RoundedCornerShape(12.dp))
                    )
                }
            }
        }
    }
}


//Check Box Screen
@Composable
fun CheckboxScreen(navController: NavController) {
    val listItems = listOf(
        "Lập trình hướng đối tượng",
        "Lập trình Java",
        "Lập trình web",
        "Lập trình thiết bị di động",
        "Cấu trúc dữ liệu và giải thuật",
        "Công nghệ phần mềm"
    )
    var checked by remember { mutableStateOf(mapOf<String, Boolean>()) }

    fun toggleChecked(item: String, value: Boolean) {
        checked = checked.toMutableMap().apply { this[item] = value }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        SimpleTopAppBar(title = "Checkbox", onBackClick = { navController.popBackStack() })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                "Những môn học mà bạn thích:",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            listItems.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { toggleChecked(item, !(checked[item] ?: false)) }
                ) {
                    Checkbox(
                        checked = checked[item] ?: false,
                        onCheckedChange = { toggleChecked(item, it) }
                    )
                    Text(text = item, modifier = Modifier.padding(start = 8.dp))
                }
            }
        }
    }
}

//Radio Screen
@Composable
fun RadioScreen(navController: NavController) {
    val genderOptions = listOf("Nam", "Nữ", "Khác")
    var selectedOption by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()) {
        SimpleTopAppBar(title = "Radio Button", onBackClick = { navController.popBackStack() })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text("Giới tính:", style = MaterialTheme.typography.titleMedium)
            genderOptions.forEach { option ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { selectedOption = option }
                ) {
                    RadioButton(
                        selected = selectedOption == option,
                        onClick = { selectedOption = option }
                    )
                    Text(option, modifier = Modifier.padding(start = 8.dp))
                }
            }
            Text("Đã chọn: $selectedOption", modifier = Modifier.padding(top = 16.dp))
        }
    }
}


//Drop Down List
@Composable
fun DropDownListScreen(navController: NavController) {
    var expanded by remember { mutableStateOf(false) }
    val options = listOf("Red", "Green", "Blue")
    var selectedText by remember { mutableStateOf(options[0]) }

    Column(modifier = Modifier.fillMaxSize()) {
        SimpleTopAppBar(title = "Drop Down", onBackClick = { navController.popBackStack() })
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Box {
                Button(onClick = { expanded = !expanded }) {
                    Text(selectedText)
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    options.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(option) },
                            onClick = {
                                selectedText = option
                                expanded = false
                            }
                        )
                    }
                }
            }
        }
    }
}

//Toggle Screen
@Composable
fun ToggleScreen(navController: NavController) {
    var isOn by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize()) {
        SimpleTopAppBar(title = "Toggle", onBackClick = { navController.popBackStack() })
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = { isOn = !isOn },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isOn) Color(0xFF4CAF50) else Color.Gray
                )
            ) {
                Text(if (isOn) "ON" else "OFF", color = Color.White)
            }
        }
    }
}


//Slider Screen
@Composable
fun SliderScreen(navController: NavController) {
    var sliderValue by remember { mutableFloatStateOf(0.5f) }
    Column(modifier = Modifier.fillMaxSize()) {
        SimpleTopAppBar(title = "Slider", onBackClick = { navController.popBackStack() })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Giá trị: ${"%.2f".format(sliderValue)}")
            Slider(
                value = sliderValue,
                onValueChange = { sliderValue = it }
            )
        }
    }
}


//Hyperlink Screen
@Composable
fun HyperLinkScreen(navController: NavController) {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize()) {
        SimpleTopAppBar(title = "Link", onBackClick = { navController.popBackStack() })
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Facebook: vutridung2311",
                color = Color.Blue,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_VIEW, "https://www.facebook.com/vutridung2311/".toUri())
                    context.startActivity(intent)
                }
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "X (Twitter): dungvutri2005",
                color = Color.Blue,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_VIEW, "https://x.com/dungvutri2005".toUri())
                    context.startActivity(intent)
                }
            )
            Spacer(Modifier.height(16.dp))
            Text(
                text = "Instagram: dungvutri25",
                color = Color.Blue,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_VIEW, "https://www.instagram.com/dungvutri25/".toUri())
                    context.startActivity(intent)
                }
            )
        }
    }
}


// ---------------- PREVIEW ----------------
@Preview(showBackground = true)
@Composable
fun PreviewOnboarding() {
    JetpackNavigationTheme {
        OnboardingScreen {}
    }
}

