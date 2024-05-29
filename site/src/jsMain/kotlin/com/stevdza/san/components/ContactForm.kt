package com.stevdza.san.components

import androidx.compose.runtime.Composable
import com.stevdza.san.models.Theme
import com.stevdza.san.styles.InputStyle
import com.stevdza.san.styles.MainButtonStyle
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

@Composable
fun ContactForm(breakpoint: Breakpoint) {
    Form(
        action = "https://formspree.io/f/xbjeydwd",
        attrs = Modifier
            .attrsModifier {
                attr("method", "POST")
            }
            .toAttrs()
    ) {
        Label(
            attrs = Modifier
                .classNames("form-label")
                .toAttrs(),
            forId = "inputName"
        ) {
            Text("Name")
        }
        Input(
            type = InputType.Text,
            attrs = InputStyle.toModifier()
                .id("inputName")
                .classNames("form-control")
                .margin(bottom = 10.px)
                .width(
                    if (breakpoint >= Breakpoint.MD) 500.px
                    else 250.px
                )
                .backgroundColor(Theme.LighterGray.rgb)
                .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                .attrsModifier {
                    attr("placeholder", "Full Name")
                    attr("name", "name")
                    attr("required", "true")
                }
                .toAttrs()
        )
        Label(
            attrs = Modifier
                .classNames("form-label")
                .toAttrs(),
            forId = "inputEmail"
        ) {
            Text("Email")
        }
        Input(
            type = InputType.Email,
            attrs = InputStyle.toModifier()
                .id("inputEmail")
                .classNames("form-control")
                .margin(bottom = 10.px)
                .width(
                    if (breakpoint >= Breakpoint.MD) 500.px
                    else 250.px
                )
                .backgroundColor(Theme.LighterGray.rgb)
                .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                .attrsModifier {
                    attr("placeholder", "Email Address")
                    attr("name", "email")
                    attr("required", "true")
                }
                .toAttrs()
        )
        Label(
            attrs = Modifier
                .classNames("form-label")
                .toAttrs(),
            forId = "inputMessage"
        ) {
            Text("Message")
        }
        TextArea (
            attrs = InputStyle.toModifier()
                .id("inputMessage")
                .classNames("form-control")
                .height(150.px)
                .margin(bottom = 20.px)
                .width(
                    if (breakpoint >= Breakpoint.MD) 500.px
                    else 250.px
                )
                .backgroundColor(Theme.LighterGray.rgb)
                .boxShadow(0.px, 0.px, 0.px, 0.px, null)
                .attrsModifier {
                    attr("placeholder", "Your Message")
                    attr("name", "message")
                    attr("required", "true")
                }
                .toAttrs()
        )
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Button(
                attrs = MainButtonStyle.toModifier()
                    .height(40.px)
                    .border(width = 0.px)
                    .borderRadius(r = 5.px)
                    .backgroundColor(Theme.Primary.rgb)
                    .color(Colors.White)
                    .cursor(Cursor.Pointer)
                    .toAttrs()
            ) {
                Text("Submit")
            }
        }
    }
}