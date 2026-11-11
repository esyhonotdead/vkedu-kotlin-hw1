package com.esyhonotdead.vkedukotlinhw1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.esyhonotdead.vkedukotlinhw1.navigation.AppNavigation
import com.esyhonotdead.vkedukotlinhw1.ui.theme.VKEduAndroidHW1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKEduAndroidHW1Theme {
                AppNavigation()
            }
        }
    }
}

