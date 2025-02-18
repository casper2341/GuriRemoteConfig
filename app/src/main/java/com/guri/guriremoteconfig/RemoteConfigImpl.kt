package com.guri.guriremoteconfig

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.gson.Gson
import com.guri.guriremoteconfig.util.jsonToObjectOrNull
import javax.inject.Singleton

@Singleton
class RemoteConfigImpl(
    private val gson: Gson
) : RemoteConfig {

    private fun <T> read(param: ConfigParam, returnType: Class<T>): T? {
        val value: Any? = when (returnType) {
            String::class.java -> config.getString(param.key)
            Boolean::class.java -> config.getBoolean(param.key)
            Long::class.java -> config.getLong(param.key)
            Int::class.java -> config.getLong(param.key).toInt()
            Double::class.java -> config.getDouble(param.key)
            Float::class.java -> config.getDouble(param.key).toFloat()
            else -> {
                val json = config.getString(param.key)
                json.takeIf { it.isNotBlank() }?.let { gson.jsonToObjectOrNull(json, returnType) }
            }
        }
        @Suppress("UNCHECKED_CAST")
        return (value as? T)
    }

    private val config: FirebaseRemoteConfig = FirebaseRemoteConfig.getInstance().apply {
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(CONFIG_CACHE_EXPIRATION_SECONDS)
            .build()
        setConfigSettingsAsync(configSettings)
        fetch(CONFIG_CACHE_EXPIRATION_SECONDS)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    activate()
                }
            }
        setDefaultsAsync(R.xml.remote_config_defaults)
    }

    private inline fun <reified T> read(param: ConfigParam): T? = read(param, T::class.java)

    override fun getOneValue(): String {
        return read<String>(ConfigParam.ONE) ?: SOME_DEFAULT_VALUE
    }

    override fun getTwoValue(): Int {
        return read<Int>(ConfigParam.TWO) ?: 0
    }

    override fun getThreeValue(): Boolean {
        return read<Boolean>(ConfigParam.THREE) ?: true
    }

    override fun getFourValue(): Float {
       return read<Float>(ConfigParam.FOUR) ?: 0f
    }

    override fun getFiveValue(): String {
        TODO("Not yet implemented")
    }

    override fun getSixValue(): String {
        TODO("Not yet implemented")
    }

    override fun getSevenValue(): String {
        TODO("Not yet implemented")
    }

    override fun getEightValue(): String {
        TODO("Not yet implemented")
    }

    override fun getNineValue(): String {
        TODO("Not yet implemented")
    }

    private companion object {
        /**
         * Config expiration interval 30 minutes.
         */
        private const val CONFIG_CACHE_EXPIRATION_SECONDS = 900L
        private const val SOME_DEFAULT_VALUE = "Any default value"
    }
}