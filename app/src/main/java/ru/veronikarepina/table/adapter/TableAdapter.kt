package ru.veronikarepina.table.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.veronikarepina.table.Listener
import ru.veronikarepina.table.R
import ru.veronikarepina.table.model.Participant


class Adapter(private val context: Context, private val listener: Listener): ListAdapter<Participant, TableNewsHolder>(DiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableNewsHolder {
        Log.d("MyLog", "ON CREATE VIEW HOLDER")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.table_row, parent, false)
        return TableNewsHolder(view)
    }

    override fun onBindViewHolder(holder: TableNewsHolder, position: Int) {
        Log.d("MyLog", "ON BIND VIEW HOLDER")
        holder.bind(getItem(position), context, listener, position)
    }
}

//inline fun EditText.onTextChange(crossinline listener: (String) -> Unit) {
//    this.addTextChangedListener(object: TextWatcher {
//        override fun beforeTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {}
//
//        override fun onTextChanged(charSequence: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            listener(charSequence.toString())
//        }
//
//        override fun afterTextChanged(p0: Editable?) {}
//    })
//}