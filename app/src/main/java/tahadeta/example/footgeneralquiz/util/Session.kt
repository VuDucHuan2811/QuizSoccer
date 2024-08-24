package tahadeta.example.footgeneralquiz.util

import tahadeta.example.footgeneralquiz.data.UserAnswer

// Loại được chọn bởi người dùng (ví dụ: loại câu hỏi hoặc loại bài kiểm tra)
internal var typeSelected = ""

// Cấp độ được chọn bởi người dùng (ví dụ: cấp độ của bài kiểm tra)
internal var levelSelected = ""

// Danh sách câu trả lời của người dùng để tính điểm
internal var userAnswer = listOf(
    UserAnswer(0),
    UserAnswer(1),
    UserAnswer(2),
    UserAnswer(3),
    UserAnswer(4)
)