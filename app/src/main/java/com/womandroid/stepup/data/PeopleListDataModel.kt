package com.womandroid.stepup.data

import android.os.Parcel
import android.os.Parcelable


class PeopleListDataModel() : Parcelable {

    var name: String? = null
    var imageUrl: String? = null
    var professionalTitle: String? = null
    var location: String? = null
    var courses: List<CoursesDataModel>? = null
    var questionsMentor: List<QuestionsDataModel>? = null
    var description:String?=null

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        imageUrl = parcel.readString()
        professionalTitle = parcel.readString()
        location = parcel.readString()
        description = parcel.readString()
        courses = parcel.createTypedArrayList(CoursesDataModel.CREATOR)
        questionsMentor = parcel.createTypedArrayList(QuestionsDataModel.CREATOR)


    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(imageUrl)
        parcel.writeString(professionalTitle)
        parcel.writeString(location)
        parcel.writeString(description)
        parcel.writeList(courses)
        parcel.writeList(questionsMentor)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PeopleListDataModel> {
        override fun createFromParcel(parcel: Parcel): PeopleListDataModel {
            return PeopleListDataModel(parcel)
        }

        override fun newArray(size: Int): Array<PeopleListDataModel?> {
            return arrayOfNulls(size)
        }
    }
}