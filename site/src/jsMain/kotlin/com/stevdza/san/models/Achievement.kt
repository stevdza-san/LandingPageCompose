package com.stevdza.san.models

import com.stevdza.san.util.Res

enum class Achievement(
    val icon: String,
    val number: Int,
    val description: String
) {
    Completed(
        icon = Res.Icon.checkmark,
        number = 120,
        description = "Completed Projects"
    ),
    Active(
        icon = Res.Icon.shield,
        number = 12,
        description = "Active Projects"
    ),
    Satisfied(
        icon = Res.Icon.happy,
        number = 42,
        description = "Satisfied Clients"
    ),
    Team(
        icon = Res.Icon.user,
        number = 10,
        description = "Team Members"
    )
}