package com.esyhonotdead.vkedukotlinhw1

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.esyhonotdead.vkedukotlinhw1.ui.theme.Dimens
import com.esyhonotdead.vkedukotlinhw1.ui.theme.VKEduAndroidHW1Theme

private val GridBottomPadding = 110.dp
private val AddNewBoxButtonSize = 80.dp
private val TextBoxFontSize = 52.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKEduAndroidHW1Theme {
                HomePage()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage() {
    var cardCount by rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = stringResource(R.string.home_title), textAlign = TextAlign.Center
            )
        })
    }, containerColor = MaterialTheme.colorScheme.background, floatingActionButton = {
        AddNewBoxButton(
            onClick = { cardCount++ })
    }) { innerPadding ->
        TextCardGrid(
            cardCount = cardCount, modifier = Modifier.padding(innerPadding)
        )
    }
}

private object GridDefaults {
    const val PORTRAIT_COLUMNS = 3
    const val LANDSCAPE_COLUMNS = 4
}

@Composable
fun TextCardGrid(
    cardCount: Int, modifier: Modifier = Modifier
) {
    val orientation = LocalConfiguration.current.orientation


    val columns = when (orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> GridDefaults.LANDSCAPE_COLUMNS
        else -> GridDefaults.PORTRAIT_COLUMNS
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        modifier = modifier,
        contentPadding = PaddingValues(
            start = Dimens.sizeS, end = Dimens.sizeS, top = Dimens.sizeS, bottom = GridBottomPadding
        ),
        horizontalArrangement = Arrangement.spacedBy(Dimens.sizeS),
        verticalArrangement = Arrangement.spacedBy(Dimens.sizeS)
    ) {
        items(count = cardCount) { index ->
            val number = index + 1
            val isEven = number % 2 == 0

            TextBox(
                text = number.toString(),
                textColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .background(
                        color = if (isEven) Color.Red else Color.Blue,
                        shape = RoundedCornerShape(Dimens.sizeM)
                    ),
            )
        }
    }
}

@Composable
fun TextBox(
    text: String, textColor: Color, modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier, contentAlignment = Alignment.Center
    ) {
        Text(
            text = text, color = textColor, fontSize = TextBoxFontSize
        )
    }
}

@Composable
fun AddNewBoxButton(
    onClick: () -> Unit, modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier.size(AddNewBoxButtonSize),
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = stringResource(R.string.add_square)
        )
    }
}