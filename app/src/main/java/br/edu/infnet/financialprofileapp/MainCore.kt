package br.edu.infnet.financialprofileapp

import androidx.lifecycle.ViewModel

class MainCore : ViewModel() {
    var final_score: Int = 0
    var quiz_score: Int = 0

    fun no_point_answer() {
        this.quiz_score = 0
    }

    fun one_point_answer() {
        this.quiz_score = 1
    }

    fun two_point_answer() {
        this.quiz_score = 2
    }

    fun three_point_answer() {
        this.quiz_score = 3
    }

    fun four_point_answer() {
        this.quiz_score = 4
    }

    fun count_answer() {
        this.final_score += quiz_score
    }

    fun get_result(): String {
        var result = "Conservador"
        if (final_score > 30) {
            result = "Arrojado"
        } else if (final_score > 12) {
            result = "Moderado"
        }
        return result
    }
}