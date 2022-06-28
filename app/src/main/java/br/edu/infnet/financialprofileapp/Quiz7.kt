package br.edu.infnet.financialprofileapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import br.edu.infnet.financialprofileapp.databinding.FragQ7Binding

class Quiz7 : Fragment(R.layout.frag_q7) {
    var radioGroup: RadioGroup? = null
    lateinit var radioButton: RadioButton
    private var binding: FragQ7Binding? = null
    private val sharedViewModel: MainCore by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragQ7Binding.inflate(inflater, container, false)
        this.binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            viewModel = sharedViewModel
            lifecycleOwner = viewLifecycleOwner
            q7Frag = this@Quiz7
        }

        radioGroup = view?.findViewById(R.id.radioGroup)
        var nextButton: Button = view.findViewById(R.id.button)

        radioGroup!!.setOnClickListener {
            nextButton.isEnabled = false
        }

        nextButton.setOnClickListener {
            val selectedOption: Int = radioGroup!!.checkedRadioButtonId
            if (selectedOption == -1) {
                Toast.makeText(context, "Selecione uma das opções", Toast.LENGTH_SHORT).show()
            } else {
                radioButton = view?.findViewById(selectedOption)!!
                Toast.makeText(context, radioButton.text, Toast.LENGTH_SHORT).show()

                personal_points(selectedOption)

                findNavController().navigate(R.id.action_quiz7_to_quiz8)
            }
        }
    }

    fun personal_points(selectedOption: Int) {
        when (selectedOption) {
            R.id.radioButton -> sharedViewModel.one_point_answer()
            R.id.radioButton2 -> sharedViewModel.two_point_answer()
            R.id.radioButton3 -> sharedViewModel.three_point_answer()
            R.id.radioButton4 -> sharedViewModel.four_point_answer()
        }
        sharedViewModel.count_answer()
    }
}