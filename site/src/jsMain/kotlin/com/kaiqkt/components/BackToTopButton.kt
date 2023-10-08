package com.kaiqkt.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.kaiqkt.models.Theme
import com.kaiqkt.styles.BackToTopStyle
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.Visibility
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.visibility
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowUp
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun BackToTopButton() {
    val breakpoint = rememberBreakpoint()
    var scroll: Double? by remember { mutableStateOf(null) }

    LaunchedEffect(Unit) {
        window.addEventListener(type = "scroll", callback = {
            scroll = document.documentElement?.scrollTop
        })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .position(Position.Fixed)
            .zIndex(1)
            .styleModifier {
                property("pointer-events", "none")
            },
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        Box(
            modifier = BackToTopStyle.toModifier()
                .size(50.px)
                .visibility(
                    if (scroll != null && scroll!! > 350.0)
                        Visibility.Visible
                    else
                        Visibility.Hidden
                )
                .borderRadius(20.percent)
                .margin(
                    right = if (breakpoint >= Breakpoint.SM) 30.px else 40.px,
                    bottom = if (breakpoint >= Breakpoint.SM) 30.px else 40.px
                )
                .backgroundColor(Theme.Primary.rgb)
                .cursor(Cursor.Pointer)
                .onClick {
                    document.documentElement?.scroll(x = 0.0, y = 0.0)
                }
                .styleModifier {
                    property("pointer-events", "auto")
                },
            contentAlignment = Alignment.Center
        ) {
            FaArrowUp(
                modifier = Modifier.color(Colors.White),
                size = IconSize.LG
            )
        }
    }
}