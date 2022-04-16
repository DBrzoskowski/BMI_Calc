package com.example.tipper;
public class Question {
    String question = "";
    String answers[];
    int correctAnswer = -1;

    Question(String _question, String[] _answers, int _correctAnswer){
        question = _question;
        answers = _answers;
        correctAnswer = _correctAnswer;
    }
}
