package com.classkr.app.modules.androidlargeten.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.classkr.app.R
import com.classkr.app.appcomponents.base.BaseActivity
import com.classkr.app.databinding.ActivityAndroidLargeTenBinding
import com.classkr.app.modules.androidlargeten.`data`.viewmodel.AndroidLargeTenVM
import kotlin.String
import kotlin.Unit

class AndroidLargeTenActivity :
    BaseActivity<ActivityAndroidLargeTenBinding>(R.layout.activity_android_large_ten) {
  private val viewModel: AndroidLargeTenVM by viewModels<AndroidLargeTenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.androidLargeTenVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "ANDROID_LARGE_TEN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AndroidLargeTenActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
