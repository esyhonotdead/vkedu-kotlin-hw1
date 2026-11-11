package com.esyhonotdead.vkedukotlinhw1.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.esyhonotdead.vkedukotlinhw1.R
import com.esyhonotdead.vkedukotlinhw1.ui.theme.getCardColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardScreen(
    number: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val cardColor = getCardColor(number)

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.back))
                },
                navigationIcon = {
                    IconButton(onClick = onClick) {
                        Icon(
                            painter = painterResource(
                                R.drawable.ic_launcher_foreground
                            ),
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = cardColor),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = number.toString(),
                color = Color.White
            )
        }
    }
}