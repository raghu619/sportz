package com.example.sportz.database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface SportDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg playerDats: PlayerData)


    @Query("SELECT * FROM players_info")
    fun getPlayersInfo(): LiveData<List<PlayerData>>


}
