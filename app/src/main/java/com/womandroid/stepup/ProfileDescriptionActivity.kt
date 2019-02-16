package com.womandroid.stepup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_profile_description.*
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.RecyclerView





class ProfileDescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_description)
        initViews()
    }

    private fun initViews() {
        rvCourses.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCourses.adapter = CoursesAdapter(this)
        rvCourses.setItemAnimator(DefaultItemAnimator())

//        val layoutManager = object : LinearLayoutManager(this) {
//            override fun canScrollVertically(): Boolean {
//                return false
//            }
//        }
//        rvQuestions.setLayoutManager(layoutManager)

        rvQuestions.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
      //  rvQuestions.isNestedScrollingEnabled = false
        rvQuestions.adapter = QuestionAskedAdpter(this)
        rvQuestions.setItemAnimator(DefaultItemAnimator())
        ViewCompat.setNestedScrollingEnabled(rvQuestions, false);


    }
}
