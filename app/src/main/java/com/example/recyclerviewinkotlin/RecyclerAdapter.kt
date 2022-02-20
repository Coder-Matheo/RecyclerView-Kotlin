package com.example.recyclerviewinkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private var titles = arrayOf("chapter One","chapter Two","chapter Three","chapter Four","chapter Five","chapter Six")
    private var details = arrayOf("Item one details","Item two details","Item three details","Item four details",
        "Item five details","Item six details")
    private var images = intArrayOf(R.drawable.image,R.drawable.image,R.drawable.image,R.drawable.image,
        R.drawable.image,R.drawable.image,R.drawable.image)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }
    override fun getItemCount(): Int {
        return titles.size
    }
    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)

            itemView.setOnClickListener{
                val position: Int = adapterPosition

                Toast.makeText(itemView.context, "you clicked on ${titles[position]}", Toast.LENGTH_SHORT).show()
            }

        }
    }
}