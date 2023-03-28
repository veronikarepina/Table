package ru.veronikarepina.table.adapter

import androidx.recyclerview.widget.DiffUtil
import ru.veronikarepina.table.model.Participant

class DiffUtilCallBack: DiffUtil.ItemCallback<Participant>(){
    override fun areItemsTheSame(oldItem: Participant, newItem: Participant): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Participant, newItem: Participant): Boolean {
        return oldItem == newItem
    }
}