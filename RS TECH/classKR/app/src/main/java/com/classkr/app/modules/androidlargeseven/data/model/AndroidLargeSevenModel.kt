package com.classkr.app.modules.androidlargeseven.`data`.model

import com.classkr.app.R
import com.classkr.app.appcomponents.di.MyApp
import kotlin.String

data class AndroidLargeSevenModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupFortyTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_semester)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtResult: String? = MyApp.getInstance().resources.getString(R.string.lbl_result)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.msg_student_name1)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageOne: String? = MyApp.getInstance().resources.getString(R.string.msg_2_student_nam)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroupFortyFour: String? =
      MyApp.getInstance().resources.getString(R.string.msg_student_record)

)
