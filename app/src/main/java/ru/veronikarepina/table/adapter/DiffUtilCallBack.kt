package ru.veronikarepina.table.adapter

import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import ru.veronikarepina.table.model.Participant

class DiffUtilCallBack: DiffUtil.ItemCallback<Participant>(){
    override fun areItemsTheSame(oldItem: Participant, newItem: Participant): Boolean {
        Log.d("MyLog", "items diff: ${oldItem.name==newItem.name}")
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Participant, newItem: Participant): Boolean {
        Log.d("MyLog", "content: ${oldItem==newItem}")
        return oldItem == newItem
    }
}