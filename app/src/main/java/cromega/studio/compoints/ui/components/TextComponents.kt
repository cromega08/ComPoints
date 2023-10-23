package cromega.studio.compoints.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import cromega.studio.compoints.utils.ModifierUtils

object TextComponents {

    @Composable
    fun NormalText(text: String, maxWidth: Boolean) =
        Text(
            modifier = if (maxWidth) Modifier.fillMaxWidth() else Modifier.wrapContentSize(),
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 15.sp
        )

    @Composable
    fun TitleText(text: String) =
        Text(
            modifier = ModifierUtils.maxWidthWithSmallPadding(),
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 30.sp
        )

    @Composable
    fun BoxText(text: String) =
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            color = Color.White
        )
}