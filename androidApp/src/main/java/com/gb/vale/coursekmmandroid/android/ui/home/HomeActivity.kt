package com.gb.vale.coursekmmandroid.android.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gb.vale.coursekmmandroid.android.MyApplicationTheme
import com.gb.vale.coursekmmandroid.android.component.CircleAvatar
import com.gb.vale.coursekmmandroid.entity.RecipeModel

class HomeActivity : ComponentActivity() {

    var viewModel : HomeViewModel? = null
    companion object{
        fun newInstance(context: Context) = context.startActivity(Intent(context,HomeActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = HomeViewModel(this)
        setContent {
            MyApplicationTheme {
                Box(  modifier  = Modifier.fillMaxSize().background(Color.White)){
                    Column(modifier = Modifier.padding(top = 20.dp, end = 20.dp,
                        start = 20.dp)) {
                        if (viewModel?.uiStateListRecipes?.isNotEmpty() ==true){
                            Column(modifier = Modifier.fillMaxSize()) {
                                Text(text = "Listado de recetas")
                                LazyColumn(modifier = Modifier.fillMaxSize()){
                                    items(viewModel?.uiStateListRecipes?:ArrayList()){recipe ->
                                        RecipesItem(recipe)
                                    }
                                }
                            }
                        }
                    }
                }


                if (viewModel?.uiStateLoading == true){
                    Column( modifier  = Modifier.fillMaxSize().background(Color.White),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .background(Color.Transparent)
                                .wrapContentSize(), color = Color.Magenta
                        )

                    }
                }
            }
        }
        viewModel?.loadRecipes()
    }
}

@Composable
fun RecipesItem(model: RecipeModel){

    Card(shape = RoundedCornerShape(20.dp), elevation = 10.dp,
        backgroundColor = MaterialTheme.colors.surface, modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .clickable {
                //accion del item click
            }
            .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically) {
            CircleAvatar(image = model.urlImg)
            Spacer(modifier = Modifier.padding(12.dp))
            Column {
                Text(text = model.title, maxLines = 1,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold
                )
                Text(text = model.description, maxLines = 5,
                    style = MaterialTheme.typography.body2)
            }
        }
    }
}




