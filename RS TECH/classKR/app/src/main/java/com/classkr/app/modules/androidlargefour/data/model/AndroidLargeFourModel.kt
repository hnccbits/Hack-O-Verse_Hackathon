package com.classkr.app.modules.androidlargefour.`data`.model

import com.classkr.app.R
import com.classkr.app.appcomponents.di.MyApp
import kotlin.String

data class AndroidLargeFourModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtStudentRegistr: String? =
      MyApp.getInstance().resources.getString(R.string.msg_student_registr2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtStaffandFacul: String? =
      MyApp.getInstance().resources.getString(R.string.msg_staff_and_facul)

)
