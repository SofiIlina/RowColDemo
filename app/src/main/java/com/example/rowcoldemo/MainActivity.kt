package com.example.rowcoldemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rowcoldemo.ui.theme.RowColDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RowColDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
// Принимает текст и необязательный модификатор
fun TextCell(text: String, modifier: Modifier = Modifier) {

    // Создание кастомного модификатора на основе переданного
    val cellModifier = modifier
        .padding(4.dp)          // внутренние отступы 4dp со всех сторон
        .size(100.dp, 100.dp)   // фиксированный размер 100x100 dp
        .border(width = 4.dp, color = Color.Black)  // черная рамка толщиной 4dp

    // Composable-компонент Text для отображения текста
    Text(
        text = text,                    // Текст для отображения (из параметра функции)
        modifier = cellModifier,        // Применяет кастомный модификатор
        fontSize = 80.sp,               // Устанавливает очень крупный размер шрифта
        fontWeight = FontWeight.Bold,   // Делает текст жирным
        textAlign = TextAlign.Center    // Выравнивает текст по центру
    )
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Row(modifier) {
        TextCell("1")
        TextCell("2")
        TextCell("3")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RowColDemoTheme {
        MainScreen()
    }
}