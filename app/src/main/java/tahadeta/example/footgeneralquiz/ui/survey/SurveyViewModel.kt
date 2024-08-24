package tahadeta.example.footgeneralquiz.ui.survey

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import tahadeta.example.footgeneralquiz.data.PossibleAnswer
import tahadeta.example.footgeneralquiz.data.Question
import tahadeta.example.footgeneralquiz.util.typeSelected
import tahadeta.example.footgeneralquiz.util.userAnswer

class SurveyViewModel : ViewModel() {

    private val questionOrder: List<SurveyQuestion> = listOf(
        SurveyQuestion.FIRST,
        SurveyQuestion.SECOND,
        SurveyQuestion.THIRD,
        SurveyQuestion.FOURTH,
        SurveyQuestion.FIFTH
    )

    // Chỉ số câu hỏi hiện tại.
    private var questionIndex = 0

    // Các phản hồi của người dùng cho từng câu hỏi.
    private val _firstResponse = mutableStateOf<PossibleAnswer?>(null)
    val firstResponse: PossibleAnswer?
        get() = _firstResponse.value

    private val _secondResponse = mutableStateOf<PossibleAnswer?>(null)
    val secondResponse: PossibleAnswer?
        get() = _secondResponse.value

    private val _thirdResponse = mutableStateOf<PossibleAnswer?>(null)
    val thirdResponse: PossibleAnswer?
        get() = _thirdResponse.value

    private val _fourthResponse = mutableStateOf<PossibleAnswer?>(null)
    val fourthResponse: PossibleAnswer?
        get() = _fourthResponse.value

    private val _fifthResponse = mutableStateOf<PossibleAnswer?>(null)
    val fifthResponse: PossibleAnswer?
        get() = _fifthResponse.value

    // Trạng thái của màn hình khảo sát.
    private val _surveyScreenData = mutableStateOf(createSurveyScreenData())
    val surveyScreenData: SurveyScreenData?
        get() = _surveyScreenData.value

    // Xác định xem nút "Tiếp theo" có được bật không.
    private val _isNextEnabled = mutableStateOf(false)
    val isNextEnabled: Boolean
        get() = _isNextEnabled.value

    // Xác định xem câu hỏi có hình ảnh hay không dựa trên loại khảo sát.
    val isQuestionWithImage: Boolean get() = typeSelected.equals("2") || typeSelected.equals("3") ||
            typeSelected.equals("4")

    fun onBackPressed(): Boolean {
        if (questionIndex == 0) {
            return false
        }
        changeQuestion(questionIndex - 1)
        return true
    }

    fun onPreviousPressed() {
        if (questionIndex == 0) {
            throw IllegalStateException("onPreviousPressed when on question 0")
        }
        changeQuestion(questionIndex - 1)
    }

    fun onNextPressed() {
        changeQuestion(questionIndex + 1)
    }

    //Thay đổi câu hỏi hiện tại và cập nhật trạng thái.
    private fun changeQuestion(newQuestionIndex: Int) {//Chỉ số câu hỏi mới.
        questionIndex = newQuestionIndex
        _isNextEnabled.value = getIsNextEnabled()
        _surveyScreenData.value = createSurveyScreenData()
    }

    //Xử lý khi người dùng chọn một câu trả lời cho câu hỏi đầu tiên.
    fun onFirstResponse(possibleAnswer: PossibleAnswer, question: Question) {
        _firstResponse.value = possibleAnswer
        _isNextEnabled.value = getIsNextEnabled()
        changeUserResponse(
            possibleAnswer.idPossibleAnswer.toString(),//Câu trả lời được chọn.
            question.idCorrectAnswer.toString()//Câu hỏi hiện tại.
        )
    }

    // Các hàm xử lý tương tự cho câu trả lời thứ hai đến thứ năm.
    fun onSecondResponse(possibleAnswer: PossibleAnswer, question: Question) {
        _secondResponse.value = possibleAnswer
        _isNextEnabled.value = getIsNextEnabled()
        changeUserResponse(
            possibleAnswer.idPossibleAnswer.toString(),
            question.idCorrectAnswer.toString()
        )
    }

    fun onThirdResponse(possibleAnswer: PossibleAnswer, question: Question) {
        _thirdResponse.value = possibleAnswer
        _isNextEnabled.value = getIsNextEnabled()
        changeUserResponse(
            possibleAnswer.idPossibleAnswer.toString(),
            question.idCorrectAnswer.toString()
        )
    }

    fun onFourthResponse(possibleAnswer: PossibleAnswer, question: Question) {
        _fourthResponse.value = possibleAnswer
        _isNextEnabled.value = getIsNextEnabled()
        changeUserResponse(
            possibleAnswer.idPossibleAnswer.toString(),
            question.idCorrectAnswer.toString()
        )
    }

    fun onFifthResponse(possibleAnswer: PossibleAnswer, question: Question) {
        _fifthResponse.value = possibleAnswer
        _isNextEnabled.value = getIsNextEnabled()
        changeUserResponse(
            possibleAnswer.idPossibleAnswer.toString(),
            question.idCorrectAnswer.toString()
        )
    }

    fun changeUserResponse(idPossibleAnswer: String, idCorrectAnswer: String) {
        userAnswer[surveyScreenData!!.questionIndex].selectedAnswer = idPossibleAnswer
        userAnswer[surveyScreenData!!.questionIndex].correctAnswer = idCorrectAnswer
    }


    private fun getIsNextEnabled(): Boolean {
        return when (questionOrder[questionIndex]) {
            SurveyQuestion.FIRST -> _firstResponse.value != null
            SurveyQuestion.SECOND -> _secondResponse.value != null
            SurveyQuestion.THIRD -> _thirdResponse.value != null
            SurveyQuestion.FOURTH -> _fourthResponse.value != null
            SurveyQuestion.FIFTH -> _fifthResponse.value != null
        }
    }

    private fun createSurveyScreenData(): SurveyScreenData {
        return SurveyScreenData(
            questionIndex = questionIndex,
            questionCount = questionOrder.size,
            shouldShowPreviousButton = questionIndex > 0,
            shouldShowDoneButton = questionIndex == questionOrder.size - 1,
            surveyQuestion = questionOrder[questionIndex]
        )
    }
}

enum class SurveyQuestion {
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    FIFTH,
}

data class SurveyScreenData(
    val questionIndex: Int,//Chỉ số câu hỏi hiện tại.
    val questionCount: Int,//Tổng số câu hỏi.
    val shouldShowPreviousButton: Boolean,//Xác định xem nút "Trước đó" có nên hiển thị không.
    val shouldShowDoneButton: Boolean,//Xác định xem nút "Hoàn thành" có nên hiển thị không.
    val surveyQuestion: SurveyQuestion//Câu hỏi hiện tại.
)
