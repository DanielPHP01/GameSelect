package com.example.gameselect

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.gameselect.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var modelList: List<ModelList>
    private var currentQuestionPosition = 0
    private var selectedOptionByUser = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initQuestions()
        initViews()
    }

    @SuppressLint("SetTextI18n")
    private fun initQuestions() {
        modelList = InitList().getQuestions
        binding.questions.text = "${currentQuestionPosition + 1}/${modelList.size}"
        binding.tvQuestion.text = modelList[0].question
        binding.imgA.setImageResource(modelList[0].picture1)
        binding.imgB.setImageResource(modelList[0].picture2)
        binding.btnA.text = modelList[0].optionA
        binding.btnB.text = modelList[0].optionB
    }

    @SuppressLint("SetTextI18n")
    private fun changeNextQuestions() {
        currentQuestionPosition++
        if (currentQuestionPosition < modelList.size) {
            selectedOptionByUser = ""
            binding.btnA.background = ContextCompat.getDrawable(this, R.drawable.round_button)
            binding.btnB.background = ContextCompat.getDrawable(this, R.drawable.round_button)
            binding.tvQuestion.text = modelList[currentQuestionPosition].question
            binding.questions.text = "${currentQuestionPosition + 1}/${modelList.size}"
            binding.btnA.text = modelList[currentQuestionPosition].optionA
            binding.btnB.text = modelList[currentQuestionPosition].optionB
            binding.imgA.setImageResource(modelList[currentQuestionPosition].picture1)
            binding.imgB.setImageResource(modelList[currentQuestionPosition].picture2)
        } else {
             getVisibleResult()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getVisibleResult() {
        binding.btnA.visibility = View.GONE
        binding.btnB.visibility = View.GONE
        binding.tvQuestion.visibility = View.GONE
        binding.questions.visibility = View.GONE
        binding.imgA.visibility = View.GONE
        binding.imgB.visibility = View.GONE

        binding.tvCorrectAnswer.text = "True - ${getCorrectAnswerCount()}"
        binding.tvInCorrectAnswer.text = "False - ${getInCorrectAnswerCount()}"
        binding.resultLayout.visibility = View.VISIBLE
    }

    @Deprecated("Deprecated in Java", ReplaceWith("finish()"))
    override fun onBackPressed() {
        finish()
    }

    private fun revealAnswer() {
        when (modelList[currentQuestionPosition].answer) {
            binding.btnA.text.toString() -> {
                binding.btnA.background =
                    ContextCompat.getDrawable(this, R.drawable.round_btn_green)
            }
            binding.btnB.text.toString() -> {
                binding.btnB.background =
                    ContextCompat.getDrawable(this, R.drawable.round_btn_green)
            }
        }
    }

    private fun getCorrectAnswerCount(): Int {
        return modelList.count { it.answer == it.userSelectedAnswer }
    }

    private fun getInCorrectAnswerCount(): Int {
        return modelList.count { it.answer != it.userSelectedAnswer }
    }

    private fun initViews() {
        binding.btnA.setOnClickListener {
            if (selectedOptionByUser.isEmpty()) {
                selectedOptionByUser = binding.btnA.text.toString()
                modelList[currentQuestionPosition].userSelectedAnswer = selectedOptionByUser
                highlightButton(binding.btnA)
                revealAnswer()
                Handler().postDelayed({
                    changeNextQuestions()
                }, 400)
            }
        }
        binding.btnB.setOnClickListener {
            if (selectedOptionByUser.isEmpty()) {
                selectedOptionByUser = binding.btnB.text.toString()
                modelList[currentQuestionPosition].userSelectedAnswer = selectedOptionByUser
                highlightButton(binding.btnB)
                revealAnswer()
                Handler().postDelayed({
                    changeNextQuestions()
                }, 400)
            }
        }
    }

    private fun highlightButton(button: Button) {
        button.setBackgroundResource(R.drawable.round_btn_red)
    }
}