package com.stevdza.san.models

import com.stevdza.san.util.Res

enum class Portfolio(
    val image: String,
    val title: String,
    val description: String
) {
    One(
        image = Res.Image.portfolio1,
        title = "Kudoe",
        description = "Web Design"
    ),
    Two(
        image = Res.Image.portfolio2,
        title = "Landing Page for NFT",
        description = "Frontend"
    ),
    Three(
        image = Res.Image.portfolio3,
        title = "NFT Application",
        description = "Frontend/Backend"
    ),
    Four(
        image = Res.Image.portfolio4,
        title = "Game Statistics Application",
        description = "Web/Mobile App"
    ),
    Five(
        image = Res.Image.portfolio5,
        title = "Platform for Online Courses",
        description = "Web/Mobile App"
    )
}