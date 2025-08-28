package com.example.duolingo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.duolingo.ui.theme.DuolingoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            telaPrincipal()
        }
    }
}

@Preview
@Composable
fun telaPrincipal () {
    Surface {
        Column {
            Row {
                header()
            }
            Row {
                tituloUnidade()
            }
            Row {
                exercicios()
            }
            Row {
                footer()
            }
        }
    }
}

@Preview
@Composable
fun tituloUnidade () {
    Surface (
        modifier = Modifier
            .background(Color(red = 91, green = 203, blue = 4))
            .fillMaxWidth()
            .height(80.dp)
    ) {
        Column(
            modifier = Modifier
                .background(Color(red = 91, green = 203, blue = 4))
                .padding(13.dp)
        ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Unit 1",
                        color = Color.White,
                        fontSize = 20.sp,
                        style = TextStyle(fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Use basic phrases, greet people",
                        color = Color.White,
                        fontSize = 17.sp,
                    )
                }
                Spacer(modifier = Modifier.width(60.dp))
                Box (
                    modifier = Modifier
                        .border(
                            width = 2.dp,
                            Color(red = 76, green = 177, blue = 4),
                            RoundedCornerShape(3.dp)
                        )
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(red = 91, green = 203, blue = 4))
                        .size(42.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.caderno),
                        contentScale = ContentScale.Fit,
                        contentDescription = "bandeira dos Estados Unidos",
                        modifier = Modifier
                            .background(Color.White)
                            .padding(4.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
        HorizontalDivider(thickness = 2.dp, color = Color(red = 76, green = 177, blue = 4))
    }
}

@Preview
@Composable
fun exercicios () {
    Surface (
        modifier = Modifier
            .background(Color.White)
            .height(440.dp)
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column {
            Row {
                Spacer(modifier = Modifier.width(180.dp))
                botao()
            }
            Row {
                Spacer(modifier = Modifier.width(110.dp))
                botao()
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(90.dp))
                botao()
                Spacer(modifier = Modifier.width(60.dp))
                Image(
                    painter = painterResource(id = R.drawable.duolingo),
                    contentDescription = "botao",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .background(Color.Transparent)
                        .padding(1.dp)
                        .size(120.dp)
                )
            }
            Row {
                Spacer(modifier = Modifier
                    .width(120.dp)
                    .height(10.dp))
                botao()
            }
        }
    }
}

@Composable
@Preview
fun footer () {
    Surface(
        modifier = Modifier
            .background(Color.White)
            .height(100.dp)
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Column (
            modifier = Modifier.background(Color.White)
        ) {
            Row (
                modifier = Modifier.background(Color.White),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box (
                    modifier = Modifier
                        .border(width = 2.dp, Color.White, RoundedCornerShape(3.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.White)
                        .size(30.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.casa),
                        contentScale = ContentScale.Crop,
                        contentDescription = "bandeira dos Estados Unidos",
                        modifier = Modifier
                            .background(Color.White)
                            .padding(1.dp)
                            .fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))
                Image(
                    painter = painterResource(id = R.drawable.fone),
                    contentScale = ContentScale.Crop,
                    contentDescription = "bandeira dos Estados Unidos",
                    modifier = Modifier
                        .background(Color.White)
                        .padding(1.dp)
                        .size(40.dp)
                )
                Spacer(modifier = Modifier.width(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.haltere),
                    contentScale = ContentScale.Fit,
                    contentDescription = "bandeira dos Estados Unidos",
                    modifier = Modifier
                        .background(Color.White)
                        .padding(1.dp)
                        .size(35.dp)
                )
                Spacer(modifier = Modifier.width(30.dp))
                Image(
                    painter = painterResource(id = R.drawable.escud),
                    contentScale = ContentScale.Crop,
                    contentDescription = "bandeira dos Estados Unidos",
                    modifier = Modifier
                        .background(Color.White)
                        .padding(1.dp)
                        .size(60.dp)
                )
                Spacer(modifier = Modifier.width(30.dp))
                Image(
                    painter = painterResource(id = R.drawable.trofeu),
                    contentScale = ContentScale.Crop,
                    contentDescription = "bandeira dos Estados Unidos",
                    modifier = Modifier
                        .background(Color.White)
                        .padding(1.dp)
                        .size(60.dp)
                )
            }
        }
    }
    HorizontalDivider(thickness = 2.dp, color = Color.Gray)
}

@Preview
@Composable
fun botao () {
    Column {
        Image(
            painter = painterResource(id = R.drawable.botao),
            contentDescription = "botao",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .background(Color.Transparent)
                .padding(1.dp)
                .size(95.dp)
        )
    }
}

@Preview
@Composable
fun header() {
    Surface(
        modifier = Modifier
            .background(Color(red = 91, green = 203, blue = 4))
            .height(60.dp)
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Column (
            modifier = Modifier.background(Color(red = 91, green = 203, blue = 4))
        ) {
            Row (
                modifier = Modifier.background(Color(red = 91, green = 203, blue = 4)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box (
                    modifier = Modifier
                        .border(width = 2.dp, Color.White, RoundedCornerShape(3.dp))
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(red = 91, green = 203, blue = 4))
                        .width(50.dp)
                        .size(30.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.italia),
                        contentScale = ContentScale.Crop,
                        contentDescription = "bandeira dos Estados Unidos",
                        modifier = Modifier
                            .background(Color(red = 91, green = 203, blue = 4))
                            .padding(1.dp)
                            .fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))
                Image(
                    painter = painterResource(id = R.drawable.fogo),
                    contentScale = ContentScale.Crop,
                    contentDescription = "bandeira dos Estados Unidos",
                    modifier = Modifier
                        .background(Color(red = 91, green = 203, blue = 4))
                        .padding(1.dp)
                        .size(40.dp)
                )
                Text(
                    text = "1",
                    color = Color.White,
                    fontSize = 17.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.width(40.dp))
                Image(
                    painter = painterResource(id = R.drawable.gema),
                    contentScale = ContentScale.Fit,
                    contentDescription = "bandeira dos Estados Unidos",
                    modifier = Modifier
                        .background(Color(red = 91, green = 203, blue = 4))
                        .padding(1.dp)
                        .size(35.dp)
                )
                Text(
                    text = "500",
                    color = Color.White,
                    fontSize = 17.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.width(30.dp))
                Image(
                    painter = painterResource(id = R.drawable.coracao),
                    contentScale = ContentScale.Crop,
                    contentDescription = "bandeira dos Estados Unidos",
                    modifier = Modifier
                        .background(Color(red = 91, green = 203, blue = 4))
                        .padding(1.dp)
                        .size(80.dp)
                )
                Text(
                    text = "4",
                    color = Color.White,
                    fontSize = 17.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }
            //HorizontalDivider(color = Color.Red, thickness = 2.dp)
        }
    }
}