package com.womandroid.stepup

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class QuestionAskedAdpter(val context: Context) : RecyclerView.Adapter<QuestionViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): QuestionViewHolder {

        return QuestionViewHolder(LayoutInflater.from(context).inflate(R.layout.item_question, null, false))
    }

    override fun onBindViewHolder(viewHolde: QuestionViewHolder, p1: Int) {
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return 5
    }
}

class QuestionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
}