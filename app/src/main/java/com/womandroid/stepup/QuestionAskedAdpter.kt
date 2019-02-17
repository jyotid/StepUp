package com.womandroid.stepup

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.womandroid.stepup.data.QuestionsDataModel
import kotlinx.android.synthetic.main.item_question.view.*

class QuestionAskedAdpter(val context: Context, val data: List<QuestionsDataModel>) : RecyclerView.Adapter<QuestionViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): QuestionViewHolder {

        return QuestionViewHolder(LayoutInflater.from(context).inflate(R.layout.item_question, null, false))
    }

    override fun onBindViewHolder(viewHolder: QuestionViewHolder, p1: Int) {
        viewHolder.question?.text = data[p1].question
        viewHolder.answer?.text = data[p1].answer
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

class QuestionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val question = itemView?.question
    val answer = itemView?.answer
}