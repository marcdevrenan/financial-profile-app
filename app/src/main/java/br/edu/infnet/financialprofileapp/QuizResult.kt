package br.edu.infnet.financialprofileapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizResult : AppCompatActivity() {

    private lateinit var profile: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_result)

        profile = findViewById(R.id.textView5)

        var intent = intent
        var result = intent.getStringExtra("result")

        profile.text = result.toString()
    }
}