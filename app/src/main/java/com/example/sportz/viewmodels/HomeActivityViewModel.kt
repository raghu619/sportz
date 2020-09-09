package com.example.sportz.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.example.sportz.database.getDatabase
import com.example.sportz.domain.EachPlayer
import com.example.sportz.repository.PlayersDataRespository
import kotlinx.coroutines.*

class HomeActivityViewModel(application: Application) :
    AndroidViewModel(application) {

    private var viewModelJob = SupervisorJob()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val database = getDatabase(application)
    private val playersDataRespository = PlayersDataRespository(database)

    init {

        coroutineScope.launch {
            playersDataRespository.refreshData()
        }

    }

    val playersList = playersDataRespository.players


    fun getTeamAPlayers(list: List<EachPlayer>): List<EachPlayer> {
        if (list.size > 0) {
            val teamKey = list.get(0).teamName
            val teamAList = list.filter { it.teamName == teamKey }
            return teamAList
        } else {
            return emptyList()
        }


    }

    fun getTeamBPlayers(list: List<EachPlayer>): List<EachPlayer> {
        if (list.size > 0) {
            val teamKey = list.get(0).teamName
            val teamBList = list.filter { it.teamName != teamKey }
            return teamBList
        } else {
            return emptyList()
        }

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()

    }


    class Factory(val app: Application) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeActivityViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return HomeActivityViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }


}