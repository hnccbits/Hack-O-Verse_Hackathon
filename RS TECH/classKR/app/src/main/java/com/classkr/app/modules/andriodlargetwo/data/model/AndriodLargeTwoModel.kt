package com.classkr.app.modules.andriodlargetwo.`data`.model

import com.classkr.app.R
import com.classkr.app.appcomponents.di.MyApp
import kotlin.String

data class AndriodLargeTwoModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtYouare: String? = MyApp.getInstance().resources.getString(R.string.lbl_you_are)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSelect: String? = MyApp.getInstance().resources.getString(R.string.lbl_select)

)
