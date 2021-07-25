package io.github.maa96.basearch.util.extension

import com.google.gson.Gson
import com.mapbox.mapboxsdk.plugins.annotation.SymbolOptions

fun SymbolOptions.withData(data: String): SymbolOptions {
    val gson = Gson()
    val gsonData = gson.toJsonTree(data)
    return withData(gsonData)
}