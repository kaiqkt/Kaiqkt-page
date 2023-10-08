package com.kaiqkt.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.kaiqkt.components.BackToTopButton
import com.kaiqkt.components.OverflowMenu
import com.kaiqkt.sections.ExperienceSection
import com.kaiqkt.sections.FooterSection
import com.kaiqkt.sections.MainSection
import com.kaiqkt.sections.PortfolioSection
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage() {
    var menuOpened by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainSection(onMenuClicked = { menuOpened = true })
            PortfolioSection()
            ExperienceSection()
            FooterSection()
        }
        BackToTopButton()

        if (menuOpened) {
            OverflowMenu {
                menuOpened = false
            }
        }
    }
}
