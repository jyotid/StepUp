package com.womandroid.stepup.profile

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_profile_description.*
import android.support.v7.widget.DefaultItemAnimator
import com.womandroid.stepup.QuestionAskedAdpter
import com.womandroid.stepup.R


class ProfileDescriptionActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        fun getIntent(context: Context): Intent {
            return Intent(context, ProfileDescriptionActivity::class.java)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_description)
        initViews()
    }

    private fun initViews() {
        rvCourses.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCourses.adapter = CoursesAdapter(this)
        rvCourses.itemAnimator = DefaultItemAnimator()

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
