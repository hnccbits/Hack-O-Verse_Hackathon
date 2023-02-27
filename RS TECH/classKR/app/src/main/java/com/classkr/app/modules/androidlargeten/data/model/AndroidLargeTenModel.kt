package com.classkr.app.modules.androidlargeten.`data`.model

import com.classkr.app.R
import com.classkr.app.appcomponents.di.MyApp
import kotlin.String

data class AndroidLargeTenModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtLeaveaNote: String? = MyApp.getInstance().resources.getString(R.string.lbl_leave_a_note)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAddFeedback: String? = MyApp.getInstance().resources.getString(R.string.msg_add_feedback)

)
