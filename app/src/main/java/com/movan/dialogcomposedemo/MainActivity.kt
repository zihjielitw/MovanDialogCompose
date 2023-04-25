package com.movan.dialogcomposedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.movan.dialogcomposedemo.ui.theme.MovandialogcomposeTheme
import com.movan.movandialog.compose.dialogs.MessageDialog
import com.movan.movandialog.compose.dialogs.TipDialog
import com.movan.movandialog.compose.dialogs.WaitDialog
import com.movan.movandialog.compose.model.TipDialogType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovandialogcomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Greeting()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    // val dialogText = remember { mutableStateOf("讀取中，請稍候...") }
    val okText = remember { mutableStateOf("確定") }
    val cancelText = remember { mutableStateOf("取消") }
    val titleText = remember { mutableStateOf("Title") }
    val messageText = remember { mutableStateOf("message") }
    val dialogType = remember { mutableStateOf(TipDialogType.Success) }


    val openDialogToWaitDialog = remember { mutableStateOf(false) }
    val openDialogToTipDialog = remember { mutableStateOf(false) }
    val openDialogToMessageDialog = remember { mutableStateOf(false) }

    WaitDialog(text = messageText, dialogOpen = openDialogToWaitDialog, canClickOutside = true, canBackPress = true)
    TipDialog(text = messageText, dialogType= dialogType, dialogOpen = openDialogToTipDialog)
    MessageDialog(title = titleText, message = messageText, okText = okText, cancelText = cancelText,  dialogOpen = openDialogToMessageDialog)


    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text("對話框")
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(onClick = {
            titleText.value = "標題"
            messageText.value = "訊息內容"
            openDialogToMessageDialog.value = true
        }) {
            Text("訊息對話框")
        }

    }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Text("提示")
    }


    FlowRow(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Button(onClick = {
            messageText.value = ""
            openDialogToWaitDialog.value = true
        }) {
            Text("等待對話框")
        }

        Button(onClick = {
            messageText.value = "讀取中，請稍候..."
            openDialogToWaitDialog.value = true
        },
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text("等待 + 提示對話框")
        }

        Button(onClick = {
            dialogType.value = TipDialogType.Success
            messageText.value = "完成"
            openDialogToTipDialog.value = true
        },
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text("完成")
        }

        Button(onClick = {
            dialogType.value = TipDialogType.Warning
            messageText.value = "警告"
            openDialogToTipDialog.value = true
        },
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text("警告")
        }

        Button(onClick = {
            dialogType.value = TipDialogType.Error
            messageText.value = "錯誤"
            openDialogToTipDialog.value = true
        },
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Text("錯誤")
        }
    }



}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovandialogcomposeTheme {
        Greeting()
    }
}