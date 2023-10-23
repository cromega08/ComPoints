package cromega.studio.compoints.ui.activities.main

import android.content.Context
import androidx.compose.runtime.MutableState

object MainStates {
    private var context: MutableState<Context>? = null

    fun initialize(context: MutableState<Context>) {
        this.context = context
    }

    fun setContext(context: Context) {this.context!!.value = context}

    fun getContext(): Context = this.context!!.value
}