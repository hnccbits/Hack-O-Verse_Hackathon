package com.classkr.app.modules.androidlargenine.`data`.model

import com.classkr.app.R
import com.classkr.app.appcomponents.di.MyApp
import kotlin.String

data class AndroidLargeNineModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtEvaluateyour: String? = MyApp.getInstance().resources.getString(R.string.lbl_evaluate_your)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAttendance: String? = MyApp.getInstance().resources.getString(R.string.lbl_attendance)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtResult: String? = MyApp.getInstance().resources.getString(R.string.lbl_result)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTest: String? = MyApp.getInstance().resources.getString(R.string.lbl_test)

)
