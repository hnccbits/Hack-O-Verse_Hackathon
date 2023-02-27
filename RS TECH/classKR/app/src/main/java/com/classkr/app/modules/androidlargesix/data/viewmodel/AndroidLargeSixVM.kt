package com.classkr.app.modules.androidlargesix.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.classkr.app.modules.androidlargesix.`data`.model.AndroidLargeSixModel
import com.classkr.app.modules.androidlargesix.`data`.model.ListrectangleseventysixRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class AndroidLargeSixVM : ViewModel(), KoinComponent {
  val androidLargeSixModel: MutableLiveData<AndroidLargeSixModel> =
      MutableLiveData(AndroidLargeSixModel())

  var navArguments: Bundle? = null

  val listrectangleseventysixList: MutableLiveData<MutableList<ListrectangleseventysixRowModel>> =
      MutableLiveData(mutableListOf())
}
