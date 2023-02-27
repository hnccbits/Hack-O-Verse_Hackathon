package com.classkr.app.modules.androidlargenine.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.classkr.app.R
import com.classkr.app.appcomponents.base.BaseActivity
import com.classkr.app.databinding.ActivityAndroidLargeNineBinding
import com.classkr.app.modules.androidlargenine.`data`.viewmodel.AndroidLargeNineVM
import kotlin.String
import kotlin.Unit

class AndroidLargeNineActivity :
    BaseActivity<ActivityAndroidLargeNineBinding>(R.layout.activity_android_large_nine) {
  private val viewModel: AndroidLargeNineVM by viewModels<AndroidLargeNineVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.androidLargeNineVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "ANDROID_LARGE_NINE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AndroidLargeNineActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
