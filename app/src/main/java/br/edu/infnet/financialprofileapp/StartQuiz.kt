package br.edu.infnet.financialprofileapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.edu.infnet.financialprofileapp.databinding.ActivityStartQuizBinding

class StartQuiz : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityStartQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStartQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button2) {
            startActivity(
                Intent(this, MainActivity::class.java)
            )
        }
    }
}