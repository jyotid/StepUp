package com.womandroid.stepup.categories

import android.app.PendingIntent.getActivity
import com.womandroid.stepup.data.CoursesDataModel
import com.womandroid.stepup.data.MentorDataModel
import com.womandroid.stepup.data.PeopleListDataModel
import com.womandroid.stepup.data.QuestionsDataModel
import java.io.IOException
import java.nio.charset.Charset
import org.json.JSONException
import org.json.JSONObject
import org.json.JSONArray
import java.util.ArrayList


class CategoryBasePeopleListPresenter {


    lateinit var view: CategoryBasedPeopleListActivity
    var mentorList: List<PeopleListDataModel>? = null
    var coursesList: List<CoursesDataModel>? = null
    var questionList: List<QuestionsDataModel>? = null

    fun onViewAttached(view: CategoryBasedPeopleListActivity) {
        this.view = view
    }

    fun getData() {
        try {
            mentorList = mutableListOf();


            val obj = JSONObject(loadJSONFromAsset())
            val mentors = obj.getJSONArray("mentors")
            for (i in 0 until mentors.length()) {
                coursesList = mutableListOf()
                questionList = mutableListOf()
                var mentor = PeopleListDataModel()
                val jsonObject = mentors.getJSONObject(i)
                mentor.name = jsonObject.getString("name")
                mentor.imageUrl = jsonObject.getString("imageUrl")
                mentor.professionalTitle = jsonObject.getString("professionalTitle")
                mentor.location = jsonObject.getString("location")
                mentor.description = jsonObject.getString("description")


                var courses = jsonObject.getJSONArray("courses")

                for (cou in 0 until courses.length()) {
                    var coursersDataModel = CoursesDataModel()
                    var q = courses.getJSONObject(cou)
                    coursersDataModel.courseName = q.getString("courseName")
                    coursersDataModel.duration = q.getString("duration")

                    (coursesList as MutableList<CoursesDataModel>)?.add(coursersDataModel)
                }

                var questions = jsonObject.getJSONArray("questionsMentor")
                for (ques in 0 until questions.length()) {
                    var questionDataModel = QuestionsDataModel()
                    var jsonObject = questions.getJSONObject(ques)
                    questionDataModel.question = jsonObject.getString("question")
                    questionDataModel.answer = jsonObject.getString("answer")

                    (questionList as MutableList<QuestionsDataModel>)?.add(questionDataModel)
                }
                mentor.questionsMentor = questionList
                mentor.courses = coursesList
                (mentorList as MutableList<PeopleListDataModel>)?.add(mentor)
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }
        view.getMentorList(mentorList as ArrayList<PeopleListDataModel>?)
    }

    private fun loadJSONFromAsset(): String? {
        var json: String? = null
        try {
            val `is` = view.getAssets().open("mentors.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }


}