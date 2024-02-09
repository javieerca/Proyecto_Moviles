package com.aprendiendo.miprimeraappbasica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.aprendiendo.miprimeraappbasica.database.AppDatabase
import com.aprendiendo.miprimeraappbasica.database.dao.PlayerDao
import com.aprendiendo.miprimeraappbasica.database.model.Player
import com.aprendiendo.miprimeraappbasica.databinding.ActivityAddPlayerBinding

class AddPlayerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddPlayerBinding
    private lateinit var db : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "myTeam"
        ).allowMainThreadQueries().build()

        binding.saveButton.setOnClickListener {

            val player = Player(    binding.numberEditText.text.toString().toInt(), //El id será el numero del jugador
                                    binding.nameEditText.text.toString(),
                                    binding.numberEditText.text.toString().toInt(),
                                    binding.positionSpinner.selectedItem.toString()
                                )
            db.playerDao().save(player)

            Toast.makeText(this,"Vamos a añadir a "+player.name,Toast.LENGTH_SHORT).show()

            finish()
        }
        binding.cancelButton.setOnClickListener {
            finish()
        }
    }


}