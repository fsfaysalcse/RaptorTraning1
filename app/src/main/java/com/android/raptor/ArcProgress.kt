package com.android.raptor

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.raptor.ui.theme.Purple200
import com.android.raptor.ui.theme.Purple700

/**
 * Created by fsfaysalcse on 18/6/22.
 * Email : fsfoysal15@gmail.com
 */

@Composable
fun ArcProgress(
    canvasSize: Dp = 300.dp,
    indicatorValue: Int = 650,
    maxIndicatorValue: Int = 1000,
    backgroundIndicatorColor: Color = Color.Gray,
    backgroundIndicatorWidth: Float = 80f,
    foregroundIndicatorColor: Color = Purple700,
    foregroundIndicatorWidth: Float = 80f,
) {

    val percentage = (indicatorValue * 100) / maxIndicatorValue
    val sweepAngles = (240f * percentage) / 100


    Column(
        modifier = Modifier
            .background(Color.White)
            .size(canvasSize)
            .drawBehind {
                val componentSize = size / 1.25f
                backgroundIndicator(
                    componentSize,
                    backgroundIndicatorColor,
                    backgroundIndicatorWidth,
                )
                foregroundIndicator(
                    sweepAngles,
                    componentSize,
                    foregroundIndicatorColor,
                    foregroundIndicatorWidth,
                )
            }
    ) {


    }

}

fun DrawScope.backgroundIndicator(
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float
) {
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 150f,
        sweepAngle = 240f,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}

fun DrawScope.foregroundIndicator(
    sweepAngle: Float,
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float
) {
    drawArc(
        size = componentSize,
        brush = Brush.linearGradient(
            colors = listOf(Purple700, Purple200)
        ),
        startAngle = 150f,
        sweepAngle = sweepAngle,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )

}

@Preview
@Composable
fun previewArcProgress() {
    ArcProgress()
}