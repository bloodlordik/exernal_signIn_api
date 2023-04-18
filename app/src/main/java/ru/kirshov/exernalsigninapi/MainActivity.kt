package ru.kirshov.exernalsigninapi


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope
import com.vk.api.sdk.utils.VKUtils
import ru.kirshov.exernalsigninapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val authLauncher = VK.login(this){result->
        when(result){
            is VKAuthenticationResult.Failed -> {
                binding.textView.text = "Fall"
            }
            is VKAuthenticationResult.Success -> {
                binding.textView.text = result.token.accessToken
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonSignIn.setOnClickListener {
            authLauncher.launch(listOf(VKScope.PHOTOS, VKScope.WALL))
        }
        val packName = packageName
        val finger = VKUtils.getCertificateFingerprint(this,packName)

        Log.d("fig", "pacname: $packName ")
        finger?.forEach {
            Log.d("figure", "print: $it ")
        }
    }




}