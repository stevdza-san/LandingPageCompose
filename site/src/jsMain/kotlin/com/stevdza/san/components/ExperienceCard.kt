package com.stevdza.san.components

import androidx.compose.runtime.Composable
import com.stevdza.san.models.Experience
import com.stevdza.san.models.Theme
import com.stevdza.san.util.Constants.FONT_FAMILY
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ExperienceCard(
    breakpoint: Breakpoint,
    active: Boolean = false,
    experience: Experience,
    animatedMargin: CSSSizeValue<CSSUnit.px>
) {
    SimpleGrid(
        modifier = Modifier
            .fillMaxWidth()
            .maxWidth(
                if (breakpoint >= Breakpoint.MD) 60.percent
                else 90.percent
            ),
        numColumns = numColumns(base = 1, md = 2)
    ) {
        ExperienceDescription(
            active = active,
            description = experience.description
        )
        ExperienceDetails(
            breakpoint = breakpoint,
            active = active,
            experience = experience,
            animatedMargin = animatedMargin
        )
    }
}

@Composable
fun ExperienceDescription(
    active: Boolean,
    description: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .margin(topBottom = 14.px)
            .padding(all = 14.px)
            .backgroundColor(if (active) Theme.Primary.rgb else Theme.LighterGray.rgb)
    ) {
        P(
            attrs = Modifier
                .margin(topBottom = 0.px)
                .fontFamily(FONT_FAMILY)
                .fontSize(14.px)
                .lineHeight(1.6)
                .fontWeight(FontWeight.Normal)
                .color(if (active) Colors.White else Theme.Secondary.rgb)
                .toAttrs()
        ) {
            Text(description)
        }
    }
}

@Composable
fun ExperienceDetails(
    breakpoint: Breakpoint,
    active: Boolean,
    experience: Experience,
    animatedMargin: CSSSizeValue<CSSUnit.px>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .margin(left = if (breakpoint >= Breakpoint.MD) 14.px else 0.px),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint >= Breakpoint.MD) {
            ExperienceNumber(active = active, experience = experience)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .margin(left = if(breakpoint <= Breakpoint.SM) 0.px else animatedMargin)
                .transition(
                    CSSTransition(
                        property = "margin",
                        duration = 500.ms,
                        delay = experience.ordinal * 100.ms
                    )
                )
            ,
            verticalArrangement = Arrangement.Center
        ) {
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text(experience.jobPosition)
            }
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text("${experience.from} - ${experience.to}")
            }
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text(experience.company)
            }
        }
    }
}

@Composable
fun ExperienceNumber(
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
                .backgroundColor(if (active) Theme.Primary.rgb else Colors.White)
                .borderRadius(50.percent),
            contentAlignment = Alignment.Center
        ) {
            P(
                attrs = Modifier
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(16.px)
                    .fontWeight(FontWeight.Bold)
                    .color(if (active) Colors.White else Theme.Primary.rgb)
                    .toAttrs()
            ) {
                Text(experience.number)
            }
        }
    }
}