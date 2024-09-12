package com.guri.guriremoteconfig

import androidx.lifecycle.ViewModel
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.gson.Gson

class RemoteConfigViewModel(
) : ViewModel() {

    val remoteConfigImpl: RemoteConfigImpl = RemoteConfigImpl(Gson())

    fun getOneValue(): String = remoteConfigImpl.getOneValue()

    fun getOneValueV2(): String = FirebaseRemoteConfig.getInstance().getString("one")
}