package tahadeta.example.footgeneralquiz.ui.choice

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import tahadeta.example.footgeneralquiz.data.Choice
import tahadeta.example.footgeneralquiz.data.Level

/**
 * ViewModel để quản lý trạng thái của lựa chọn cấp độ và lựa chọn trong ứng dụng.
 */
class ChoiceLevelViewModel : ViewModel() {

    // Trạng thái của lựa chọn cấp độ.
    private val _levelResponse = mutableStateOf<Level?>(null)
    val levelResponse: Level?
        get() = _levelResponse.value

    // Trạng thái của lựa chọn.
    private val _choiceResponse = mutableStateOf<Choice?>(null)
    val choiceResponse: Choice?
        get() = _choiceResponse.value

    // Xác định xem nút "Bắt đầu" có được bật không.
    private val _isStartEnabled = mutableStateOf(false)
    val isStartEnabled: Boolean
        get() = _isStartEnabled.value

    // Xác định xem nút "Tiếp theo" có được bật không.
    private val _isNextEnabled = mutableStateOf(false)
    val isNextEnabled: Boolean
        get() = _isNextEnabled.value

    /**
     * Xử lý phản hồi khi người dùng chọn một cấp độ.
     * @param level Cấp độ được chọn.
     */
    fun onLevelResponse(level: Level) {
        _levelResponse.value = level
        _isStartEnabled.value = getIsStartEnabled()
    }

    /**
     * Xử lý phản hồi khi người dùng chọn một lựa chọn.
     * @param choice Lựa chọn được chọn.
     */
    fun onChoiceResponse(choice: Choice) {
        _choiceResponse.value = choice
        _isNextEnabled.value = getIsNextEnabled()
    }

    /**
     * Xác định xem nút "Bắt đầu" có nên được bật không.
     * @return true nếu nút "Bắt đầu" được bật (tức là cấp độ đã được chọn).
     */
    private fun getIsStartEnabled(): Boolean {
        return _levelResponse.value != null
    }

    /**
     * Xác định xem nút "Tiếp theo" có nên được bật không.
     * @return true nếu nút "Tiếp theo" được bật (tức là lựa chọn đã được chọn).
     */
    private fun getIsNextEnabled(): Boolean {
        return _choiceResponse.value != null
    }
}
