package ru.kirshov.exernalsigninapi

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import com.vk.api.sdk.VK
import com.vk.auth.main.VkClientUiInfo
import com.vk.superapp.SuperappKit
import com.vk.superapp.SuperappKitConfig
import com.vk.superapp.core.SuperappConfig

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        val appName = "SignIn Vk api lesson"
        val clientSecret = getString(R.string.vk_client_secret)
        val icon = AppCompatResources.getDrawable(this,R.mipmap.ic_launcher_round)!!

        val appInfo = SuperappConfig.AppInfo(
            appName,
            VK.getAppId(this).toString(),
            BuildConfig.VERSION_NAME
        )

        val config = SuperappKitConfig.Builder(this)
            .setAuthModelData(clientSecret)
            .setAuthUiManagerData(VkClientUiInfo(icon,appName))
            .setLegalInfoLinks(serviceUserAgreement = "https://id.vk.com/terms",
                servicePrivacyPolicy = "https://id.vk.com/privacy"
            ).setApplicationInfo(appInfo)
          //  .setSilentTokenExchanger(silentTokenExchanger = )
            .build()
        SuperappKit.init(config)


    }
}