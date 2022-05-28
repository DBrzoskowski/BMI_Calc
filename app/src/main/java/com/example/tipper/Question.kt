package com.example.tipper

class Question internal constructor(_question: String, _answers: Array<String>, _correctAnswer: Int) {
    @JvmField
    var question = ""
    @JvmField
    var answers: Array<String>
    @JvmField
    var correctAnswer = -1

    init {
        question = _question
        answers = _answers
        correctAnswer = _correctAnswer
    }
}