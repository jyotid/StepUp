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
        when {
            p1==0 -> {
                viewHolder.question?.text = "How can I approach towards giving tech talks?"
                viewHolder.answer?.text = "You can start to apply in some on of the local conference"
            }
            p1%2 ==0 -> {
                viewHolder.question?.text = "How to learn coding?"
                viewHolder.answer?.text = "Join a meetup. Practise regularly. Build stuff"
            }
            else -> {
                viewHolder.question?.text = "What makes a good entrepreneur?"
                viewHolder.answer?.text = "Ability to take risks. Planning. Execution."
            }
        }

    }

    override fun getItemCount(): Int {
        return 6
    }
}

class QuestionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val question = itemView?.question
    val answer = itemView?.answer
}