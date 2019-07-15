package com.studydrive.task

import androidx.recyclerview.widget.DiffUtil.ItemCallback


class CreateItemCallback : ItemCallback<CreateItem>() {
    override fun areItemsTheSame(item1: CreateItem, item2: CreateItem): Boolean {
        return item1.id == item2.id
    }

    override fun areContentsTheSame(item1: CreateItem, item2: CreateItem): Boolean {
        return item1.text == item2.text
    }
}