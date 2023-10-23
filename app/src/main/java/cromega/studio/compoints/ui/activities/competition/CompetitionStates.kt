package cromega.studio.compoints.ui.activities.competition

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import cromega.studio.compoints.data.Contestant

object CompetitionStates
{
    private var context: MutableState<Context>? = null
    private var title: MutableState<String>? = null
    private var label: MutableState<String>? = null
    private var limit: MutableState<Int>? = null
    private var players: SnapshotStateList<Contestant>? = null
    private var showDialog: MutableState<Boolean>? = null
    private var amendmentPlayer: MutableState<Contestant?>? = null

    fun initializeStates(
        context: MutableState<Context>,
        title: MutableState<String>,
        label: MutableState<String>,
        limit: MutableState<Int>,
        players: SnapshotStateList<Contestant>,
        showDialog: MutableState<Boolean>,
        amendmentPlayer: MutableState<Contestant?>
    )
    {
        this.context = context
        this.title = title
        this.label = label
        this.limit = limit
        this.players = players
        this.showDialog = showDialog
        this.amendmentPlayer = amendmentPlayer
    }

    fun getContext(): Context = context!!.value

    fun getTitle(): String = title!!.value

    fun getLabel(): String = label!!.value

    fun getLimit(): Int = limit!!.value
    fun limitReached(): Boolean = players!!.size >= limit!!.value

    fun getPlayer(index: Int): Contestant = players!![index]
    fun containsPlayer(contestant: Contestant) = players!!.contains(contestant)
    fun addPlayer(contestant: Contestant): Boolean = players!!.add(contestant)
    fun removePlayer(contestant: Contestant): Boolean = players!!.remove(contestant)
    fun getNumberOfPlayers(): Int = players!!.size

    fun showDialog() = showDialog!!.value
    fun openDialog() { showDialog!!.value = true }
    fun closeDialog() { showDialog!!.value = false }

    fun existAmendmentPlayer() = amendmentPlayer!!.value != null
    fun getAmendmentPlayer() = amendmentPlayer!!.value!!
    fun setAmendmentPlayer(contestant: Contestant) { amendmentPlayer!!.value = contestant }
    fun pushAmendmentPlayer()
    {
        val toPush: Contestant = getAmendmentPlayer()
        if (toPush?.let { containsPlayer(it) }!!)
            toPush.let {
                players!!.set(
                    index = players!!.indexOf(toPush),
                    element = it
                )
            }
        else addPlayer(toPush)
        clearAmendmentPlayer()
    }
    fun clearAmendmentPlayer() { amendmentPlayer!!.value = null }
}
