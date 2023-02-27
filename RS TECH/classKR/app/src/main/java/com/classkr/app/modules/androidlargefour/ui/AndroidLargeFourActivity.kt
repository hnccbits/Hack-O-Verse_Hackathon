package com.classkr.app.modules.androidlargefour.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.classkr.app.R
import com.classkr.app.appcomponents.base.BaseActivity
import com.classkr.app.databinding.ActivityAndroidLargeFourBinding
import com.classkr.app.modules.androidlargeeight.ui.AndroidLargeEightActivity
import com.classkr.app.modules.androidlargeeleven.ui.AndroidLargeElevenActivity
import com.classkr.app.modules.androidlargefive.ui.AndroidLargeFiveActivity
import com.classkr.app.modules.androidlargefour.`data`.viewmodel.AndroidLargeFourVM
import com.classkr.app.modules.androidlargenine.ui.AndroidLargeNineActivity
import com.classkr.app.modules.androidlargeseven.ui.AndroidLargeSevenActivity
import com.classkr.app.modules.androidlargesix.ui.AndroidLargeSixActivity
import com.classkr.app.modules.androidlargeten.ui.AndroidLargeTenActivity
import kotlin.String
import kotlin.Unit

class AndroidLargeFourActivity :
    BaseActivity<ActivityAndroidLargeFourBinding>(R.layout.activity_android_large_four) {
  private val viewModel: AndroidLargeFourVM by viewModels<AndroidLargeFourVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.androidLargeFourVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtStudentRegistr.setOnClickListener {
      val destIntent = AndroidLargeFiveActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnHelp.setOnClickListener {
      val destIntent = AndroidLargeElevenActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnStudentFeedbackOne.setOnClickListener {
      val destIntent = AndroidLargeTenActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnEvaluation.setOnClickListener {
      val destIntent = AndroidLargeNineActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearColumnstaffandfacul.setOnClickListener {
      val destIntent = AndroidLargeEightActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnStudentRecordManagement.setOnClickListener {
      val destIntent = AndroidLargeSevenActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.btnClassSchedulingOne.setOnClickListener {
      val destIntent = AndroidLargeSixActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "ANDROID_LARGE_FOUR_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AndroidLargeFourActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
