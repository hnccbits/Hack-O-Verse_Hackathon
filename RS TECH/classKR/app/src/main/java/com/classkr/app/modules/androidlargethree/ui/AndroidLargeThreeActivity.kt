package com.classkr.app.modules.androidlargethree.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.classkr.app.R
import com.classkr.app.appcomponents.base.BaseActivity
import com.classkr.app.databinding.ActivityAndroidLargeThreeBinding
import com.classkr.app.modules.androidlargefour.ui.AndroidLargeFourActivity
import com.classkr.app.modules.androidlargesix.ui.AndroidLargeSixActivity
import com.classkr.app.modules.androidlargethree.`data`.viewmodel.AndroidLargeThreeVM
import kotlin.String
import kotlin.Unit

class AndroidLargeThreeActivity :
    BaseActivity<ActivityAndroidLargeThreeBinding>(R.layout.activity_android_large_three) {
  private val viewModel: AndroidLargeThreeVM by viewModels<AndroidLargeThreeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.androidLargeThreeVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtGroupFiftyOne.setOnClickListener {
      val destIntent = AndroidLargeSixActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnViewProfile.setOnClickListener {
      val destIntent = AndroidLargeFourActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "ANDROID_LARGE_THREE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AndroidLargeThreeActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
