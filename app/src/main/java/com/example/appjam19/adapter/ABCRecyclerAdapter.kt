package com.example.appjam19.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.appjam19.R
import com.example.appjam19.util.DateUtil

class ABCRecyclerViewAdapter : RecyclerView.Adapter<CommentViewHolder>(){

    private val comments : ArrayList<ContentDTO.Comment> = ArrayList()

    init {
        recyclerviewListenerRegistration = fireStore.collection("images").document(contentUid).collection("comments")
            .orderBy("timestamp",Query.Direction.DESCENDING)
            .addSnapshotListener { querySnapshot, _ ->
                if(querySnapshot == null)return@addSnapshotListener
                comments.clear()
                for(snapshot in querySnapshot.documents){
                    comments.add(snapshot.toObject(ContentDTO.Comment::class.java)!!)
                }
                notifyDataSetChanged()
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(this@CommentActivity).inflate(R.layout.item_comment,parent,false)
        return CommentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.dataText.text = DateUtil.formatDate(Date(comments[position].timestamp!!))
        holder.profileText.text = comments[position].userId
        holder.commentText.text = comments[position].comment

        fireStore.collection("profileImages").document(comments[position].uid!!).get()
            .addOnCompleteListener { task ->
                if(task.isSuccessful){
                    val url = task.result!!["image"]
                    Glide.with(this@CommentActivity).load(url).apply(RequestOptions().circleCrop()).into(holder.profileImage)
                }
            }
    }

}

}

class CommentViewHolder(view: View) : RecyclerView.ViewHolder(view){
    var dataText = view.commentviewItem_textview_date!!
    var profileText = view.commentviewItem_textview_profile!!
    var commentText = view.commentviewItem_textview_comment!!
    var profileImage = view.commentviewItem_imageview_profile!!
}
