package io.github.maa96.basearch.util

import com.mohsen.architecture.BuildConfig
import javax.inject.Inject

/**
 * Helper class to save and get secret data using NDK
 */
class SecretFields @Inject constructor() {

    private val debugBaseUrl = "https://60f3fb1c3cb0870017a8a0c5.mockapi.io/api/"

    private val releaseBaseUrl = "https://60f3fb1c3cb0870017a8a0c5.mockapi.io/api/"

    val apiKey: String = "c3fbf66f-8aa2-455b-8c1c-fb930aed1378"

    fun getBaseUrl(): String {
        return if (BuildConfig.DEBUG) {
            debugBaseUrl
        } else {
            releaseBaseUrl
        }
    }
}