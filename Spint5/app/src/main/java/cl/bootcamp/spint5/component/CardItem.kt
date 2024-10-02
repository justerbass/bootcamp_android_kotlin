package cl.bootcamp.spint5.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShoeCardItem(
    img: Painter,
    title: String,
    quantity: Int,
    price: Int,
    cliKUp: () -> Unit,
    cliKDown: () -> Unit,
    clikDelete: () -> Unit
    ){
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
        ,
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Column {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Image(
                    painter = img,
                    contentDescription = null,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(5.dp)),

                    )

                Text(
                    text = title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "$$price",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {


                IconButton(onClick = { cliKDown() }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "add")
                }

                Text(
                    text = "cantidad: $quantity",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )

                IconButton(onClick = { cliKUp() }) {
                    Icon(imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = "add")
                }

                IconButton(onClick = { clikDelete() }) {
                    Icon(imageVector = Icons.Default.Close,
                        contentDescription = "delete")
                }
            }
        }

    }
}