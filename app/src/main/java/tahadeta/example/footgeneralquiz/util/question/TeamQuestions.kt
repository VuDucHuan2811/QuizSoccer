package tahadeta.example.footgeneralquiz.util.question

import tahadeta.example.footgeneralquiz.data.PossibleAnswer
import tahadeta.example.footgeneralquiz.data.Question

object TeamQuestions {

    // -- 1 --

    var POSSIBLE_ANSWERS_15 = listOf(
        PossibleAnswer(0, "Parma"),
        PossibleAnswer(1, "Cagliari"),
        PossibleAnswer(2, "Bari"),
        PossibleAnswer(3, "Genoa")
    )

    var QUESTION_15 = Question(
        15,
        "Tên của đội bóng là gì?",
        3,
        POSSIBLE_ANSWERS_15
    )

    // -- 2 --
    var POSSIBLE_ANSWERS_16 = listOf(
        PossibleAnswer(0, "VfL Wolfsburg"),
        PossibleAnswer(1, "Werder Bremen"),
        PossibleAnswer(2, "FC Augsburg"),
        PossibleAnswer(3, "FC Union Berlin")
    )

    var QUESTION_16 = Question(
        16,
        "Tên của đội bóng là gì?",
        1,
        POSSIBLE_ANSWERS_16
    )

    // -- 3 ---
    var POSSIBLE_ANSWERS_17 = listOf(
        PossibleAnswer(0, "Bastia"),
        PossibleAnswer(1, "Brest"),
        PossibleAnswer(2, "Strasbourg"),
        PossibleAnswer(3, "Bordeaux")
    )

    var QUESTION_17 = Question(
        17,
        "Tên của đội bóng là gì?",
        1,
        POSSIBLE_ANSWERS_17
    )

    // -- 4 --
    var POSSIBLE_ANSWERS_18 = listOf(
        PossibleAnswer(0, "Real Zaragoza"),
        PossibleAnswer(1, "Eibar"),
        PossibleAnswer(2, "FC Cartagena"),
        PossibleAnswer(3, "Granada")
    )

    var QUESTION_18 = Question(
        18,
        "Tên của đội bóng là gì?",
        3,
        POSSIBLE_ANSWERS_18
    )

    // -- 5 --

    var POSSIBLE_ANSWERS_19 = listOf(
        PossibleAnswer(0, "Bologna"),
        PossibleAnswer(1, "Brescia"),
        PossibleAnswer(2, "Bari"),
        PossibleAnswer(3, "Benevento")
    )

    var QUESTION_19 = Question(
        19,
        "Tên của đội bóng là gì?",
        0,
        POSSIBLE_ANSWERS_19
    )

    // -- 6 --

    var POSSIBLE_ANSWERS_20 = listOf(
        PossibleAnswer(0, "Sporting Gijon"),
        PossibleAnswer(1, "FC Andorra"),
        PossibleAnswer(2, "Ponferradina"),
        PossibleAnswer(3, "FC Cartagena")
    )

    var QUESTION_20 = Question(
        20,
        "Tên của đội bóng là gì?",
        0,
        POSSIBLE_ANSWERS_20
    )

    // -- 7 --

    var POSSIBLE_ANSWERS_21 = listOf(
        PossibleAnswer(0, "FC Augsburg Fellaini"),
        PossibleAnswer(1, "Fribourg"),
        PossibleAnswer(2, "FC Köln"),
        PossibleAnswer(3, "SV Werder Bremen")
    )

    var QUESTION_21 = Question(
        21,
        "Tên của đội bóng là gì?",
        1,
        POSSIBLE_ANSWERS_21
    )

    // -- 8 --

    var POSSIBLE_ANSWERS_22 = listOf(
        PossibleAnswer(0, "Fluminense"),
        PossibleAnswer(1, "Flamengo"),
        PossibleAnswer(2, "FC Botafogo"),
        PossibleAnswer(3, "Fortaleza")
    )

    var QUESTION_22 = Question(
        22,
        "Tên của đội bóng là gì?",
        1,
        POSSIBLE_ANSWERS_22
    )

    // -- 9 --

    var POSSIBLE_ANSWERS_23 = listOf(
        PossibleAnswer(0, "Fenerbahce"),
        PossibleAnswer(1, "Adana Demirspor"),
        PossibleAnswer(2, "Fatih Karagümrük"),
        PossibleAnswer(3, "Trabzonspor")
    )

    var QUESTION_23 = Question(
        23,
        "Tên của đội bóng là gì?",
        3,
        POSSIBLE_ANSWERS_23
    )

    // -- 10 --

    var POSSIBLE_ANSWERS_24 = listOf(
        PossibleAnswer(0, "VfL Wolfsburg"),
        PossibleAnswer(1, "FC Augsburg"),
        PossibleAnswer(2, "Werder Bremen"),
        PossibleAnswer(3, "FC Union Berlin")
    )

    var QUESTION_24 = Question(
        24,
        "Tên của đội bóng là gì?",
        2,
        POSSIBLE_ANSWERS_24
    )

    /**
     * Bundle of Players
     */

    var QUESTION_BUNDLE_3_0 = listOf(
        QUESTION_15,
        QUESTION_16,
        QUESTION_17,
        QUESTION_18,
        QUESTION_19
    )

    var QUESTION_BUNDLE_3_1 = listOf(
        QUESTION_20,
        QUESTION_21,
        QUESTION_22,
        QUESTION_23,
        QUESTION_24
    )
}