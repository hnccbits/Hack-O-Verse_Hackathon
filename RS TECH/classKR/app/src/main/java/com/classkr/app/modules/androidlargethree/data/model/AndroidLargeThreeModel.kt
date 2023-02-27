package com.classkr.app.modules.androidlargethree.`data`.model

import com.classkr.app.R
import com.classkr.app.appcomponents.di.MyApp
import kotlin.String

data class AndroidLargeThreeModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtRohitKhanna: String? = MyApp.getInstance().resources.getString(R.string.lbl_rohit_khanna)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupFiftyOne: String? =
      MyApp.getInstance().resources.getString(R.string.msg_check_class_sch)

)
