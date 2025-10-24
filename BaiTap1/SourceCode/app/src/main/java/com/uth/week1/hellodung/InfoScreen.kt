package com.uth.week1.hellodung

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavController

@Composable
fun InfoScreen(navController: NavController) {
    val context = navController.context

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background with image
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Main content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Avatar
            Image(
                painter = painterResource(id = R.drawable.frog_it),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .border(4.dp, MaterialTheme.colorScheme.primary, CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(24.dp))

            // PERSONAL INFO BOX
            InfoBox {
                SectionTitle("THÔNG TIN CÁ NHÂN")
                Text("Họ và tên: Vũ Trí Dũng")
                Text("Ngày sinh: 23/11/2005")
                Text("Email (cá nhân): dungvutri25@gmail.com")
                Text("Số điện thoại (chính): 0931466930")
                Text("Số điện thoại (phụ): 0903601125")

            }

            Spacer(modifier = Modifier.height(16.dp))

            // STUDY INFO BOX
            InfoBox {
                SectionTitle("THÔNG TIN HỌC TẬP")
                Text("Trường: Đại học Giao thông vận tải TPHCM")
                Text("MSSV: 022205001700")
                Text("Niên khóa: 2023-2026")
                Text("Ngành: Công nghệ thông tin")
                Text("Chuyên ngành: Công nghệ thông tin")
                Text("Email (trường): dungvt1700@ut.edu.vn")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // SOCIAL MEDIA BOX
            InfoBox {
                SectionTitle("MẠNG XÃ HỘI")
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SocialIcon(
                        resId = R.drawable.facebook,
                        url = "https://www.facebook.com/vutridung2311/",
                        context = context
                    )
                    SocialIcon(
                        resId = R.drawable.instagram,
                        url = "https://www.instagram.com/dungvutri25/",
                        context = context
                    )
                    SocialIcon(
                        resId = R.drawable.x,
                        url = "https://x.com/dungvutri2005",
                        context = context
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Back button
            Button(onClick = { navController.navigate("hello") }) {
                Text("Quay lại")
            }
        }
    }
}

/* Section Title */
@Composable
fun SectionTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        textAlign = TextAlign.Center
    )
}

/* Box container for info sections */
@Composable
fun InfoBox(content: @Composable ColumnScope.() -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray.copy(alpha = 0.7f) // xám trong suốt
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            content()
        }
    }
}

/* Circle Social Icon */
@Composable
fun SocialIcon(resId: Int, url: String, context: Context) {
    Image(
        painter = painterResource(id = resId),
        contentDescription = "Social Icon",
        modifier = Modifier
            .size(60.dp)
            .clip(CircleShape)
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, url.toUri())
                context.startActivity(intent)
            },
        contentScale = ContentScale.Crop
    )
}
