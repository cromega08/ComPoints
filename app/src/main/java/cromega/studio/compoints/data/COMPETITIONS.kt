package cromega.studio.compoints.data

enum class COMPETITIONS(val title: String, val limit: Int, val label: String) {
    PLAYERS(title = "Players Competition", limit = 8, label = "Player"),
    TEAMS(title = "Teams Competition", limit = 2, label = "Team")
}