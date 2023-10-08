package com.kaiqkt.components

import androidx.compose.runtime.Composable
import com.kaiqkt.models.Portfolio
import com.kaiqkt.models.Theme
import com.kaiqkt.styles.PortfolioSectionStyle
import com.kaiqkt.util.Resources
import com.kaiqkt.util.Resources.Image.LINK_ICON
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.Width
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun PortfolioCard(
    modifier: Modifier = Modifier,
    portfolio: Portfolio,
    link: String = Resources.GITHUB_URL
) {
    Link(
        modifier = PortfolioSectionStyle.toModifier().textDecorationLine(TextDecorationLine.None),
        path = link,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        Column(
            modifier = modifier
                .id("columnParent")
                .width(Width.MaxContent)
        ) {
            Box(
                modifier = Modifier
                    .id("boxParent")
                    .fillMaxWidth()
                    .maxWidth(300.px)
                    .margin(bottom = 20.px)

            ) {
                Image(
                    modifier = Modifier
                        .size(300.px)
                        .objectFit(ObjectFit.Cover),
                    src = portfolio.image,
                    desc = "Portfolio Image"
                )
                Box(
                    modifier = Modifier
                        .id("greenOverlay")
                        .fillMaxHeight()
                        .backgroundColor(argb(a = 0.5f, r = 0, g = 167, b = 142)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .id("linkIcon")
                            .size(32.px),
                        src = LINK_ICON,
                        desc = "Link Icon"
                    )
                }
            }

            P(
                attrs = Modifier
                    .id("portfolioTitle")
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(Resources.FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()
            ) {
                Text(portfolio.title)
            }

            P(
                attrs = Modifier
                    .id("portfolioDesc")
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(Resources.FONT_FAMILY)
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)
                    .opacity(50.percent)
                    .toAttrs()
            ) {
                Text(portfolio.description)
            }
        }
    }
}