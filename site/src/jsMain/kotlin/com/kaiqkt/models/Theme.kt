package com.kaiqkt.models

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

enum class Theme(
    val hex: String,
    val rgb: CSSColorValue
) {
    Primary(hex = "#765898", rgb = rgb(r = 118, g = 88, b = 152)),
    Secondary(hex = "#121D34", rgb = rgb(r = 18, g = 29, b = 52)),
    Gray(hex = "#CFCFCF", rgb = rgb(r = 207, g = 207, b = 207)),
    LighterGray(hex = "#F9F9F9", rgb = rgb(r = 249, g = 249, b = 249))
}