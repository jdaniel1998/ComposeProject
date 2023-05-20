package com.example.composeadmin.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeadmin.ui.utils.Poppins

@Composable
fun MultiColorText(
    text1: String,
    color1: Color,
    text2: String,
    color2: Color
) {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = color1)) {
                append(text1)
            }
            withStyle(style = SpanStyle(color = color2)) {
                append(text2)
            }
        },
        modifier = Modifier.padding(top = 8.dp),
        maxLines = 1,
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )
}