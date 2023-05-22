package com.example.composeadmin.ui.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.composeadmin.domain.model.Variable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeadmin.R
import com.example.composeadmin.ui.LoadingCircular
import com.example.composeadmin.ui.theme.Poppins

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel) {

    val uiState by viewModel.homeUIState.collectAsState()
    Box(Modifier.fillMaxSize()) {
        when (uiState) {
            is HomeUIState.Error -> ErrorMessage(
                Modifier.align(Alignment.Center),
                (uiState as HomeUIState.Error).error ?: "Generic error"
            )

            HomeUIState.Loading -> LoadingCircular(Modifier.align(Alignment.Center))

            is HomeUIState.Success -> HomeScreen(variables = (uiState as HomeUIState.Success).list!!)
        }
    }
}

@Composable
fun HomeScreen(variables: List<Variable>) {
    VariableList(variables = variables)
}


@Composable
fun ErrorMessage(modifier: Modifier, mesg: String) {
    Column(
        modifier = modifier
            .padding(10.dp)
            .background(
                color = Color(0xFFF2F2F2),
                shape = RoundedCornerShape(15.dp)
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_error_outline_24),
            contentDescription = "Error icon",
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .padding(20.dp),
            colorFilter = ColorFilter.tint(Color(0xFFF0133F))
        )
        Text(
            text = mesg,
            modifier = Modifier
                .padding(top = 7.dp, start = 20.dp, end = 20.dp)
                .offset(y = (-15).dp),
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun ReloadButton() {
    Image(
        painter = painterResource(id = R.drawable.baseline_refresh_24),
        contentDescription = "Refresh button",
        modifier = Modifier
            .padding(3.dp)
            .clickable { Log.d("nñasda", "chirimolla") }
    )
}