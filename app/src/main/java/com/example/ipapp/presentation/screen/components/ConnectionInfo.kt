package com.example.ipapp.presentation.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ipapp.R
import com.example.ipapp.presentation.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ConnectionInfo(mainViewModel: MainViewModel = koinViewModel()) {

    val ipData = mainViewModel.ipData.collectAsState().value

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .alpha(.7f),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
            contentColor = MaterialTheme.colorScheme.onBackground
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            ipData.connectionType?.let {
                Text(
                    text = stringResource(id = R.string.connection_type_text, it),
                    style = MaterialTheme.typography.labelMedium,
                )
            }

            ipData.organization?.let {
                Text(
                    text = stringResource(id = R.string.organization_text, it),
                    style = MaterialTheme.typography.labelMedium,
                )
            }

            ipData.ispName?.let {
                Text(
                    text = stringResource(id = R.string.isp_name_text, it),
                    style = MaterialTheme.typography.labelMedium,
                )
            }

            ipData.asn?.let {
                Text(
                    text = stringResource(id = R.string.asn_text, it),
                    style = MaterialTheme.typography.labelMedium,
                )
            }

            ipData.asnOrganization?.let {
                Text(
                    text = stringResource(id = R.string.asn_organization_text, it),
                    style = MaterialTheme.typography.labelMedium,
                )
            }
        }
    }
}