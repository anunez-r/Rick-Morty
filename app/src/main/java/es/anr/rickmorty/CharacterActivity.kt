package es.anr.rickmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import es.anr.rickmorty.databinding.ActivityCharacterBinding
import es.anr.rickmorty.model.Character
import es.anr.rickmorty.ui.theme.RickMortyTheme

class CharacterActivity : ComponentActivity() {

    private lateinit var binding: ActivityCharacterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        val character = Character()
        character.image = intent.getStringExtra("image")
        character.name = intent.getStringExtra("name")
        character.status = intent.getStringExtra("status")

        binding.composeView.setContent {
            CharacterItem(character)
        }
    }


}
@Preview(showBackground = true)
@Composable
fun CharacterDefaultPreview() {
    RickMortyTheme {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Picture", Modifier.size(64.dp, 64.dp)
            )
            Column {
                Text(text = "Character Name")
                Text(text = "Character Status")
            }

        }
    }
}

@Composable
fun CharacterItem(data: Character) {
    RickMortyTheme {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = rememberAsyncImagePainter(data.image),
                contentDescription = "Picture",
                Modifier.size(128.dp, 128.dp)
            )
            Column {
                Text(text = data.name!!)
                Text(text = data.status!!)
            }

        }
    }
}