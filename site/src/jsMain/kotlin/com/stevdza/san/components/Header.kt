package com.stevdza.san.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.stevdza.san.models.Section
import com.stevdza.san.models.Theme
import com.stevdza.san.styles.LogoStyle
import com.stevdza.san.styles.NavigationItemStyle
import com.stevdza.san.util.Constants.FONT_FAMILY
import com.stevdza.san.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaBars
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun Header() {
    val breakpoint by rememberBreakpoint()
    Row(
        modifier = Modifier
            .fillMaxWidth(if(breakpoint > Breakpoint.MD) 80.percent else 90.percent)
            .margin(topBottom = 50.px),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LeftSide(breakpoint = breakpoint)
        if (breakpoint > Breakpoint.MD) {
            RightSide()
        }
    }
}

@Composable
fun LeftSide(breakpoint: Breakpoint) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        if (breakpoint <= Breakpoint.MD) {
            FaBars(
                modifier = Modifier.margin(right = 15.px),
                size = IconSize.XL
            )
        }
        Image(
            modifier = LogoStyle.toModifier(),
            src = Res.Image.logo,
            desc = "Logo Image"
        )
    }
}

@Composable
fun RightSide() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .borderRadius(r = 50.px)
            .backgroundColor(Theme.LighterGray.rgb)
            .padding(all = 20.px),
        horizontalArrangement = Arrangement.End
    ) {
        Section.values().take(6).forEach { section ->
            Link(
                modifier = NavigationItemStyle.toModifier()
                    .padding(right = 30.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Normal)
                    .textDecorationLine(TextDecorationLine.None),
                path = section.path,
                text = section.title
            )
        }
    }
}