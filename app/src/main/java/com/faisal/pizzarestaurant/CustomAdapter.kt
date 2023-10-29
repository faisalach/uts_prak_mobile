package com.faisal.pizzarestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CustomAdapter(private val mList:List<ItemsViewModel>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)


        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]


        // sets the image to the imageview from our itemHolder class
        holder.imageView.setImageResource(ItemsViewModel.image)


        // sets the text to the textview from our itemHolder class
        holder.titleView.text = ItemsViewModel.title
        holder.descriptionView.text = ItemsViewModel.description
    }


    override fun getItemCount(): Int {
        return mList.size
    }


    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView) {
        val titleView: TextView = itemView.findViewById(R.id.titleItem)
        val descriptionView: TextView = itemView.findViewById(R.id.descriptionItem)
        val imageView: ImageView = itemView.findViewById(R.id.imageItem)

    }
}
