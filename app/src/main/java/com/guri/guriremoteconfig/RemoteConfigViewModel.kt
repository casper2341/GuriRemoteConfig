package com.guri.guriremoteconfig

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class RemoteConfigViewModel(
) : ViewModel() {

    var uiState by mutableStateOf(UIState(text = ""))
    private var events = MutableSharedFlow<UIEvent>()
    val remoteConfigImpl: RemoteConfigImpl = RemoteConfigImpl(Gson())

    init {
        handleEvent()
    }

    fun triggerEvent(intent: UIEvent) {
        viewModelScope.launch {
            events.emit(intent)
        }
    }

    private fun handleEvent() {
        viewModelScope.launch {
            events.collect {
                when (it) {
                    is UIEvent.UpdateText -> {
                        when (it.number) {
                            "1" -> {
                                uiState = uiState.copy(text = "This is from 1 key with value ${getOneValue()}")
                            }

                            "2" -> {
                                uiState = uiState.copy(text = "This is from 2 key with value ${getTwoValue()}")
                            }

                            "3" -> {
                                uiState = uiState.copy(text = "This is from 3 key with value ${getThreeValue()}")
                            }

                            "4" -> {
                                uiState = uiState.copy(text = "This is from 4 key with value ${getFourValue()}")
                            }

                            "5" -> {

                            }

                            "6" -> {

                            }

                            "7" -> {

                            }

                            "8" -> {

                            }

                            "9" -> {

                            }
                        }
                    }
                }
            }
        }
    }

    private fun getOneValue(): String = remoteConfigImpl.getOneValue()

    private fun getTwoValue(): Int = remoteConfigImpl.getTwoValue()

    private fun getThreeValue(): Boolean = remoteConfigImpl.getThreeValue()

    private fun getFourValue(): Float = remoteConfigImpl.getFourValue()

    fun getOneValueV2(): String = FirebaseRemoteConfig.getInstance().getString("one")
}

data class UIState(
    val text: String = ""
)

sealed class UIEvent {
    data class UpdateText(val number: String) : UIEvent()
}