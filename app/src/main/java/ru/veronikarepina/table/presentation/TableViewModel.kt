package ru.veronikarepina.table.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.veronikarepina.table.R
import ru.veronikarepina.table.model.Participant

class TableViewModel(application: Application): AndroidViewModel(application) {
    private val _listLiveData = MutableLiveData<MutableList<Participant>>()
    val listLiveData: LiveData<MutableList<Participant>> = _listLiveData
    private var participantList: MutableList<Participant> = mutableListOf()
    private val bufferList: MutableList<Participant>

    init {
        initList(application)
        bufferList = participantList.map { it.copy() }.toMutableList()
        _listLiveData.value = participantList
    }

    fun setValues(value: String, position: Int, field: Int) = with(bufferList[position]){
        when(field){
            1 -> field1 = value
            2 -> field2 = value
            3 -> field3 = value
            4 -> field4 = value
            5 -> field5 = value
            6 -> field6 = value
            7 -> field7 = value
        }

        setSum(position)
        setPositions()

        participantList = bufferList.map { it.copy() }.toMutableList()
        _listLiveData.value = participantList
    }
    private fun setSum(position: Int){
        val listFields = with(bufferList[position]) {
            listOf(
                field1.toString(),
                field2.toString(),
                field3.toString(),
                field4.toString(),
                field5.toString(),
                field6.toString(),
                field7.toString()
            )
        }

        bufferList[position].sum = if(!listFields.contains(""))
            if (!listFields
                    .filter { it!="null" }
                    .map { it.toInt() in 0..5 }
                    .contains(false)
            )
                listFields
                    .filter { it != "null" }
                    .sumOf { item -> item.toInt() }
                    .toString()
            else ""
        else ""
        if (bufferList[position].sum == "")
            removePositions()
    }
    private fun setPositions(){
        val listSums = mutableListOf<String>()
        bufferList.map { listSums.add(it.sum) }

        if (!listSums.contains("")){
            val listMaps: MutableMap<Int, String> = mutableMapOf()
            for ((index, item) in listSums.withIndex())
                listMaps[index] = item

            val sortedList = listSums
                .map { it.toInt() }
                .distinct()
                .sortedDescending()
                .map { it.toString() }

            listMaps.forEach{
                listMaps[it.key] = (sortedList.indexOf(it.value) + 1).toString()
                bufferList[it.key].position = it.value
            }
        }
    }
    private fun removePositions(){
        bufferList.map { it.position = "" }
    }
    private fun initList(application: Application) = with(participantList){
        add(Participant(application.getString(R.string.participant1), application.getString(R.string.one), null, "", "", "", "", "", "", "", ""))
        add(Participant(application.getString(R.string.participant2), application.getString(R.string.two), "", null, "", "", "", "", "", "", ""))
        add(Participant(application.getString(R.string.participant3), application.getString(
            R.string.three
        ), "", "", null, "", "", "", "", "", ""))
        add(Participant(application.getString(R.string.participant4), application.getString(
            R.string.four
        ), "", "", "", null, "", "", "", "", ""))
        add(Participant(application.getString(R.string.participant5), application.getString(
            R.string.five
        ), "", "", "", "", null, "", "", "", ""))
        add(Participant(application.getString(R.string.participant6), application.getString(
            R.string.six
        ), "", "", "", "", "", null, "", "", ""))
        add(Participant(application.getString(R.string.participant7), application.getString(
            R.string.seven
        ), "", "", "", "", "", "", null, "", ""))
    }
}