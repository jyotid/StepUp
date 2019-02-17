package com.womandroid.stepup.categories

import android.app.PendingIntent.getActivity
import java.io.IOException
import java.nio.charset.Charset
import org.json.JSONException
import org.json.JSONObject
import org.json.JSONArray


class CategoryBasePeopleListPresenter {


    lateinit var view: CategoryBasedPeopleListActivity

    fun onViewAttached(view: CategoryBasedPeopleListActivity) {
        this.view = view
    }

    fun getData() {
        try {
            val obj = JSONObject(loadJSONFromAsset())
            val countries = obj.getJSONArray("countries")
            for (i in 0 until countries.length()) {
                val jsonObject = countries.getJSONObject(i)
                val code = jsonObject.getString("code")
                val nameAr = jsonObject.getString("nameAr")
                val nameEn = jsonObject.getString("nameEn")
                //     countryList.add(Country(code, nameAr, nameEn))
            }

        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    fun loadJSONFromAsset(): String? {
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