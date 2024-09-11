package cl.bootcamp.spint5.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun TitleNameList(title: String){
    Text(text = title,
        fontSize = 30.sp,
        fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
        )
}