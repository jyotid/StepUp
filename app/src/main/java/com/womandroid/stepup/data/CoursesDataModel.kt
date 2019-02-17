package com.womandroid.stepup.data

import android.os.Parcel
import android.os.Parcelable

class CoursesDataModel() : Parcelable{

    var courseName:String?=null
    var duration:String?=null

    constructor(parcel: Parcel) : this() {
        courseName = parcel.readString()
        duration = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(courseName)
        parcel.writeString(duration)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CoursesDataModel> {
        override fun createFromParcel(parcel: Parcel): CoursesDataModel {
            return CoursesDataModel(parcel)
        }

        override fun newArray(size: Int): Array<CoursesDataModel?> {
            return arrayOfNulls(size)
        }
    }
}