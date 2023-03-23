package com.stevdza.san.styles

import com.stevdza.san.models.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderColor
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.ms

val InputStyle by ComponentStyle {
    base {
        Modifier
            .borderColor(Theme.LightGray.rgb)
            .transition(CSSTransition(property = "border", duration = 200.ms))
    }
    hover {
        Modifier.borderColor(Theme.Primary.rgb)
    }
}