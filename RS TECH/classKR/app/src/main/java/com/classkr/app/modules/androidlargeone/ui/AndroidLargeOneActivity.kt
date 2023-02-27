package com.classkr.app.modules.androidlargeone.ui

import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.classkr.app.R
import com.classkr.app.appcomponents.base.BaseActivity
import com.classkr.app.databinding.ActivityAndroidLargeOneBinding
import com.classkr.app.modules.andriodlargetwo.ui.AndriodLargeTwoActivity
import com.classkr.app.modules.androidlargeone.`data`.viewmodel.AndroidLargeOneVM
import kotlin.String
import kotlin.Unit

class AndroidLargeOneActivity :
    BaseActivity<ActivityAndroidLargeOneBinding>(R.layout.activity_android_large_one) {
  private val viewModel: AndroidLargeOneVM by viewModels<AndroidLargeOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.androidLargeOneVM = viewModel
    Handler(Looper.getMainLooper()).postDelayed( {
      val destIntent = AndriodLargeTwoActivity.getIntent(this, null)
      startActivity(destIntent)
      }, 3000)
    }

    override fun setUpClicks(): Unit {
      binding.btnGetStarted.setOnClickListener {
        val destIntent = AndriodLargeTwoActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }

    companion object {
      const val TAG: String = "ANDROID_LARGE_ONE_ACTIVITY"

    }
  }
