package com.classkr.app.modules.androidlargeeleven.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.classkr.app.modules.androidlargeeleven.`data`.model.AndroidLargeElevenModel
import org.koin.core.KoinComponent

class AndroidLargeElevenVM : ViewModel(), KoinComponent {
  val androidLargeElevenModel: MutableLiveData<AndroidLargeElevenModel> =
      MutableLiveData(AndroidLargeElevenModel())

  var navArguments: Bundle? = null
}
