package tahadeta.example.footgeneralquiz.ui.survey

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tahadeta.example.footgeneralquiz.data.PossibleAnswer
import tahadeta.example.footgeneralquiz.data.Question
import tahadeta.example.footgeneralquiz.util.QuestionDelivery.getTheRightQuestion
import tahadeta.example.footgeneralquiz.util.typeSelected
import tahadeta.example.footgeneralquiz.util.levelSelected

@Composable
fun OneChoiceQuestion(
    selectedAnswer: PossibleAnswer?,  // Câu trả lời hiện tại được chọn.
    withImage: Boolean,  // Xác định nếu câu hỏi có hình ảnh đi kèm.
    onOptionSelected: (PossibleAnswer, Question) -> Unit,  // Hàm lambda xử lý sự kiện khi người dùng chọn một tùy chọn.
    modifier: Modifier = Modifier,  // Tùy chỉnh cách bố trí của Composable.
    indexQuestion: String  // Chỉ số của câu hỏi hiện tại.
) {
    // Lấy câu hỏi dựa trên loại câu hỏi, cấp độ, và chỉ số câu hỏi.
    val question = getTheRightQuestion(typeSelected, levelSelected, indexQuestion)

    // Gọi Composable để hiển thị câu hỏi với các thông tin và chức năng cần thiết.
    SingleChoiceQuestion(
        title = question.titleQuestion.toString(),  // Tiêu đề câu hỏi.
        question = question,  // Đối tượng câu hỏi.
        withImage = withImage,  // Xác định nếu câu hỏi có hình ảnh.
        selectedAnswer = selectedAnswer,  // Câu trả lời hiện tại được chọn.
        onOptionSelected = onOptionSelected,  // Hàm lambda xử lý khi chọn tùy chọn.
        modifier = modifier  // Tùy chỉnh cách bố trí của Composable.
    )
}
