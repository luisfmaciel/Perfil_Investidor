package br.edu.infnet.perfil_investidor_tp3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_questao_nove.*

class QuestaoNoveFragment : Fragment() {

    lateinit var radioButton: RadioButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_questao_nove, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnProximaQuestaoNove.setOnClickListener {
            val pontos: Int = onRadioButtonClicked()
            pontuacao += pontos
            Toast.makeText(requireContext(),
                    "Você selecionou a alternativa: ${radioButton.text}",
                    Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.next_action, null)
            requireActivity().finish()
        }
    }

    private fun onRadioButtonClicked() : Int {
        var pontos = 0
        radioButton = rgQuestaoNove.findViewById(rgQuestaoNove.checkedRadioButtonId)

        when (radioButton) {
            rbQ9A -> pontos += 0
            rbQ9B -> pontos += 1
            rbQ9C -> pontos += 2
            rbQ9D -> pontos += 4
            rbQ9E -> pontos += 5
        }
        return pontos
    }
}