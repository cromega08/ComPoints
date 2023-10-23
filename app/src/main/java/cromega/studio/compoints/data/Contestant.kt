package cromega.studio.compoints.data

import androidx.compose.runtime.MutableState

data class Contestant(
    private val number: Int,
    private var name: MutableState<String>,
    private var points: MutableState<Int>
) {
    fun getNumber(): Int = number

    fun hasName(): Boolean = name.value.isNotBlank()
    fun getName(): String = name.value
    infix fun rename(newName: String) { name.value = newName }

    fun getPoints(): Int = points.value
    infix fun increase(value: Int) { points.value += value }
    infix fun decrease(value: Int) { points.value -= value }
}
