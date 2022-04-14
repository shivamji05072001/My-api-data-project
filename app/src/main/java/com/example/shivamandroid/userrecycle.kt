package com.example.apidata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shivamandroid.R

class userrecycle(val context:Context, val userlist:List<Users.UsersItem>):RecyclerView.Adapter<userrecycle.userHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userrecycle.userHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.usersdata,parent,false)
        return userHolder(view)
    }

    override fun onBindViewHolder(holder: userrecycle.userHolder, position: Int) {
    holder.name.text=userlist[position].name.toString()
        userlist[position].subjects.let {
            holder.subject.text = it[0].toString()
        }
        Glide.with(context)
            .load(userlist[position].profileImage)
            .into(holder.userimage)
        userlist[position].qualification.let {
            holder.qualification.text=it[0]
        }
    }

    override fun getItemCount(): Int {
        return userlist.size
    }
    inner class userHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var name:TextView
        var subject:TextView
        var viewmore:Button
        var userimage:ImageView
        var qualification:TextView

        init {
            name=itemView.findViewById(R.id.name)
           subject=itemView.findViewById(R.id.subject)
            viewmore=itemView.findViewById(R.id.viewmore)
           userimage=itemView.findViewById(R.id.userimage)
            qualification=itemView.findViewById(R.id.qualifications)
        }
    }
}