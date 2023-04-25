package com.movan.movandialog.compose.dialogs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.ehsanmsz.mszprogressindicator.progressindicator.BallBeatProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.BallClipRotateMultipleProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.BallClipRotateProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.BallClipRotatePulseProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.BallGridBeatProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.BallGridPulseProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.BallPulseProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.BallPulseRiseProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.BallPulseSyncProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.BallRotateProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.BallScaleMultipleProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.BallScaleProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.BallScaleRippleMultipleProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.BallScaleRippleProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.BallSpinFadeLoaderProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.BallTrianglePathProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.BallZigZagDeflectProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.BallZigZagProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.CubeTransitionProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.LineScalePartyProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.LineScaleProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.LineScalePulseOutProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.LineScalePulseOutRapidProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.LineSpinFadeLoaderProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.PacmanProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.SemiCircleSpinProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.SquareSpinProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.TriangleSkewSpinProgressIndicator
import com.movan.movandialog.compose.model.ProgressIndicatorType


@Composable
fun WaitDialog(
    text:MutableState<String> = mutableStateOf(""),
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    textFontSize: TextUnit = MaterialTheme.typography.bodyMedium.fontSize,
    progressIndicatorType: ProgressIndicatorType = ProgressIndicatorType.LineSpinFadeLoader,
    indicatorColor: Color = MaterialTheme.colorScheme.onSurface,
    canBackPress: Boolean = false,
    canClickOutside: Boolean = false,
    dialogOpen: MutableState<Boolean>,
) {
    if (dialogOpen.value) {

        Dialog(
            onDismissRequest = {
                dialogOpen.value = false
            },
            properties = DialogProperties(
                dismissOnBackPress = canBackPress,
                dismissOnClickOutside = canClickOutside
            )
        ){
            Surface(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .padding(16.dp),
                shape = RoundedCornerShape(size = 10.dp),
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    when(progressIndicatorType) {
                        ProgressIndicatorType.BallPulse-> BallPulseProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.BallGridPulse-> BallGridPulseProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.BallClipRotate -> BallClipRotateProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.BallClipRotatePulse -> BallClipRotatePulseProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.SquareSpin -> SquareSpinProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.BallClipRotateMultiple -> BallClipRotateMultipleProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.BallPulseRise -> BallPulseRiseProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.BallRotate -> BallRotateProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.CubeTransition -> CubeTransitionProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.BallZigZag -> BallZigZagProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.BallZigZagDeflect -> BallZigZagDeflectProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.BallTrianglePath -> BallTrianglePathProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.BallScale -> BallScaleProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.LineScale -> LineScaleProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.LineScaleParty -> LineScalePartyProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.BallScaleMultiple -> BallScaleMultipleProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.BallPulseSync -> BallPulseSyncProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.BallBeat -> BallBeatProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.LineScalePulseOut -> LineScalePulseOutProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.LineScalePulseOutRapid -> LineScalePulseOutRapidProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.BallScaleRipple -> BallScaleRippleProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.BallScaleRippleMultiple -> BallScaleRippleMultipleProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.BallSpinFadeLoader -> BallSpinFadeLoaderProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.LineSpinFadeLoader -> LineSpinFadeLoaderProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.TriangleSkewSpin -> TriangleSkewSpinProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.Pacman -> PacmanProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.BallGridBeat -> BallGridBeatProgressIndicator(color = indicatorColor)
                        ProgressIndicatorType.SemiCircleSpin -> SemiCircleSpinProgressIndicator(color = indicatorColor)
                    }
                    if (text.value.isNotEmpty()) {
                        Text(
                            text = text.value,
                            modifier = Modifier.padding(top = 16.dp),
                            color = textColor,
                            fontSize = textFontSize
                        )
                    }
                }
            }
        }


    }
}