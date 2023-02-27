package com.classkr.app.modules.androidlargesix.`data`.model

import com.classkr.app.R
import com.classkr.app.appcomponents.di.MyApp
import kotlin.String

data class AndroidLargeSixModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtClassSchedulin: String? =
      MyApp.getInstance().resources.getString(R.string.msg_class_schedulin)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupNinetyFour: String? = MyApp.getInstance().resources.getString(R.string.lbl_timing)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPresentFaculti: String? =
      MyApp.getInstance().resources.getString(R.string.msg_present_faculti)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAbsentFacultie: String? =
      MyApp.getInstance().resources.getString(R.string.msg_absent_facultie)

)
