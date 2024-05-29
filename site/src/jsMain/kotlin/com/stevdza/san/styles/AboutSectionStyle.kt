package com.stevdza.san.styles

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.TransitionProperty
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.rotate
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.CssStyle
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

@OptIn(ExperimentalComposeWebApi::class)
val AboutImageStyle = CssStyle {
    base {
        Modifier
            .styleModifier { filter { grayscale(100.percent) } }
            .borderRadius(r = 0.px)
            .rotate(0.deg)
            .transition(CSSTransition(property = TransitionProperty.All, duration = 200.ms))
    }
    hover {
        Modifier
            .styleModifier { filter { grayscale(0.percent) } }
            .borderRadius(r = 100.px)
            .rotate(10.deg)
    }
}

val AboutTextStyle = CssStyle {
    base {
        Modifier
            .opacity(50.percent)
            .transition(CSSTransition(property = "opacity", duration = 200.ms))
    }
    hover {
        Modifier.opacity(100.percent)
    }
}