package com.example.sportz.repository


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.sportz.database.PlayerData
import com.example.sportz.database.SportsDatabase
import com.example.sportz.database.asDomainModel
import com.example.sportz.domain.EachPlayer
import com.example.sportz.domain.TeamA
import com.example.sportz.domain.TeamB
import com.example.sportz.network.SportZApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class PlayersDataRespository(private val database: SportsDatabase) {


    val players: LiveData<List<EachPlayer>> =
        Transformations.map(database.sportsdatabaseDao.getPlayersInfo()) {
            it.asDomainModel()
        }


    suspend fun refreshData() {

        withContext(Dispatchers.IO) {
            try {
                val networkResults = SportZApi.retrofitService.getTeamsDetails().await()
                database.sportsdatabaseDao.insertAll(
                    *settingValues(
                        networkResults.Teams.teamA.Name_Full,
                        networkResults.Teams.teamB.Name_Full,
                        networkResults.Teams.teamA,
                        networkResults.Teams.teamB
                    )
                )

            } catch (e: Exception) {
                Log.v("PlayersDataRespository", "Failed to refresh")
            }

        }

    }


    fun settingValues(
        teamAName: String,
        teamBName: String,
        teamA: TeamA,
        teamB: TeamB
    ): Array<PlayerData> {
        val playersList = ArrayList<EachPlayer>()
        playersList.add(
            EachPlayer(
                teamAName,
                teamA.Players.playerA1.Iskeeper,
                teamA.Players.playerA1.Name_Full,
                teamA.Players.playerA1.Position,
                teamA.Players.playerA1.Iscaptain
            )
        )
        playersList.add(
            EachPlayer(
                teamAName,
                teamA.Players.playerA2.Iskeeper,
                teamA.Players.playerA2.Name_Full,
                teamA.Players.playerA2.Position,
                teamA.Players.playerA2.Iscaptain
            )
        )
        playersList.add(
            EachPlayer(
                teamAName,
                teamA.Players.playerA3.Iskeeper,
                teamA.Players.playerA3.Name_Full,
                teamA.Players.playerA3.Position,
                teamA.Players.playerA3.Iscaptain
            )
        )
        playersList.add(
            EachPlayer(
                teamAName,
                teamA.Players.playerA4.Iskeeper,
                teamA.Players.playerA4.Name_Full,
                teamA.Players.playerA4.Position,
                teamA.Players.playerA4.Iscaptain
            )
        )
        playersList.add(
            EachPlayer(
                teamAName,
                teamA.Players.playerA5.Iskeeper,
                teamA.Players.playerA5.Name_Full,
                teamA.Players.playerA5.Position,
                teamA.Players.playerA5.Iscaptain
            )
        )

        playersList.add(
            EachPlayer(
                teamAName,
                teamA.Players.playerA6.Iskeeper,
                teamA.Players.playerA6.Name_Full,
                teamA.Players.playerA6.Position,
                teamA.Players.playerA6.Iscaptain
            )
        )
        playersList.add(
            EachPlayer(
                teamAName,
                teamA.Players.playerA7.Iskeeper,
                teamA.Players.playerA7.Name_Full,
                teamA.Players.playerA7.Position,
                teamA.Players.playerA7.Iscaptain
            )
        )
        playersList.add(
            EachPlayer(
                teamAName,
                teamA.Players.playerA8.Iskeeper,
                teamA.Players.playerA8.Name_Full,
                teamA.Players.playerA8.Position,
                teamA.Players.playerA8.Iscaptain
            )
        )
        playersList.add(
            EachPlayer(
                teamAName,
                teamA.Players.playerA9.Iskeeper,
                teamA.Players.playerA9.Name_Full,
                teamA.Players.playerA9.Position,
                teamA.Players.playerA9.Iscaptain
            )
        )
        playersList.add(
            EachPlayer(
                teamAName,
                teamA.Players.playerA10.Iskeeper,
                teamA.Players.playerA10.Name_Full,
                teamA.Players.playerA10.Position,
                teamA.Players.playerA10.Iscaptain
            )
        )
        playersList.add(
            EachPlayer(
                teamAName,
                teamA.Players.playerA11.Iskeeper,
                teamA.Players.playerA11.Name_Full,
                teamA.Players.playerA11.Position,
                teamA.Players.playerA11.Iscaptain
            )
        )
        playersList.add(
            EachPlayer(
                teamBName,
                teamB.Players.playerB1.Iskeeper,
                teamB.Players.playerB1.Name_Full,
                teamB.Players.playerB1.Position,
                teamB.Players.playerB1.Iscaptain
            )
        )
        playersList.add(
            EachPlayer(
                teamBName,
                teamB.Players.playerB2.Iskeeper,
                teamB.Players.playerB2.Name_Full,
                teamB.Players.playerB2.Position,
                teamB.Players.playerB2.Iscaptain
            )
        )
        playersList.add(
            EachPlayer(
                teamBName,
                teamB.Players.playerB3.Iskeeper,
                teamB.Players.playerB3.Name_Full,
                teamB.Players.playerB3.Position,
                teamB.Players.playerB3.Iscaptain
            )
        )
        playersList.add(
            EachPlayer(
                teamBName,
                teamB.Players.playerB4.Iskeeper,
                teamB.Players.playerB4.Name_Full,
                teamB.Players.playerB4.Position,
                teamB.Players.playerB4.Iscaptain
            )
        )
        playersList.add(
            EachPlayer(
                teamBName,
                teamB.Players.playerB5.Iskeeper,
                teamB.Players.playerB5.Name_Full,
                teamB.Players.playerB5.Position,
                teamB.Players.playerB5.Iscaptain
            )
        )
        playersList.add(
            EachPlayer(
                teamBName,
                teamB.Players.playerB6.Iskeeper,
                teamB.Players.playerB6.Name_Full,
                teamB.Players.playerB6.Position,
                teamB.Players.playerB6.Iscaptain
            )
        )
        playersList.add(
            EachPlayer(
                teamBName,
                teamB.Players.playerB7.Iskeeper,
                teamB.Players.playerB7.Name_Full,
                teamB.Players.playerB7.Position,
                teamB.Players.playerB7.Iscaptain
            )
        )
        playersList.add(
            EachPlayer(
                teamBName,
                teamB.Players.playerB8.Iskeeper,
                teamB.Players.playerB8.Name_Full,
                teamB.Players.playerB8.Position,
                teamB.Players.playerB8.Iscaptain
            )
        )
        playersList.add(
            EachPlayer(
                teamBName,
                teamB.Players.playerB9.Iskeeper,
                teamB.Players.playerB9.Name_Full,
                teamB.Players.playerB9.Position,
                teamB.Players.playerB9.Iscaptain
            )
        )
        playersList.add(
            EachPlayer(
                teamBName,
                teamB.Players.playerB10.Iskeeper,
                teamB.Players.playerB10.Name_Full,
                teamB.Players.playerB10.Position,
                teamB.Players.playerB10.Iscaptain
            )
        )
        playersList.add(
            EachPlayer(
                teamBName,
                teamB.Players.playerB11.Iskeeper,
                teamB.Players.playerB11.Name_Full,
                teamB.Players.playerB11.Position,
                teamB.Players.playerB11.Iscaptain
            )
        )


        return playersList.map {
            PlayerData(
                teamName = it.teamName,
                fullName = it.fullName,
                position = it.position,
                isCaptain = it.isCaptain,
                isKeeper = it.isKeeper
            )

        }.toTypedArray()


    }


}