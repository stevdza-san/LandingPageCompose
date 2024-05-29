package com.stevdza.san.components

import androidx.compose.runtime.Composable
import com.stevdza.san.models.Achievement
import com.stevdza.san.models.Theme
import com.stevdza.san.util.Constants.FONT_FAMILY
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AchievementCard(
    modifier: Modifier = Modifier,
    animatedNumber: Int,
    achievement: Achievement
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(70.px)
                .margin(right = 20.px),
            src = achievement.icon,
            alt = "Achievement Icon"
        )
        Column {
            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(30.px)
                    .fontWeight(FontWeight.Bolder)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text(
                    if (achievement == Achievement.Completed)
                        "${animatedNumber}+" else "$animatedNumber"
                )
            }
            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(16.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)
                    .opacity(50.percent)
                    .toAttrs()
            ) {
                Text(achievement.description)
            }
        }
    }
}