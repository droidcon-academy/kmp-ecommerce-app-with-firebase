package com.droidcon.athletica

import androidx.compose.ui.window.ComposeUIViewController
import com.droidcon.di.initializeKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initializeKoin() }
) { App() }