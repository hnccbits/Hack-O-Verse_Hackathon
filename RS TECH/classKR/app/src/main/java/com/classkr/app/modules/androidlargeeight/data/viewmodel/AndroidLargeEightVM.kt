package com.classkr.app.modules.androidlargeeight.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.classkr.app.modules.androidlargeeight.`data`.model.AndroidLargeEightModel
import com.classkr.app.modules.androidlargeeight.`data`.model.ListnameoneRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class AndroidLargeEightVM : ViewModel(), KoinComponent {
  val androidLargeEightModel: MutableLiveData<AndroidLargeEightModel> =
      MutableLiveData(AndroidLargeEightModel())

  var navArguments: Bundle? = null

  val listnameoneList: MutableLiveData<MutableList<ListnameoneRowModel>> =
      MutableLiveData(mutableListOf())
}
