package com.classkr.app.modules.androidlargefive.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.classkr.app.modules.androidlargefive.`data`.model.AndroidLargeFiveModel
import org.koin.core.KoinComponent

class AndroidLargeFiveVM : ViewModel(), KoinComponent {
  val androidLargeFiveModel: MutableLiveData<AndroidLargeFiveModel> =
      MutableLiveData(AndroidLargeFiveModel())

  var navArguments: Bundle? = null
}
