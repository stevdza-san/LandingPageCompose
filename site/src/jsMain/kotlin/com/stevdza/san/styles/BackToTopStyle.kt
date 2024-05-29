package com.stevdza.san.styles

import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.rotate
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.CssStyle
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.ms

val BackToTopButtonStyle = CssStyle {
    base {
        Modifier
            .rotate(a = 180.deg)
            .transition(CSSTransition(property = "rotate", duration = 200.ms))
    }
    hover {
        Modifier.rotate(a = 0.deg)
    }
}