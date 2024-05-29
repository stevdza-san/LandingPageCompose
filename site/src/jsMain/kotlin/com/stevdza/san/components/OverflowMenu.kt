package com.stevdza.san.components

import androidx.compose.runtime.*
import com.stevdza.san.models.Section
import com.stevdza.san.styles.NavigationItemStyle
import com.stevdza.san.util.Constants.FONT_FAMILY
import com.stevdza.san.util.Res
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.argb
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaXmark
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.*

@Composable
fun OverflowMenu(onMenuClosed: () -> Unit) {
    val scope = rememberCoroutineScope()
    val breakpoint = rememberBreakpoint()
    var translateX by remember { mutableStateOf((-100).percent) }
    var opacity by remember { mutableStateOf(0.percent) }

    LaunchedEffect(breakpoint) {
        translateX = 0.percent
        opacity = 100.percent
        if(breakpoint > Breakpoint.MD) {
            scope.launch {
                translateX = (-100).percent
                opacity = 0.percent
                delay(500)
                onMenuClosed()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.vh)
            .position(Position.Fixed)
            .zIndex(2)
            .opacity(opacity)
            .backgroundColor(argb(a = 0.5f, r = 0.0f, g = 0.0f, b = 0.0f))
            .transition(CSSTransition(property = "opacity", duration = 500.ms))
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(all = 25.px)
                .width(if (breakpoint < Breakpoint.MD) 50.percent else 25.percent)
                .overflow(Overflow.Auto)
                .scrollBehavior(ScrollBehavior.Smooth)
                .backgroundColor(Colors.White)
                .translateX(tx = translateX)
                .transition(CSSTransition(property = "translate", duration = 500.ms))
        ) {
            Row(
                modifier = Modifier.margin(bottom = 25.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                FaXmark(
                    modifier = Modifier
                        .cursor(Cursor.Pointer)
                        .margin(right = 20.px)
                        .onClick {
                            scope.launch {
                                translateX = (-100).percent
                                opacity = 0.percent
                                delay(500)
                                onMenuClosed()
                            }
                        },
                    size = IconSize.LG
                )
                Image(
                    modifier = Modifier.size(80.px),
                    src = Res.Image.logo,
                    alt = "Logo Image"
                )
            }
            Section.entries.toTypedArray().take(6).forEach { section ->
                Link(
                    modifier = NavigationItemStyle.toModifier()
                        .margin(bottom = 10.px)
                        .fontFamily(FONT_FAMILY)
                        .fontSize(16.px)
                        .fontWeight(FontWeight.Normal)
                        .textDecorationLine(TextDecorationLine.None)
                        .onClick {
                            scope.launch {
                                translateX = (-100).percent
                                opacity = 0.percent
                                delay(500)
                                onMenuClosed()
                            }
                        },
                    path = section.path,
                    text = section.title,
                    openInternalLinksStrategy = OpenLinkStrategy.IN_PLACE
                )
            }
        }
    }
}