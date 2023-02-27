package com.classkr.app.modules.androidlargefour.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.classkr.app.modules.androidlargefour.`data`.model.AndroidLargeFourModel
import org.koin.core.KoinComponent

class AndroidLargeFourVM : ViewModel(), KoinComponent {
  val androidLargeFourModel: MutableLiveData<AndroidLargeFourModel> =
      MutableLiveData(AndroidLargeFourModel())

  var navArguments: Bundle? = null
}
