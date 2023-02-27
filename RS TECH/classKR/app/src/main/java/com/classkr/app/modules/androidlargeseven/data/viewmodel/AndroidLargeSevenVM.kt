package com.classkr.app.modules.androidlargeseven.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.classkr.app.modules.androidlargeseven.`data`.model.AndroidLargeSevenModel
import org.koin.core.KoinComponent

class AndroidLargeSevenVM : ViewModel(), KoinComponent {
  val androidLargeSevenModel: MutableLiveData<AndroidLargeSevenModel> =
      MutableLiveData(AndroidLargeSevenModel())

  var navArguments: Bundle? = null
}
