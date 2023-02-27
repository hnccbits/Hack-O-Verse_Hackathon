package com.classkr.app.modules.androidlargenine.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.classkr.app.modules.androidlargenine.`data`.model.AndroidLargeNineModel
import org.koin.core.KoinComponent

class AndroidLargeNineVM : ViewModel(), KoinComponent {
  val androidLargeNineModel: MutableLiveData<AndroidLargeNineModel> =
      MutableLiveData(AndroidLargeNineModel())

  var navArguments: Bundle? = null
}
