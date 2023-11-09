package com.example.stsotre.ui.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.stsotre.R
import com.example.stsotre.data.model.home.MainCategory
import com.example.stsotre.data.model.home.Slider
import com.example.stsotre.data.remote.NetWorkResult
import com.example.stsotre.ui.theme.darkText
import com.example.stsotre.ui.theme.spacing
import com.example.stsotre.viewmodel.HomeViewModel


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategoryListSection(viewModel: HomeViewModel= hiltViewModel()){



    var categoryList by remember {
        mutableStateOf<List<MainCategory>>(emptyList())
    }


    var loading by remember {
        mutableStateOf(false)
    }

    val categoryResult by viewModel.category.collectAsState()

    when (categoryResult) {
        is NetWorkResult.Success -> {
            categoryList = categoryResult.data ?: emptyList()
            loading = false
        }

        is NetWorkResult.Error -> {
            loading = false
            Log.e("3636", "banner Section Error : ${categoryResult.message}")
        }

        is NetWorkResult.Loading -> {
            loading = true
        }
    }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(MaterialTheme.spacing.small)){

        Text(text = stringResource(id = R.string.category_title),
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.medium)
                ,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h2
                , fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText

            )


        FlowRow (
            horizontalArrangement = Arrangement.SpaceAround
            ,maxItemsInEachRow = 3,
            modifier = Modifier
                .fillMaxWidth()
                .height(290.dp)
                .padding(MaterialTheme.spacing.small)){
            for (item in categoryList){


                CircularCategoryItem(item)

            }



        }


    }

}

@Composable
fun CircularCategoryItem(item : MainCategory){
    Column (modifier = Modifier.size(100.dp, 160.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top)
    {

        Image(painter = rememberAsyncImagePainter(item.image)
            , contentDescription = "",
            modifier = Modifier
                .size(100.dp, 100.dp)
                .padding(MaterialTheme.spacing.extraSmall))

        Text(text = item.name,
            modifier = Modifier.fillMaxWidth()
                .padding(MaterialTheme.spacing.extraSmall)
            , textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis


        )
    }
}
