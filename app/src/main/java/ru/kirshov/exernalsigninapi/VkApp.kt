package ru.kirshov.exernalsigninapi

import android.app.Application
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKTokenExpiredHandler

class VkApp:Application() {
    private val vkHandler = object :VKTokenExpiredHandler{
        override fun onTokenExpired() {

        }

    }

    override fun onCreate() {
        super.onCreate()
        VK.addTokenExpiredHandler(vkHandler)
    }
}