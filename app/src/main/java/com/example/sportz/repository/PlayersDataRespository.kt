package com.example.sportz.repository


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.sportz.database.PlayerData
import com.example.sportz.database.SportsDatabase
import com.example.sportz.database.asDomainModel
import com.example.sportz.domain.EachPlayer
import com.example.sportz.domain.SportsModel
import com.example.sportz.domain.TeamModel
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
                database.sportsdatabaseDao.deleteAll()
                database.sportsdatabaseDao.insertAll(
                    *settingValues(networkResults)
                )

            } catch (e: Exception) {
                Log.v("PlayersDataRespository", "Failed to refresh")
            }

        }

    }


    fun settingValues(networkResults: SportsModel): Array<PlayerData> {
        val playersList = ArrayList<PlayerData>()
        for ((key, value) in networkResults.teams) {
            val teamModel: TeamModel = value
            val teamName = value.fullName
            for ((key, value) in teamModel.players) {
                val player: EachPlayer = value
                playersList.add(
                    PlayerData(
                        key,
                        teamName,
                        player.isKeeper,
                        player.fullName,
                        player.position,
                        player.isCaptain
                    )
                )

            }


        }
        return playersList.toTypedArray()

    }


}