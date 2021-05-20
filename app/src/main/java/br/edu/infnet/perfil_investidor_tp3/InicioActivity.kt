package br.edu.infnet.perfil_investidor_tp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import kotlinx.android.synthetic.main.activity_inicio.*

class InicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

    }

    fun iniciarAnalise(view: View) {
        val nome = edtxtNome.text.toString()

        when {
            nome.isEmpty() -> {
                Toast.makeText(this, "Informe o seu nome!", Toast.LENGTH_SHORT).show()
            }
            nome.length == 1 -> {
                Toast.makeText(this, "Informe um nome válido!", Toast.LENGTH_SHORT).show()
            }
            else -> {
                user = Usuario(nome)
                val mainIntent = Intent(this, MainActivity::class.java)
                startActivity(mainIntent)
                finish()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.overflow_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val sobreIntent = Intent(this, SobreActivity::class.java)
        startActivity(sobreIntent)
        return true
    }
}