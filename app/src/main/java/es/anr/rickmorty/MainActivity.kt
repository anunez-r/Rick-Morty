package es.anr.rickmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.anr.rickmorty.databinding.ActivityMainBinding
import es.anr.rickmorty.model.Character
import es.anr.rickmorty.ui.ListItem
import es.anr.rickmorty.ui.RickMortyPresenter
import es.anr.rickmorty.ui.theme.RickMortyTheme
import es.anr.rickmorty.viewmodel.MainViewModel

class MainActivity : ComponentActivity(), RickMortyPresenter {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.setContext(this)
        binding.composeView.setContent {
            DefaultPreview()
//            LazyColumn(Modifier.fillMaxSize()) {
//                // We use a LazyColumn since the layout manager of the RecyclerView is a vertical LinearLayoutManager
//            }
        }
        fetchCharacters()
    }

    override fun fetchCharacters() {
        viewModel.fetchAllCharacters()
//        presenter.searchCharacter(1)
    }

    override fun showCharacters(characters: List<Character>?) {
        binding.composeView.setContent {
            LazyColumn(Modifier.fillMaxSize()) {
                items(characters!!) {
                    ListItem(it)
                }
            }
        }

//        val list_view = binding.listView
//        if (characters != null) {
//            list_view.visibility = View.VISIBLE
//            list_view.adapter = CharacterAdapter(this, R.layout.row_character, characters)
//        } else {
//            list_view.visibility = View.GONE
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickMortyTheme {
        Column {
            Row {
                Image(painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Picture", Modifier.size(64.dp, 64.dp))
                Column {
                    Text(text = "Character Name")
                    Text(text = "Character Status")
                }
            }
        }
    }
}

@Composable
fun AllCharacters(characterList: List<Character>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 25.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {}
        }
    }
}

@Composable
fun CharacterCard(name: String, status: String, image: Int) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {}
}