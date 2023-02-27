package com.classkr.app.modules.andriodlargetwo.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.classkr.app.modules.andriodlargetwo.`data`.model.AndriodLargeTwoModel
import org.koin.core.KoinComponent

class AndriodLargeTwoVM : ViewModel(), KoinComponent {
  val andriodLargeTwoModel: MutableLiveData<AndriodLargeTwoModel> =
      MutableLiveData(AndriodLargeTwoModel())

  var navArguments: Bundle? = null
}
