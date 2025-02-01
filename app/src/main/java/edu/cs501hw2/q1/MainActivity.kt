package edu.cs501hw2.q1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.cs501hw2.q1.ui.theme.Q1Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

//Design and build a one screen app that will display a recipe. You need to display the recipe title
//,an image, the list of ingredients, and cooking instructions.
// You must use the following Composables:
//•	Card
//•	Row
//•	Column
//•	Box
//•	Divider
//•	Apply modifiers for padding, background, and alignment

const val Tittle = "Braised Pork Belly";
val Ingredients = listOf(
    Pair("Skin-on pork belly", "1 1/2 pounds"),
    Pair("Oil", "2 tablespoons"),
    Pair("Rock sugar", "2 tablespoons"),
    Pair("Shaoxing wine", "1/3 cup"),
    Pair("Soy sauce", "1/4 cup"),
    Pair("Dark soy sauce", "1/5 cup"),
)
val Instructions = listOf(
    "Cut your pork belly into 3/4-inch thick pieces. Add them to a medium pot and cover with water. Bring the water to a boil, and boil for about 1 minute, or just until the pork turns opaque. This removes impurities and starts the cooking process. Take the pork out of the pot, rinse, and set it aside. Discard the water and clean out your pot.",
    "Over low heat, add the oil and sugar to your wok or pot. Melt the sugar, and add the pork. Raise the heat to medium, and cook until the pork is lightly browned.",
    "Reduce the heat to low, and add the wine. Cook for 2 minutes, then add the soy sauce, dark soy sauce, and water.",
    "Cover and simmer over medium heat for about 45 minutes to 1 hour, until pork is fork tender. Every 5-10 minutes, stir to prevent burning and add more water if it gets too dry.",
    "Once the pork is fork tender, if there is still a lot of visible liquid, uncover the wok, turn up the heat, and stir continuously until the sauce has reduced to a glistening coating."
    )

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Q1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RecipeScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

@Composable
fun RecipeTitle(modifier: Modifier = Modifier) {
    Text(text = Tittle, style = MaterialTheme.typography.headlineMedium, modifier = modifier)

    Spacer(modifier = Modifier.height(19.dp))
}

@Composable
fun RecipeImage(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(painter = painterResource(id = R.drawable.food), contentDescription = null, modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
    }

    Spacer(modifier = Modifier.height(19.dp))
}

@Composable
fun RecipeIngredients(modifier: Modifier = Modifier) {
    Text(text = "INGREDIENTS", style = MaterialTheme.typography.headlineSmall, modifier = modifier)

    Ingredients.forEach { (name, quantity) ->
        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
            Text(text = name, modifier = Modifier.weight(1f))
            Text(text = quantity)
        }
        HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
    }

    Spacer(modifier = Modifier.height(19.dp))
}

@Composable
fun RecipeInstructions(modifier: Modifier = Modifier) {
    Text(text = "Instructions", style = MaterialTheme.typography.headlineSmall, modifier = modifier)

    Instructions.forEachIndexed { index, step ->
        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
            Text(text = "${index + 1}.", modifier = Modifier.width(24.dp))
            Text(text = step, modifier = Modifier.weight(1f))
        }
    }
}


@Composable
fun RecipeScreen(modifier: Modifier = Modifier) {
    Card(modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState())) {
        Column(modifier = Modifier.padding(19.dp)) {
            RecipeTitle()
            RecipeImage()
            RecipeIngredients()
            RecipeInstructions()
        }
    }
}
