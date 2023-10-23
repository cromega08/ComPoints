package cromega.studio.compoints.extensions

import android.content.Intent

fun Intent.bindStringAndIntMaps(strings: Map<String, String>, integers: Map<String, Int>) {
    this bindStringMap strings
    this bindIntegerMap integers
}

infix fun Intent.bindStringMap(map: Map<String, String>) =
    map.forEach { (key, value) -> this.putExtra(key, value) }

infix fun Intent.bindIntegerMap(map: Map<String, Int>) =
    map.forEach { (key, value) -> this.putExtra(key, value) }