package com.shanerudolf.cbmcodechalllenge.utils

import android.content.Context
import android.content.res.Resources
import com.google.gson.Gson
import com.shanerudolf.cbmcodechalllenge.models.TeamModel

/**
 * Created by shane1 on 2/8/18.
 */
class FileUtil {
    companion object {
        inline fun <reified T> readJSONFromAssets(context: Context, path: String) : T? {
            try {
                val jsonString = context.assets.open(path).bufferedReader().use { it.readText() }
                return Gson().fromJson(jsonString, T::class.java)
            }catch (e : Exception){
                return null
            }
        }
    }
}