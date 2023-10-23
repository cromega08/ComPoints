package cromega.studio.compoints.utils

import android.content.Context
import android.content.Intent
import cromega.studio.compoints.data.COMPETITIONS
import cromega.studio.compoints.extensions.bindStringAndIntMaps
import cromega.studio.compoints.ui.activities.competition.CompetitionActivity
import cromega.studio.compoints.ui.activities.main.MainActivity

object MethodsUtils {
    fun <T> launchNewActivity(context: Context, toLaunch: Class<T>, strings: Map<String, String> = mapOf(), integers: Map<String, Int> = mapOf()) {
        val intent: Intent = Intent(context, toLaunch)

        intent.bindStringAndIntMaps(strings = strings, integers = integers)

        context.startActivity(intent)
    }

    fun launchContestantsActivity(context: Context, VIEW: COMPETITIONS) {

        launchNewActivity(
            context = context,
            toLaunch = CompetitionActivity::class.java,
            strings = mapOf("title" to VIEW.title, "label" to VIEW.label),
            integers = mapOf("limit" to VIEW.limit)
        )
    }

    fun launchMainActivity(context: Context) = launchNewActivity(context, MainActivity::class.java)
}