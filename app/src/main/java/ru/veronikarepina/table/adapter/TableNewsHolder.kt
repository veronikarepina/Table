package ru.veronikarepina.table.adapter

import android.content.Context
import android.graphics.Color
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import ru.veronikarepina.table.Listener
import ru.veronikarepina.table.R
import ru.veronikarepina.table.databinding.TableRowBinding
import ru.veronikarepina.table.model.Participant

class TableNewsHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = TableRowBinding.bind(view)
    private var textWatcher1: TextWatcher? = null
    private var textWatcher2: TextWatcher? = null
    private var textWatcher3: TextWatcher? = null
    private var textWatcher4: TextWatcher? = null
    private var textWatcher5: TextWatcher? = null
    private var textWatcher6: TextWatcher? = null
    private var textWatcher7: TextWatcher? = null
    fun bind(item: Participant, context: Context, listener: Listener, pos: Int) = with(binding){

        setBlackFields(item)

        field1.removeTextChangedListener(textWatcher1)
        field2.removeTextChangedListener(textWatcher2)
        field3.removeTextChangedListener(textWatcher3)
        field4.removeTextChangedListener(textWatcher4)
        field5.removeTextChangedListener(textWatcher5)
        field6.removeTextChangedListener(textWatcher6)
        field7.removeTextChangedListener(textWatcher7)

        name.text = item.name
        participantNumber.text = item.numberParticipant

        field1.setText(item.field1)
        checkTextValid(field1.text.toString(), field1)

        field2.setText(item.field2)
        checkTextValid(field2.text.toString(), field2)

        field3.setText(item.field3)
        checkTextValid(field3.text.toString(), field3)

        field4.setText(item.field4)
        checkTextValid(field4.text.toString(), field4)

        field5.setText(item.field5)
        checkTextValid(field5.text.toString(), field5)

        field6.setText(item.field6)
        checkTextValid(field6.text.toString(), field6)

        field7.setText(item.field7)
        checkTextValid(field7.text.toString(), field7)

        score.text = item.sum
        position.text = item.position

        textWatcher1 = field1.addTextChangedListener {
            listener.setValues(it.toString(), pos, FIELD_NUMBER_1)
            checkTextValidAndShowToast(context, it.toString(), field1)
        }
        textWatcher2 = field2.addTextChangedListener {
            listener.setValues(it.toString(), pos, FIELD_NUMBER_2)
            checkTextValidAndShowToast(context, it.toString(), field2)
        }
        textWatcher3 = field3.addTextChangedListener {
            listener.setValues(it.toString(), pos, FIELD_NUMBER_3)
            checkTextValidAndShowToast(context, it.toString(), field3)
        }
        textWatcher4 = field4.addTextChangedListener {
            listener.setValues(it.toString(), pos, FIELD_NUMBER_4)
            checkTextValidAndShowToast(context, it.toString(), field4)
        }
        textWatcher5 = field5.addTextChangedListener {
            listener.setValues(it.toString(), pos, FIELD_NUMBER_5)
            checkTextValidAndShowToast(context, it.toString(), field5)
        }
        textWatcher6 = field6.addTextChangedListener {
            listener.setValues(it.toString(), pos, FIELD_NUMBER_6)
            checkTextValidAndShowToast(context, it.toString(), field6)
        }
        textWatcher7 = field7.addTextChangedListener {
            listener.setValues(it.toString(), pos, FIELD_NUMBER_7)
            checkTextValidAndShowToast(context, it.toString(), field7)
        }
    }
    private fun setBlackFields(item: Participant) = with(binding){
        val fields = listOf(field1, field2, field3, field4, field5, field6, field7)
        val fieldsStrings = with(item) {
            listOf(field1, field2, field3, field4, field5, field6, field7)
        }

        for((index, field) in fieldsStrings.withIndex())
            if(field == null) with(fields[index]){
                setBackgroundColor(Color.BLACK)
                isFocusable = false
                isCursorVisible = false
            }
    }
    private fun checkTextValid(text: String, field: EditText) = with(field){
        if (text !in ALLOWED_VALUES_LIST && text != "")
            setTextColor(Color.RED)
        else
            setTextColor(Color.BLACK)
        setSelection(text.length)
    }
    private fun checkTextValidAndShowToast(context: Context, text: String, field: EditText){
        if (text !in ALLOWED_VALUES_LIST && text != ""){
            field.setTextColor(Color.RED)
            Toast.makeText(context, context.getString(R.string.error), Toast.LENGTH_SHORT).show()
        }
    }
    companion object{
        val ALLOWED_VALUES_LIST = listOf("0", "1", "2", "3", "4", "5")
        const val FIELD_NUMBER_1 = 1
        const val FIELD_NUMBER_2 = 2
        const val FIELD_NUMBER_3 = 3
        const val FIELD_NUMBER_4 = 4
        const val FIELD_NUMBER_5 = 5
        const val FIELD_NUMBER_6 = 6
        const val FIELD_NUMBER_7 = 7
    }
}