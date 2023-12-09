package com.example.lol

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class CeritaAdapter : RecyclerView.Adapter<CeritaAdapter.MyViewHolder>() {
    val list = ContentCerita.array
    class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        val judul = itemView.findViewById<TextView>(R.id.tvJudul)
        val photo = itemView.findViewById<ImageView>(R.id.tvJudul)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_cerita, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int  = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val cerita = list[position]
        holder.apply {
            judul.text = cerita.judul
            Glide.with (itemView.context)
                .load(cerita.photo)
                .into(photo)
        }
    }
}