package br.edu.infnet.perfil_investidor_tp3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_questao_um.*

class QuestaoUmFragment : Fragment() {

    lateinit var radioButton: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_questao_um, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnProximaQuestaoUm.setOnClickListener {
            val pontos: Int = onRadioButtonClicked()
            pontuacao += pontos
            Toast.makeText(requireContext(),
                    "Você selecionou a alternativa: ${radioButton.text}",
                    Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.next_action, null)
        }
    }

    private fun onRadioButtonClicked() : Int {
        var pontos = 0
        radioButton = rgQuestaoUm.findViewById(rgQuestaoUm.checkedRadioButtonId)
        when (radioButton) {
            rbQ1A -> pontos += 0
            rbQ1B -> pontos += 2
            rbQ1C -> pontos += 3
            rbQ1D -> pontos += 4
        }
        return pontos
    }

}