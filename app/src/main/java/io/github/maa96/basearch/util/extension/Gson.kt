package io.github.maa96.basearch.util.extension

import com.google.gson.Gson
import com.google.gson.JsonElement

fun JsonElement.stringToInt(): Int {
    val gson = Gson()
    return gson.fromJson(this, Int::class.java)

}