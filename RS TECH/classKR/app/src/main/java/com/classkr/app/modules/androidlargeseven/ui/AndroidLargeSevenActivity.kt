package com.classkr.app.modules.androidlargeseven.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.classkr.app.R
import com.classkr.app.appcomponents.base.BaseActivity
import com.classkr.app.databinding.ActivityAndroidLargeSevenBinding
import com.classkr.app.modules.androidlargeseven.`data`.viewmodel.AndroidLargeSevenVM
import kotlin.String
import kotlin.Unit

class AndroidLargeSevenActivity :
    BaseActivity<ActivityAndroidLargeSevenBinding>(R.layout.activity_android_large_seven) {
  private val viewModel: AndroidLargeSevenVM by viewModels<AndroidLargeSevenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.androidLargeSevenVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "ANDROID_LARGE_SEVEN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AndroidLargeSevenActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
