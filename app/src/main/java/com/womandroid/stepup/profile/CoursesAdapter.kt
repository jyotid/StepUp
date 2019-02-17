package com.womandroid.stepup.profile

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.womandroid.stepup.R
import com.womandroid.stepup.data.CoursesDataModel
import kotlinx.android.synthetic.main.item_courses.view.*

class CoursesAdapter(val context: Context, val data : List<CoursesDataModel>?) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_courses, null, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, p1: Int) {
        when {
            p1==0 -> {
                viewHolder.tvCourseName?.text = "Rx java and Android"
                viewHolder.tvCourseDesc?.text = "6 months"
            }
            p1%2 ==0 -> {
                viewHolder.tvCourseName?.text = "XML Architeture"
                viewHolder.tvCourseDesc?.text = "5 months"
            }
            else -> {
                viewHolder.tvCourseName?.text = "CS Fundamentals"
                viewHolder.tvCourseDesc?.text = "9 months"
            }
        }


    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return 6
    }
}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvCourseName = itemView?.tvCourseName
    val tvCourseDesc = itemView?.tvCourseDesc
}