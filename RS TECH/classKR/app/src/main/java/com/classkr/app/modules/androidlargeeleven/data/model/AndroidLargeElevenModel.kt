package com.classkr.app.modules.androidlargeeleven.`data`.model

import com.classkr.app.R
import com.classkr.app.appcomponents.di.MyApp
import kotlin.String

data class AndroidLargeElevenModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtForFurtherDet: String? =
      MyApp.getInstance().resources.getString(R.string.msg_for_further_det)

)
