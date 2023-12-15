package com.example.ipapp.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ipapp.R
import com.example.ipapp.presentation.screen.components.ConnectionInfo
import com.example.ipapp.presentation.screen.components.CountryInfo
import com.example.ipapp.presentation.screen.components.ErrorText
import com.example.ipapp.presentation.screen.components.IpInputText
import com.example.ipapp.presentation.screen.components.LatLonInfo
import com.example.ipapp.presentation.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun MainScreen(mainViewModel: MainViewModel = koinViewModel()) {

    val ipData = mainViewModel.ipData.collectAsState().value
    val errorForDisplayRes = mainViewModel.errorForDisplayRes.collectAsState().value
    val ipIsCurrent = mainViewModel.ipIsCurrent.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.secondary,
                        MaterialTheme.colorScheme.tertiary
                    )
                )
            )
            .padding(top = 10.dp, start = 10.dp, end = 10.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        IpInputText()

        if (ipIsCurrent)
            Text(
                text = stringResource(id = R.string.current_ip_text),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleMedium
            )

        when {
            errorForDisplayRes != R.string.empty -> {
                ErrorText(text = stringResource(id = errorForDisplayRes))
            }

            ipData.message != null -> {
                ErrorText(text = ipData.message)
            }

            ipData.connectionType != null -> {
                CountryInfo()
                LatLonInfo()
                ConnectionInfo()
            }

            ipData.country != null -> {
                CountryInfo()
                LatLonInfo()
            }
        }
    }
}