package com.studydrive.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


abstract class CreateItemListAdapter : ListAdapter<CreateItem, CreateItemViewHolder>(CreateItemCallback()) {

    abstract fun deleteItem(itemId: String)

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): CreateItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_create, parent, false)
        return CreateItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: CreateItemViewHolder, pos: Int) {
        val item = getItem(pos)
        viewHolder.textView.text = item.text
        viewHolder.buttonDelete.setOnClickListener { deleteItem(item.id) }
    }

}

class CreateItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val textView: TextView = itemView.findViewById(R.id.text)
    val buttonDelete: View = itemView.findViewById(R.id.todo_item_delete)
}
