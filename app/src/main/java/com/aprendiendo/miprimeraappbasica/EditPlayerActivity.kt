package com.aprendiendo.miprimeraappbasica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//Mirar el proyecto HelloWorld > UsernameActivity y DisplayUsernameActivity
class EditPlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_player)
    }
}