package com.example.composeadmin.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LoadingCircular(modifier: Modifier){
    CircularProgressIndicator(color= Color.Black, strokeWidth = 5.dp, modifier = modifier)
}