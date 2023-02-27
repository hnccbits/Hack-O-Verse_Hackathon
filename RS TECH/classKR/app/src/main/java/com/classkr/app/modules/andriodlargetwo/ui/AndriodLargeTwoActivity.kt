package com.classkr.app.modules.andriodlargetwo.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.classkr.app.R
import com.classkr.app.appcomponents.base.BaseActivity
import com.classkr.app.databinding.ActivityAndriodLargeTwoBinding
import com.classkr.app.modules.andriodlargetwo.`data`.viewmodel.AndriodLargeTwoVM
import com.classkr.app.modules.androidlargethree.ui.AndroidLargeThreeActivity
import kotlin.String
import kotlin.Unit

class AndriodLargeTwoActivity :
    BaseActivity<ActivityAndriodLargeTwoBinding>(R.layout.activity_andriod_large_two) {
  private val viewModel: AndriodLargeTwoVM by viewModels<AndriodLargeTwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.andriodLargeTwoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnLogin.setOnClickListener {
      val destIntent = AndroidLargeThreeActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "ANDRIOD_LARGE_TWO_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AndriodLargeTwoActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
