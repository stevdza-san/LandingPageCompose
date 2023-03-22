package com.stevdza.san.components

import androidx.compose.runtime.Composable
import com.stevdza.san.models.Testimonial
import com.stevdza.san.models.Theme
import com.stevdza.san.util.Constants.FONT_FAMILY
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun TestimonialCard(
    modifier: Modifier = Modifier,
    testimonial: Testimonial,
    breakpoint: Breakpoint
) {
    Row(modifier = modifier.maxWidth(500.px)) {
        Image(
            modifier = Modifier
                .margin(right = 20.px)
                .maxWidth(if (breakpoint >= Breakpoint.MD) 160.px else 80.px)
                .borderRadius(
                    topLeft = 60.px,
                    topRight = 60.px,
                    bottomLeft = 60.px,
                    bottomRight = 0.px
                ),
            src = testimonial.image,
            desc = "Avatar Image"
        )
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(bottom = 10.px)
            ) {
                Column {
                    P(
                        attrs = Modifier
                            .fillMaxWidth()
                            .margin(topBottom = 0.px)
                            .fontFamily(FONT_FAMILY)
                            .fontSize(18.px)
                            .fontWeight(FontWeight.Bold)
                            .color(Theme.Secondary.rgb)
                            .toAttrs()
                    ) {
                        Text(testimonial.fullName)
                    }
                    P(
                        attrs = Modifier
                            .fillMaxWidth()
                            .margin(topBottom = 0.px)
                            .fontFamily(FONT_FAMILY)
                            .fontSize(12.px)
                            .fontWeight(FontWeight.Normal)
                            .color(Theme.Secondary.rgb)
                            .toAttrs()
                    ) {
                        Text(testimonial.profession)
                    }
                    RatingBar(modifier = Modifier.margin(top = 5.px))
                }
            }
            P(
                attrs = Modifier
                    .fillMaxWidth()
                    .margin(topBottom = 0.px)
                    .fontFamily(FONT_FAMILY)
                    .fontSize(12.px)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
            ) {
                Text(testimonial.review)
            }
        }
    }
}