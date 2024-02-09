package es.anr.rickmorty.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import es.anr.rickmorty.model.Character

@Composable
fun ListItem(data: Character, modifier: Modifier = Modifier) {
    Row(modifier.fillMaxWidth()) {
        Image(
            painter = rememberAsyncImagePainter(data.image),
            contentDescription = "Picture",
            Modifier.size(64.dp, 64.dp)
        )
        Column {
            Text(text = data.name!!)
            Text(text = data.status!!)
        }
    }
}