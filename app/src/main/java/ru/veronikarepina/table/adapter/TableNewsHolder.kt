package ru.veronikarepina.table.adapter

import android.content.Context
import android.graphics.Color
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import ru.veronikarepina.table.Listener
import ru.veronikarepina.table.R
import ru.veronikarepina.table.databinding.TableRowBinding
import ru.veronikarepina.table.model.Participant

class TableNewsHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = TableRowBinding.bind(view)

    fun bind(item: Participant, context: Context, listener: Listener, pos: Int) = with(binding){
        Log.d("MyLog", "BIND")

        name.text = item.name
        participantNumber.text = item.numberParticipant

        val fields = listOf(field1, field2, field3, field4, field5, field6, field7)
        val fieldsStrings = mutableListOf(item.field1, item.field2, item.field3,
            item.field4, item.field5, item.field6, item.field7)
        val digits = listOf("0", "1", "2", "3", "4", "5")
        for((index, field) in fieldsStrings.withIndex())
            if(field == "0"){
                fields[index].setBackgroundColor(Color.BLACK)
                fields[index].isFocusable = false
            }
        field1.addTextChangedListener {
            if(it.toString() == ""){
                listener.setValues(it.toString(), pos, 1)
            }
            else if (it.toString() in digits){
                listener.setValues(it.toString(), pos, 1)
            }
            else {
                field1.setTextColor(Color.RED)
                Toast.makeText(context, context.getString(R.string.error), Toast.LENGTH_SHORT).show()
                score.text = ""
            }
        }
        field2.addTextChangedListener {
            Log.d("MyLog", "CURRENT LIST BEFORE: $")
            if(it.toString() == ""){
                listener.setValues(it.toString(), pos, 2)
            }
            else if (it.toString() in digits){
                listener.setValues(it.toString(), pos, 2)
            }
            else {
                field2.setTextColor(Color.RED)
                Toast.makeText(context, context.getString(R.string.error), Toast.LENGTH_SHORT).show()
                score.text = ""
                item.field2 = ""
            }
            Log.d("MyLog", "CURRENT LIST AFTER: $it")
        }
        field3.addTextChangedListener {
            if(it.toString() == ""){
                listener.setValues(it.toString(), pos, 3)
            }
            else if (it.toString() in digits){
                listener.setValues(it.toString(), pos, 3)
            }
            else {
                field3.setTextColor(Color.RED)
                Toast.makeText(context, context.getString(R.string.error), Toast.LENGTH_SHORT).show()
                score.text = ""
            }
        }
        field4.addTextChangedListener {
            if(it.toString() == ""){
                listener.setValues(it.toString(), pos, 4)
            }
            else if (it.toString() in digits){
                listener.setValues(it.toString(), pos, 4)
            }
            else {
                field4.setTextColor(Color.RED)
                Toast.makeText(context, context.getString(R.string.error), Toast.LENGTH_SHORT).show()
                score.text = ""
            }
        }
        field5.addTextChangedListener {
            if(it.toString() == ""){
                listener.setValues(it.toString(), pos, 5)
            }
            else if (it.toString() in digits){
                listener.setValues(it.toString(), pos, 5)
            }
            else {
                field5.setTextColor(Color.RED)
                Toast.makeText(context, context.getString(R.string.error), Toast.LENGTH_SHORT).show()
                score.text = ""
            }
        }
        field6.addTextChangedListener {
            if(it.toString() == ""){
                listener.setValues(it.toString(), pos, 6)
            }
            else if (it.toString() in digits){
                listener.setValues(it.toString(), pos, 6)
            }
            else {
                field6.setTextColor(Color.RED)
                Toast.makeText(context, context.getString(R.string.error), Toast.LENGTH_SHORT).show()
                score.text = ""
            }
        }
        field7.addTextChangedListener {
            if(it.toString() == ""){
                listener.setValues(it.toString(), pos, 7)
            }
            else if (it.toString() in digits){
                listener.setValues(it.toString(), pos, 7)
            }
            else {
                field7.setTextColor(Color.RED)
                Toast.makeText(context, context.getString(R.string.error), Toast.LENGTH_SHORT).show()
                score.text = ""
            }
        }
        score.text = item.sum
        position.text = item.position
    }
//        private fun setScore(fieldsStrings: List<String>, item: Participant, pos: Int){
//            val score = if(!(fieldsStrings.map { it.isNotEmpty() }.contains(false)))
//                fieldsStrings.sumOf { it.toInt() }.toString()  else ""
//            Log.d("MyLog", "fields: $fieldsStrings")
//            item.sum = binding.score.text.toString()
//            Log.d("MyLog", "item: $item")
//            //sumList[pos] = if (binding.score.text != "") binding.score.text.toString() else ""
//            if(score != ""){
//                sumList[pos] = score
//            }
//            binding.score.text = score
////            if(!sumList.contains(""))
////                setPositions(pos)
//        }
}