package com.classkr.app.modules.androidlargefive.`data`.model

import com.classkr.app.R
import com.classkr.app.appcomponents.di.MyApp
import kotlin.String

data class AndroidLargeFiveModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtStudentRegistr: String? =
      MyApp.getInstance().resources.getString(R.string.msg_student_registr2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupSeventyOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_dd)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupSixtyFour: String? = MyApp.getInstance().resources.getString(R.string.lbl_mm)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupSixtyThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_yy)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFathersName: String? = MyApp.getInstance().resources.getString(R.string.lbl_father_s_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFathersNameOne: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_father_s_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMothersName: String? = MyApp.getInstance().resources.getString(R.string.lbl_mother_s_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMothersNameOne: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_mother_s_name)

)
