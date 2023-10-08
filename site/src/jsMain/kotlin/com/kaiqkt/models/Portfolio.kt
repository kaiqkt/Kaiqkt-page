package com.kaiqkt.models

import com.kaiqkt.util.Resources

enum class Portfolio(
    val image: String,
    val title: String,
    val description: String
) {
    One(
        image = Resources.Image.PORTFOLIO,
        title = "Kudoe",
        description = "Web Design"
    ),
    Two(
        image = Resources.Image.PORTFOLIO,
        title = "Landing Page for NFT",
        description = "Frontend"
    ),
    Three(
        image = Resources.Image.PORTFOLIO,
        title = "NFT Application",
        description = "Frontend/Backend"
    ),
    Four(
        image = Resources.Image.PORTFOLIO,
        title = "Game Statistics Application",
        description = "Web/Mobile App"
    ),
    Five(
        image = Resources.Image.PORTFOLIO,
        title = "Platform for Online Courses",
        description = "Web/Mobile App"
    )
}