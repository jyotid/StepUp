package com.womandroid.stepup.profile

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
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
import com.womandroid.stepup.data.CoursesDataModel
import com.womandroid.stepup.data.PeopleListDataModel
import com.womandroid.stepup.data.QuestionsDataModel


class ProfileDescriptionActivity : AppCompatActivity() {

    var data : PeopleListDataModel? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_description)
        data = intent.getParcelableExtra("person")
        initViews()
    }

    private fun initViews() {
        rvCourses.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCourses.adapter = CoursesAdapter(this, data = mutableListOf())
        rvCourses.itemAnimator = DefaultItemAnimator()


        rvQuestions.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvQuestions.adapter = QuestionAskedAdpter(this, mutableListOf())
        rvQuestions.itemAnimator = DefaultItemAnimator()
        ViewCompat.setNestedScrollingEnabled(rvQuestions, false)

        desc.text = data?.description

        tvAskQuestion.setOnClickListener {
            showAskQuestionDialog()
        }

        handshake.setOnClickListener {
            Snackbar.make(
                    llview, // Parent view
                    "Your request has been sent to mentor", // Message to show
                    Snackbar.LENGTH_SHORT // How long to display the message.
            ).show()
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
            Snackbar.make(
                    llview, // Parent view
                    "Your query is been submitted", // Message to show
                    Snackbar.LENGTH_SHORT // How long to display the message.
            ).show()
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
