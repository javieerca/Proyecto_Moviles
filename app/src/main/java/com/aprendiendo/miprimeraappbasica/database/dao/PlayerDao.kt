package com.aprendiendo.miprimeraappbasica.database.dao

import androidx.room.Dao

import androidx.room.Insert
import androidx.room.Query
import com.aprendiendo.miprimeraappbasica.database.model.Player

@Dao
interface PlayerDao {

    @Query("SELECT * FROM player")
    fun list(): List<Player>

    @Query("SELECT * FROM player where number = :number")
    fun listNumberPlayer(number: Int): List<Player>

    @Query("DELETE FROM player WHERE id = :id")
    fun delete(id: Int)

    @Insert
    fun save(player: Player)

}