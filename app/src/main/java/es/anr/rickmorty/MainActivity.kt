package es.anr.rickmorty

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.anr.rickmorty.model.Character
import es.anr.rickmorty.ui.CharacterAdapter
import es.anr.rickmorty.ui.RickMortyPresenter
import es.anr.rickmorty.ui.RickMortyViewModel
import es.anr.rickmorty.ui.theme.RickMortyTheme
import es.anr.rickmorty.viewmodel.MainViewModel

class MainActivity : ComponentActivity(), RickMortyPresenter {

    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setContent {
//            RickMortyTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Greeting("Android")
//                }
//            }
//        }
        viewModel.setContext(this)
        fetchCharacters()
    }

    override fun fetchCharacters() {
        viewModel.fetchAllCharacters()
//        presenter.searchCharacter(1)
//        setContent{
//            LazyColumn(content = )
//        }
    }

    override fun showCharacters(characters: List<Character>?) {
        val list_view = findViewById<ListView>(R.id.list_view)
        if(characters != null) {
            list_view.visibility = View.VISIBLE
            list_view.adapter = CharacterAdapter(this, R.layout.row_character, characters)
        } else {
            list_view.visibility = View.GONE
        }
    }
}

private fun RickMortyViewModel.setContext(activity: Activity) {

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickMortyTheme {
        Greeting("Android")
    }
}

@Composable
fun AllCharacters(characterList:List<Character>){
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth()
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
) {}}