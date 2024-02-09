package com.aprendiendo.miprimeraappbasica

import android.content.Context
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.aprendiendo.miprimeraappbasica.database.AppDatabase
import com.aprendiendo.miprimeraappbasica.database.model.Player
import com.aprendiendo.miprimeraappbasica.databinding.PlayerLayoutBinding


class PlayerAdapter (var players: List<Player>, val context:Context, val db:AppDatabase):



    Adapter<PlayerAdapter.ItemViewHolder>(){

    private val layoutInflater = LayoutInflater.from(context)

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        return ItemViewHolder(layoutInflater.inflate(R.layout.player_layout, null))
    }

    override fun getItemCount(): Int {
        return players.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val player = players[position]
        val binding = PlayerLayoutBinding.bind(holder.itemView)

        binding.nameTextView.text = player.name
        binding.numberTextView.text = player.number.toString()
        //Código para borrar un elemento y actualizar el recyclerView

        binding.deleteimageView.setOnClickListener {

            Toast.makeText(context, "Vamos a borrar a "+player.name, Toast.LENGTH_SHORT).show()

            db.playerDao().delete(player.id)

            players = db.playerDao().list()

            notifyDataSetChanged()

        }
        binding.editimageView.setOnClickListener {
            Toast.makeText(context, "Edición no implementada", Toast.LENGTH_SHORT).show()
        }



    }


}