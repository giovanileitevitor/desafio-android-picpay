package com.picpay.desafio.android.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.applabbs.data.entity.User
import com.bumptech.glide.RequestManager
import com.picpay.desafio.android.R

class UsersListAdapter(
    private val context: Context,
    private val data: List<User>,
    private val mGlide: RequestManager,
    private val itemListener: (User) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val viewModel: View

        viewModel = inflater.inflate(R.layout.list_item_user, parent, false)
        return DefaultVH(viewModel)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        processDefault(holder, position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    private inner class DefaultVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photo: ImageView = itemView.findViewById(R.id.picture)
        var username: TextView = itemView.findViewById(R.id.username)
        var name: TextView = itemView.findViewById(R.id.name)

        init{
            itemView.setOnClickListener {
                val position = adapterPosition
                val item = data[position]
                itemListener.invoke(item)
            }
        }
    }

    private fun processDefault(holder: RecyclerView.ViewHolder, position: Int) {
        val item = data[position]

        val defaultVH = holder as DefaultVH

        mGlide.load(item.img)
            .placeholder(R.drawable.ic_round_account_circle)
            .into(defaultVH.photo)

        defaultVH.username.text = item.username
        defaultVH.name.text = item.name
    }
}