package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab1.ui.theme.Lab1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Lab1Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF4F1FF)
                ) {
                    NewsScreen()
                }
            }
        }
    }
}



data class NewsItem(
    val title: String,
    val description: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val iconBg: Color
)



@Composable
fun NewsScreen() {

    val newsList = listOf(
        NewsItem(
            "Campus Event Tonight",
            "Student club meeting at 6 PM in Room 204.",
            Icons.Filled.Event,
            Color(0xFF2ECC71)
        ),
        NewsItem(
            "New Cafeteria Menu",
            "New vegetarian options available this week.",
            Icons.Filled.Restaurant,
            Color(0xFF3498DB)
        ),
        NewsItem(
            "Lab Deadline",
            "Lab 01 is due Friday at midnight.",
            Icons.Filled.Assignment,
            Color(0xFFE67E22)
        ),
        NewsItem(
            "Sports Tryouts",
            "Basketball tryouts start Monday. Bring your ID.",
            Icons.Filled.SportsBasketball,
            Color(0xFFE74C3C)
        ),
        NewsItem(
            "Library Hours",
            "Library open until 10 PM this week.",
            Icons.Filled.MenuBook,
            Color(0xFF9B59B6)
        ),
        NewsItem(
            "Android Workshop",
            "Free Android workshop Saturday morning.",
            Icons.Filled.Android,
            Color(0xFF16A085)
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "News",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2C2C2C)
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(newsList) { item ->
                NewsCard(item)

                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color(0xFFDDD6F3)
                )
            }
        }
    }
}



@Composable
fun NewsCard(item: NewsItem) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Colored circular icon background (like screenshot style)
            Box(
                modifier = Modifier
                    .size(54.dp)
                    .clip(CircleShape)
                    .background(item.iconBg),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color(0xFF222222)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = item.description,
                    fontSize = 13.sp,
                    color = Color(0xFF666666),
                    lineHeight = 18.sp
                )
            }
        }
    }
}