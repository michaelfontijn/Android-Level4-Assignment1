package com.example.level4_assignment1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.level4_assignment1.models.Product

class ProductAdapter(private val products: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    /**
     * Creates and returns a ViewHolder object, inflating a standard layout called simple_list_item_1.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return products.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products[position])
    }

    //represents te item that will be rendered in the recyclerView
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //crate a txtField
        private val txtWhatToBuy : TextView = itemView.findViewById(android.R.id.text1)

        //bind the txtField to the viewHolder (the viewholder is a list item)
        fun bind(product: Product) {
            txtWhatToBuy.text = product.name
        }


    }
}

