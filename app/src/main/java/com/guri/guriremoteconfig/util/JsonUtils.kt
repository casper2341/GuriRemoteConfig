package com.guri.guriremoteconfig.util

import com.google.gson.Gson

fun <T> Gson.jsonToObjectOrNull(json: String?, clazz: Class<T>): T? =
    try {
        fromJson(json, clazz)
    } catch (ignored: Exception) {
        null
    }
