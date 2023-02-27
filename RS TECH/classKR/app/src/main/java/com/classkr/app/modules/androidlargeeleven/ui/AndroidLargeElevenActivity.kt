package com.classkr.app.modules.androidlargeeleven.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.classkr.app.R
import com.classkr.app.appcomponents.base.BaseActivity
import com.classkr.app.databinding.ActivityAndroidLargeElevenBinding
import com.classkr.app.modules.androidlargeeleven.`data`.viewmodel.AndroidLargeElevenVM
import kotlin.String
import kotlin.Unit

class AndroidLargeElevenActivity :
    BaseActivity<ActivityAndroidLargeElevenBinding>(R.layout.activity_android_large_eleven) {
  private val viewModel: AndroidLargeElevenVM by viewModels<AndroidLargeElevenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.androidLargeElevenVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "ANDROID_LARGE_ELEVEN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AndroidLargeElevenActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
