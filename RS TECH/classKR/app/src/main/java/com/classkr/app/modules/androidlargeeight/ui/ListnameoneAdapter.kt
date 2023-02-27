package com.classkr.app.modules.androidlargeeight.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.classkr.app.R
import com.classkr.app.databinding.RowListnameoneBinding
import com.classkr.app.modules.androidlargeeight.`data`.model.ListnameoneRowModel
import kotlin.Int
import kotlin.collections.List

class ListnameoneAdapter(
  var list: List<ListnameoneRowModel>
) : RecyclerView.Adapter<ListnameoneAdapter.RowListnameoneVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListnameoneVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listnameone,parent,false)
    return RowListnameoneVH(view)
  }

  override fun onBindViewHolder(holder: RowListnameoneVH, position: Int) {
    val listnameoneRowModel = ListnameoneRowModel()
    // TODO uncomment following line after integration with data source
    // val listnameoneRowModel = list[position]
    holder.binding.listnameoneRowModel = listnameoneRowModel
  }

  override fun getItemCount(): Int = 6
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ListnameoneRowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: ListnameoneRowModel
    ) {
    }
  }

  inner class RowListnameoneVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListnameoneBinding = RowListnameoneBinding.bind(itemView)
    init {
      binding.btnNameOne.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, ListnameoneRowModel())
      }
    }
  }
}
