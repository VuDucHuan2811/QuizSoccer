package tahadeta.example.footgeneralquiz.util

import tahadeta.example.footgeneralquiz.R
import tahadeta.example.footgeneralquiz.data.Question
import tahadeta.example.footgeneralquiz.data.UserAnswer
import tahadeta.example.footgeneralquiz.util.question.FlagQuestions.QUESTION_BUNDLE_4_0
import tahadeta.example.footgeneralquiz.util.question.FlagQuestions.QUESTION_BUNDLE_4_1
import tahadeta.example.footgeneralquiz.util.question.TeamQuestions.QUESTION_BUNDLE_3_0
import tahadeta.example.footgeneralquiz.util.question.TeamQuestions.QUESTION_BUNDLE_3_1
import tahadeta.example.footgeneralquiz.util.question.PlayerQuestions.QUESTION_BUNDLE_2_0
import tahadeta.example.footgeneralquiz.util.question.PlayerQuestions.QUESTION_BUNDLE_2_1
import tahadeta.example.footgeneralquiz.util.question.UefaQuestions.QUESTION_BUNDLE_1_0
import tahadeta.example.footgeneralquiz.util.question.UefaQuestions.QUESTION_BUNDLE_1_1
import tahadeta.example.footgeneralquiz.util.question.UefaQuestions.QUESTION_BUNDLE_1_2
import tahadeta.example.footgeneralquiz.util.question.WorldCupQuestions.QUESTION_BUNDLE_0_0
import tahadeta.example.footgeneralquiz.util.question.WorldCupQuestions.QUESTION_BUNDLE_0_1
import tahadeta.example.footgeneralquiz.util.question.WorldCupQuestions.QUESTION_BUNDLE_0_2

object QuestionDelivery {

    fun getTheRightQuestion(idType: String, idLevel: String, indexQuestion: String): Question {
        when (idLevel) {
            "0" -> {
                if (idType == "0") return QUESTION_BUNDLE_0_0[indexQuestion.toInt()]
                else if (idType == "1") return QUESTION_BUNDLE_1_0[indexQuestion.toInt()]
                else if (idType == "2") return QUESTION_BUNDLE_2_0[indexQuestion.toInt()]
                else if (idType == "3") return QUESTION_BUNDLE_3_0[indexQuestion.toInt()]
                else if (idType == "4") return QUESTION_BUNDLE_4_0[indexQuestion.toInt()]
                else return QUESTION_BUNDLE_1_0[indexQuestion.toInt()]
            }
            "1" -> {
                if (idType == "0") return QUESTION_BUNDLE_0_1[indexQuestion.toInt()]
                else if (idType == "1") return QUESTION_BUNDLE_1_1[indexQuestion.toInt()]
                else if (idType == "2") return QUESTION_BUNDLE_2_1[indexQuestion.toInt()]
                else if (idType == "3") return QUESTION_BUNDLE_3_1[indexQuestion.toInt()]
                else if (idType == "4") return QUESTION_BUNDLE_4_1[indexQuestion.toInt()]
                else return QUESTION_BUNDLE_1_1[indexQuestion.toInt()]
            }
            else -> {
                if (idType == "0") return QUESTION_BUNDLE_0_2[indexQuestion.toInt()]
                else if (idType == "1") return QUESTION_BUNDLE_1_2[indexQuestion.toInt()]
                else return QUESTION_BUNDLE_1_2[indexQuestion.toInt()]
            }
        }
    }

    fun getTheResult(userAnswer: List<UserAnswer>): Int {
        var score = 0
        userAnswer.forEach {
            if (it.selectedAnswer!!.equals(it.correctAnswer)) score++
        }
        return score
    }

    fun getTheRightImage(index: Int): Int {
        when (index) {
            5 -> return R.drawable.question1
            6 -> return R.drawable.question2
            7 -> return R.drawable.question3
            8 -> return R.drawable.question4
            9 -> return R.drawable.question5
            10 -> return R.drawable.question6
            11 -> return R.drawable.question7
            12 -> return R.drawable.question8
            13 -> return R.drawable.question9
            14 -> return R.drawable.question10
            // teams
            15 -> return R.drawable.team1
            16 -> return R.drawable.team2
            17 -> return R.drawable.team3
            18 -> return R.drawable.team4
            19 -> return R.drawable.team5
            20 -> return R.drawable.team6
            21 -> return R.drawable.team7
            22 -> return R.drawable.team8
            23 -> return R.drawable.team9
            24 -> return R.drawable.team10
            // flags
            25 -> return R.drawable.flag1
            26 -> return R.drawable.flag2
            27 -> return R.drawable.flag3
            28 -> return R.drawable.flag4
            29 -> return R.drawable.flag5
            30 -> return R.drawable.flag6
            31 -> return R.drawable.flag7
            32 -> return R.drawable.flag8
            33 -> return R.drawable.flag9
            else -> return R.drawable.flag10
        }
    }

    fun getTheRightFlag(index: Int): Int {
        when (index) {
            5 -> return R.drawable.question1
            6 -> return R.drawable.question2
            7 -> return R.drawable.question3
            8 -> return R.drawable.question4
            9 -> return R.drawable.question5
            10 -> return R.drawable.question6
            11 -> return R.drawable.question7
            12 -> return R.drawable.question8
            13 -> return R.drawable.question9
            else -> return R.drawable.question6
        }
    }
}
