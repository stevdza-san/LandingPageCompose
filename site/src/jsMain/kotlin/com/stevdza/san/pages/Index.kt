package com.stevdza.san.pages

import androidx.compose.runtime.*
import com.stevdza.san.sections.AboutSection
import com.stevdza.san.sections.MainSection
import com.stevdza.san.sections.PortfolioSection
import com.stevdza.san.sections.ServiceSection
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MainSection()
        AboutSection()
        ServiceSection()
        PortfolioSection()
    }
}