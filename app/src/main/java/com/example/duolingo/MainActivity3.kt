package com.example.duolingo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.duolingo.ui.theme.DuolingoTheme

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LeagueScreen()
        }
    }
}

data class Player(
    val name: String,
    val xp: Int,
    val rank: Int
)
@Composable
fun PlayerRow(player: Player) {
    val backgroundColor = if (player.rank == 4) Color(0xFF0F2A44) else Color.Transparent

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Ranking medal
        Box(
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
                .background(
                    when (player.rank) {
                        1 -> Color(0xFFFFD700) // ouro
                        2 -> Color(0xFFC0C0C0) // prata
                        3 -> Color(0xFFCD7F32) // bronze
                        else -> Color.Transparent
                    },
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = player.rank.toString(),
                color = if (player.rank <= 3) Color.Black else Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        // Avatar (placeholder)
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .background(Color.Gray.copy(alpha = 0.4f))
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = player.name,
            color = if (player.rank == 4) Color(0xFF00FFB3) else Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = "${player.xp} XP",
            color = Color(0xFF00FF7F),
            fontWeight = FontWeight.Bold
        )
    }
}



@Composable
fun LeagueHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0F2A44))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Ícones de medalhas (placeholder simples)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(5) { i ->
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .padding(horizontal = 4.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (i == 2) Color(0xFF00C3FF) else Color.Gray.copy(alpha = 0.4f))
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Sapphire League",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "TODAY",
                    color = Color.White.copy(alpha = 0.6f),
                    fontSize = 12.sp
                )
                Text(
                    text = "+15 places",
                    color = Color(0xFF00FF7F),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "TIME LEFT",
                    color = Color.White.copy(alpha = 0.6f),
                    fontSize = 12.sp
                )
                Text(
                    text = "3 days",
                    color = Color(0xFFFFC107),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        }
    }
}
@Preview
@Composable
fun LeagueScreen() {
    val players = listOf(
        Player("Janae", 88, 1),
        Player("Komal Rai", 83, 2),
        Player("Kelly", 80, 3),
        Player("kate", 80, 4),
        Player("Javier", 79, 5),
        Player("chiquico0627", 78, 6),
        Player("Brayan Capcha", 77, 7)
    )

    Scaffold(
        containerColor = Color(0xFF081A2B),
        bottomBar = { BottomNavBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            LeagueHeader()
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp)
            ) {
                itemsIndexed(players) { index, player ->
                    PlayerRow(player = player)
                }
            }
        }
    }
}

data class Module(
    val title: String,
    val level: Int,
    val color: Color
)

@Composable
fun MainLearningScreen() {
    val modules = listOf(
        Module("Basics 1", 5, Color(0xFFFFC107)),
        Module("Phrases", 3, Color(0xFFFFC107)),
        Module("Animals", 1, Color(0xFFFF5252)),
        Module("Food", 1, Color(0xFF03A9F4)),
        Module("Family", 0, Color(0xFFE1BEE7))
    )

    Scaffold(
        topBar = { TopStatusBar() },
        bottomBar = { BottomNavBar() },
        containerColor = Color.White
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
        ) {
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(modules) { module ->
                    ModuleCard(module)
                }
            }
        }
    }
}

@Composable
fun TopStatusBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Bandeira (placeholder simples)
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Color(0xFF0055A4))
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            StatusItem(iconColor = Color(0xFFFFC107), value = "14")
            Spacer(modifier = Modifier.width(12.dp))
            StatusItem(iconColor = Color(0xFFFF5722), value = "12")
            Spacer(modifier = Modifier.width(12.dp))
            StatusItem(iconColor = Color(0xFFE91E63), value = "5")
        }
    }
}

@Composable
fun StatusItem(iconColor: Color, value: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(18.dp)
                .clip(CircleShape)
                .background(iconColor)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = value, color = Color.Black, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ModuleCard(module: Module) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(module.color),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = module.level.toString(),
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = module.title,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 14.sp
        )
    }
}

@Composable
fun BottomNavBar() {
    NavigationBar(
        containerColor = Color.White
    ) {
        NavigationBarItem(
            selected = true,
            onClick = {},
            icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = Color(0xFFFF5722)) }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Email, contentDescription = "Book", tint = Color.Gray) }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Check, contentDescription = "Leaderboard", tint = Color.Gray) }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color.Gray) }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Settings, contentDescription = "Settings", tint = Color.Gray) }
        )
    }
}