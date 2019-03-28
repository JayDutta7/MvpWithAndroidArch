package com.quangnguyen.stackoverflowclient.ui.questions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.quangnguyen.stackoverflowclient.R
import com.quangnguyen.stackoverflowclient.data.model.Question
import com.quangnguyen.stackoverflowclient.ui.base.BaseRecyclerViewAdapter
import com.quangnguyen.stackoverflowclient.util.DateTimeUtils
import io.reactivex.annotations.NonNull
import java.security.InvalidParameterException

class QuestionAdapter(@param:NonNull private val questions: MutableList<Question>) : BaseRecyclerViewAdapter<QuestionAdapter.QuestionViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): QuestionViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_question, viewGroup, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, i: Int) {
        super.onBindViewHolder(viewHolder, i)
        val vh = viewHolder as QuestionViewHolder //safe cast
        val question = questions[i]
        vh.titleText.text = question.title
        vh.userText.text = question.user!!.name
        vh.createdTimeText.text = DateTimeUtils.formatRelativeTime(question.creationDate)
        Glide.with(vh.profileImage)
                .load(question.user!!.image)
                .into(vh.profileImage)
    }

    override fun getItemCount(): Int {
        return questions.size
    }

    fun replaceData(questions: List<Question>) {
        this.questions.clear()
        this.questions.addAll(questions)
        notifyDataSetChanged()
    }

    fun getItem(position: Int): Question {
        if (position < 0 || position >= questions.size) {
            throw InvalidParameterException("Invalid item index")
        }
        return questions[position]
    }

    fun clearData() {
        questions.clear()
        notifyDataSetChanged()
    }

    class QuestionViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        @BindView(R.id.text_title)
        lateinit var titleText: TextView

        @BindView(R.id.text_user)
        lateinit var userText: TextView

        @BindView(R.id.text_created_time)
        lateinit var createdTimeText: TextView

        @BindView(R.id.image_profile)
        lateinit var profileImage: ImageView

        init {
            ButterKnife.bind(this, view)
        }
    }
}
