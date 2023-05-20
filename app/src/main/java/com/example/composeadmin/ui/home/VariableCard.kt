package com.example.composeadmin.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeadmin.domain.model.Variable
import com.example.composeadmin.ui.components.MultiColorText
import com.example.composeadmin.ui.utils.Poppins

@Composable
fun VariableCard(variable: Variable) {
    Surface(
        color = Color(0xFFF2F2F2),
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp)
    ) {
        Column(
            modifier = Modifier.padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MultiColorText(
                text1 = variable.value,
                color1 = Color(0xFF000000),
                text2 = variable.change,
                color2 = if (variable.change.contains("+")) Color(0xFF33BE00) else Color(0xFFEC2323)
            )
            Text(
                color = Color(0xFF5F5F5F),
                text = variable.label,
                modifier = Modifier
                    .padding(start = 5.dp, end=5.dp)
                    .offset(y = (-5).dp),
                maxLines = 1,
                fontFamily = Poppins,
                fontWeight = FontWeight.Medium,
                fontSize = 17.sp,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun VariableCardPreview() {
    VariableCard(variable = Variable("Total", "81922", " 10-"))
}

