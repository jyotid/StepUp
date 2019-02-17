package com.womandroid.stepup.data

import android.os.Parcel
import android.os.Parcelable

class QuestionsDataModel() : Parcelable {
    var question:String?=null
    var answer:String?=null

    constructor(parcel: Parcel) : this() {
        question = parcel.readString()
        answer = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(question)
        parcel.writeString(answer)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuestionsDataModel> {
        override fun createFromParcel(parcel: Parcel): QuestionsDataModel {
            return QuestionsDataModel(parcel)
        }

        override fun newArray(size: Int): Array<QuestionsDataModel?> {
            return arrayOfNulls(size)
        }
    }
}