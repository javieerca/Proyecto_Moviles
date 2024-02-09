package com.aprendiendo.miprimeraappbasica.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player")
data class Player(
    @PrimaryKey val id: Int,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("number")val number: Int,
    @ColumnInfo("position")val position: String
)

