package com.nohjunh.version1.view.preview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.nohjunh.version1.databinding.ActivityPreviewBinding
import com.nohjunh.version1.view.preview.login.LoginActivity
import com.nohjunh.version1.view.preview.signup.SignUpActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber


// Splash 포함
class PreviewActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPreviewBinding
    private lateinit var dialog : LoadingDialog

    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()

        super.onCreate(savedInstanceState)
        binding = ActivityPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.tag("PreviewActivity").e("onCreate")

        dialog = LoadingDialog(this)

        binding.loginBtn.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                dialog.show()
                delay(300)
                val intent = Intent(this@PreviewActivity, LoginActivity::class.java)
                startActivity(intent)
                dialog.dismiss()
            }
        }

        binding.signUpBtn.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                dialog.show()
                delay(300)
                val intent = Intent(this@PreviewActivity, SignUpActivity::class.java)
                startActivity(intent)
                dialog.dismiss()
            }
        }

    }
}