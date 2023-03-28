package ru.veronikarepina.table.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.veronikarepina.table.Listener
import ru.veronikarepina.table.R
import ru.veronikarepina.table.model.Participant


class TableAdapter(private val context: Context, private val listener: Listener): ListAdapter<Participant, TableNewsHolder>(DiffUtilCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableNewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.table_row, parent, false)
        return TableNewsHolder(view)
    }
    override fun onBindViewHolder(holder: TableNewsHolder, position: Int) {
        holder.bind(getItem(position), context, listener, position)
    }
    override fun getItemViewType(position: Int): Int {
        return position
    }
}