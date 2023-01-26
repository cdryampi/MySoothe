package com.ircarren.mysoothe.providers

import com.ircarren.mysoothe.R
import com.ircarren.mysoothe.models.RegionItem

class RegionesItemProvider {
    companion object{
        var regiones = listOf<RegionItem>(
            RegionItem("Andalucía", R.drawable.andalucia),
            RegionItem("Cantabría", R.drawable.cantabria),
            RegionItem("Castilla", R.drawable.castilla),
            RegionItem("Canarias", R.drawable.canarias),
            RegionItem("Cataluña", R.drawable.catalunya),
            RegionItem("Galicia", R.drawable.gallegos),
            RegionItem("Burgos", R.drawable.burgos),
            RegionItem("Aragon", R.drawable.aragon),
            RegionItem("Mallorca", R.drawable.mallorca),
            RegionItem("Pais vasco", R.drawable.vascos),
        )

    }
}