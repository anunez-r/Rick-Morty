package es.anr.rickmorty.ui.navigation

sealed class Routes(val route: String) {
    object Main: Routes("Main")
    object Detail: Routes("Detail")
}