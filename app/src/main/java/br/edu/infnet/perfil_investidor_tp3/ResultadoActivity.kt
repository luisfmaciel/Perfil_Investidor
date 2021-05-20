package br.edu.infnet.perfil_investidor_tp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val nome = user?.nome

        tvCardNome.text = nome?.toUpperCase()
        tvCardPerfil.text = analisaPerfil()

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

    private fun analisaPerfil(): String {
        val pontos = pontuacao

        when {
            pontos <= 12 -> {
                return "CONSERVADOR"
            }
            pontos in 13..29 -> {
                return "MODERADO"
            }
            else -> {
                return "ARROJADO"
            }
        }
    }

    fun refazerAnalise(view: View) {
        pontuacao = 0
        user = null
        val inicioIntent = Intent(this, InicioActivity::class.java)
        startActivity(inicioIntent)
        finish()
    }
}