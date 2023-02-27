package com.classkr.app.modules.androidlargeeight.`data`.model

import com.classkr.app.R
import com.classkr.app.appcomponents.di.MyApp
import kotlin.String

data class AndroidLargeEightModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtStaffandFacul: String? =
      MyApp.getInstance().resources.getString(R.string.msg_staff_and_facul)

)
