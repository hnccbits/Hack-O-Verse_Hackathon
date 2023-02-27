package com.classkr.app.modules.androidlargesix.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.classkr.app.R
import com.classkr.app.appcomponents.base.BaseActivity
import com.classkr.app.databinding.ActivityAndroidLargeSixBinding
import com.classkr.app.modules.androidlargesix.`data`.model.ListrectangleseventysixRowModel
import com.classkr.app.modules.androidlargesix.`data`.viewmodel.AndroidLargeSixVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class AndroidLargeSixActivity :
    BaseActivity<ActivityAndroidLargeSixBinding>(R.layout.activity_android_large_six) {
  private val viewModel: AndroidLargeSixVM by viewModels<AndroidLargeSixVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listrectangleseventysixAdapter =
    ListrectangleseventysixAdapter(viewModel.listrectangleseventysixList.value?:mutableListOf())
    binding.recyclerListrectangleseventysix.adapter = listrectangleseventysixAdapter
    listrectangleseventysixAdapter.setOnItemClickListener(
    object : ListrectangleseventysixAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item :
      ListrectangleseventysixRowModel) {
        onClickRecyclerListrectangleseventysix(view, position, item)
      }
    }
    )
    viewModel.listrectangleseventysixList.observe(this) {
      listrectangleseventysixAdapter.updateData(it)
    }
    binding.androidLargeSixVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerListrectangleseventysix(
    view: View,
    position: Int,
    item: ListrectangleseventysixRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "ANDROID_LARGE_SIX_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AndroidLargeSixActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
