package com.example.gameselect

data class ModelList(
    var question: String,
    var picture1: Int,
    var picture2: Int,
    var optionA: String,
    var optionB: String,
    var answer: String,
    var userSelectedAnswer: String,
)
