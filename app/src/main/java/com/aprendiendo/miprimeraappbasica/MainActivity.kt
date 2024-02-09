package com.aprendiendo.miprimeraappbasica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.aprendiendo.miprimeraappbasica.database.AppDatabase
import com.aprendiendo.miprimeraappbasica.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(this,AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .allowMainThreadQueries().build()

        binding.addButton.setOnClickListener {
            val addPlayerActivityIntent = Intent(this, AddPlayerActivity::class.java)
            startActivity(addPlayerActivityIntent)

        }
        binding.playerRecyclerView.layoutManager =
            GridLayoutManager(this, 1, RecyclerView.VERTICAL,false)

        binding.playerRecyclerView.adapter = PlayerAdapter(
            db.playerDao().list(), this, db
        )
        setSupportActionBar(binding.actionBar)

    }

    override fun onResume() {
        super.onResume()
        val adapter = binding.playerRecyclerView.adapter as PlayerAdapter

        adapter.players = db.playerDao().list()
        adapter.notifyDataSetChanged()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_player_action_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.addPlayerOption -> {
                val addPlayerActivityIntent = Intent(this, AddPlayerActivity::class.java)
                startActivity(addPlayerActivityIntent)
                true
            }

            else -> {
                return onOptionsItemSelected(item)
            }
        }

    }

}