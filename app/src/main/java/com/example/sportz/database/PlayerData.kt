package com.example.sportz.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.sportz.domain.EachPlayer


@Entity(tableName = "players_info")
data class PlayerData(

    @PrimaryKey
    @ColumnInfo(name = "player_id")
    val playerId: String,
    @ColumnInfo(name = "team_name")
    val teamName: String,
    @ColumnInfo(name = "is_keeper")
    var isKeeper: Boolean,
    @ColumnInfo(name = "full_name")
    var fullName: String,
    @ColumnInfo(name = "position")
    var position: String,
    @ColumnInfo(name = "is_captain")
    var isCaptain: Boolean
)


fun List<PlayerData>.asDomainModel(): List<EachPlayer> {
    return map {

        EachPlayer(

            teamName = it.teamName,
            isKeeper = it.isKeeper,
            fullName = it.fullName,
            position = it.position,
            isCaptain = it.isCaptain
        )

    }


}
