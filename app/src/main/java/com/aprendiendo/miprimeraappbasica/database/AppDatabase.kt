package com.aprendiendo.miprimeraappbasica.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aprendiendo.miprimeraappbasica.database.dao.PlayerDao
import com.aprendiendo.miprimeraappbasica.database.model.Player


@Database (entities = [Player::class],version= 2)
abstract class AppDatabase: RoomDatabase() {
    companion object{
        const val DATABASE_NAME = "myTeam"
    }

    abstract fun playerDao(): PlayerDao

}