package org.edu.yamini.viewmodel

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.edu.yamini.data.db.entities.Users
import org.edu.yamini.databinding.LayoutUserItemBinding

class UserAdapter : RecyclerView.Adapter<UserViewHolder>() {

    var userList = mutableListOf<Users>()
    val TAG ="UserAdapter"

    fun setUsersList(userList : List<Users>) {
        Log.d(TAG,"setUsersList")
        this.userList = userList.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutUserItemBinding.inflate(inflater, parent, false)
        return  UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.binding.idTvName.text = "Name :"+user.name
        holder.binding.idTvEmail.text = "Email :"+user.email

        Log.d(TAG, " user "+user+" position "+position);
    }


}


class UserViewHolder ( val binding: LayoutUserItemBinding) : RecyclerView.ViewHolder(binding.root) {

}