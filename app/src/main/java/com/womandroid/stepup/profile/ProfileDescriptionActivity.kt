package com.womandroid.stepup.profile

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v4.view.ViewCompat
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.Window
import android.widget.Button
import android.widget.EditText
import com.womandroid.stepup.QuestionAskedAdpter
import com.womandroid.stepup.R
import kotlinx.android.synthetic.main.activity_profile_description.*
import android.view.ViewGroup


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


        rvQuestions.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvQuestions.adapter = QuestionAskedAdpter(this)
        rvQuestions.itemAnimator = DefaultItemAnimator()
        ViewCompat.setNestedScrollingEnabled(rvQuestions, false)

        tvAskQuestion.setOnClickListener {
            showAskQuestionDialog()
        }


    }

    private fun showAskQuestionDialog() {

        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_ask_question)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT));

        val btnSubmit = dialog.findViewById(R.id.btnSubmitQuestion) as Button
        val etAskQuestion = dialog.findViewById(R.id.etAskQuestion) as EditText
        btnSubmit.setOnClickListener {
            dialog.cancel()
        }

        dialog.setCancelable(true)
        dialog.show()

        val window = dialog.getWindow()
        window.setLayout(
                ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}
