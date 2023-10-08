package com.kaiqkt.components

import androidx.compose.runtime.Composable
import com.kaiqkt.models.Experience
import com.kaiqkt.models.Theme
import com.kaiqkt.util.Resources
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.times
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ExperienceCard(
    breakpoint: Breakpoint,
    active: Boolean = false,
    animatedMargin: CSSSizeValue<CSSUnit.px>,
    experience: Experience
) {
    SimpleGrid(
        modifier = Modifier
            .fillMaxWidth()
            .maxWidth(if (breakpoint >= Breakpoint.MD) 60.percent else 90.percent),
        numColumns = numColumns(base = 1, md = 2)
    ) {
        ExperienceDescription(active = active, description = experience.description)
        ExperienceDetails(
            active = active,
            breakpoint = breakpoint,
            animatedMargin = animatedMargin,
            experience = experience
        )
    }
}

@Composable
private fun ExperienceDescription(
    active: Boolean,
    description: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .margin(topBottom = 14.px)
            .lineHeight(1.6)
            .padding(all = 14.px)
            .borderRadius(4.px)
            .backgroundColor(if (active) Theme.Primary.rgb else Theme.LighterGray.rgb)
    ) {
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .fontFamily(Resources.FONT_FAMILY)
                .fontSize(14.px)
                .color(if (active) Color.white else Theme.Secondary.rgb)
                .fontWeight(FontWeight.Normal)
                .toAttrs()
        ) {
            Text(description)
        }
    }
}

@Composable
private fun ExperienceDetails(
    active: Boolean,
    breakpoint: Breakpoint,
    experience: Experience,
    animatedMargin: CSSSizeValue<CSSUnit.px>,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .margin(left = if (breakpoint >= Breakpoint.MD) 14.px else 0.px),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint >= Breakpoint.MD) {
            ExperienceNumber(active, experience)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .margin(left = if (breakpoint <= Breakpoint.SM) 0.px else animatedMargin)
                .transition(
                    CSSTransition(
                        property = "margin",
                        duration = 500.ms,
                        delay = experience.ordinal * 100.ms
                    )
                ),
            verticalArrangement = Arrangement.Center
        ) {
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(Resources.FONT_FAMILY)
                    .fontSize(20.px)
                    .color(Theme.Secondary.rgb)
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()
            ) {
                Text(experience.position)
            }

            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(Resources.FONT_FAMILY)
                    .fontSize(14.px)
                    .color(Theme.Secondary.rgb)
                    .fontWeight(FontWeight.Normal)
                    .toAttrs()
            ) {
                Text("${experience.from} - ${experience.to}")
            }

            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(Resources.FONT_FAMILY)
                    .fontSize(14.px)
                    .color(Theme.Primary.rgb)
                    .fontWeight(FontWeight.Normal)
                    .toAttrs()
            ) {
                Text(experience.company)
            }
        }
    }
}

@Composable
private fun ExperienceNumber(
    active: Boolean,
    experience: Experience
) {
    Box(
        modifier = Modifier
            .margin(right = 14.px)
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(3.px)
                .backgroundColor(Theme.Primary.rgb)
        )
        Box(
            modifier = Modifier
                .size(40.px)
                .border(
                    width = 3.px,
                    style = LineStyle.Solid,
                    color = Theme.Primary.rgb
                )
                .borderRadius(50.percent)
                .backgroundColor(if (active) Theme.Primary.rgb else Color.white),
            contentAlignment = Alignment.Center
        ) {
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(Resources.FONT_FAMILY)
                    .fontSize(16.px)
                    .color(if (active) Color.white else Theme.Primary.rgb)
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()
            ) {
                Text(experience.number)
            }
        }
    }
}