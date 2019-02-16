package com.womandroid.stepup

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_courses.view.*

class CoursesAdapter(val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_courses, null, false))
    }

    override fun onBindViewHolder(viewHolde: ViewHolder, p1: Int) {
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return 5
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvCourseName = itemView?.tvCourseName
    val tvCourseDesc = itemView?.tvCourseDesc
}