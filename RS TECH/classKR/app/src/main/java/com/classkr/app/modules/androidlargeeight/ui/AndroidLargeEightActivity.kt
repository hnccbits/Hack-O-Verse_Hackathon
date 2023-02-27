package com.classkr.app.modules.androidlargeeight.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.classkr.app.R
import com.classkr.app.appcomponents.base.BaseActivity
import com.classkr.app.databinding.ActivityAndroidLargeEightBinding
import com.classkr.app.modules.androidlargeeight.`data`.model.ListnameoneRowModel
import com.classkr.app.modules.androidlargeeight.`data`.viewmodel.AndroidLargeEightVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class AndroidLargeEightActivity :
    BaseActivity<ActivityAndroidLargeEightBinding>(R.layout.activity_android_large_eight) {
  private val viewModel: AndroidLargeEightVM by viewModels<AndroidLargeEightVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listnameoneAdapter =
    ListnameoneAdapter(viewModel.listnameoneList.value?:mutableListOf())
    binding.recyclerListnameone.adapter = listnameoneAdapter
    listnameoneAdapter.setOnItemClickListener(
    object : ListnameoneAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListnameoneRowModel) {
        onClickRecyclerListnameone(view, position, item)
      }
    }
    )
    viewModel.listnameoneList.observe(this) {
      listnameoneAdapter.updateData(it)
    }
    binding.androidLargeEightVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerListnameone(
    view: View,
    position: Int,
    item: ListnameoneRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "ANDROID_LARGE_EIGHT_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, AndroidLargeEightActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
