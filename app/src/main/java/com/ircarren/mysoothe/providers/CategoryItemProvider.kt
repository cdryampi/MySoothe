package com.ircarren.mysoothe.providers

import com.ircarren.mysoothe.R
import com.ircarren.mysoothe.models.CategoryItem

class CategoryItemProvider {

    companion object{
        val categories_items = listOf(
            CategoryItem(R.drawable.paella_valenciana, "Paella"),
            CategoryItem(R.drawable.comida_espanyola_1, "Pinchos"),
            CategoryItem(R.drawable.comida_espanyola_2,"Vermut"),
            CategoryItem(R.drawable.comida_espanyola_3, "Tapas"),
            CategoryItem(R.drawable.comida_espanyola_4, "Cocido"),
            CategoryItem(R.drawable.comida_espanyola_5, "Gisquet")
        )
    }
}