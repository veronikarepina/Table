package ru.veronikarepina.table.presentation

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.veronikarepina.table.R
import ru.veronikarepina.table.model.Participant

class TableViewModel(application: Application): AndroidViewModel(application) {
    private val _listLiveData = MutableLiveData<ArrayList<Participant>>()
    val listLiveData: LiveData<ArrayList<Participant>> = _listLiveData
    private val participantList = ArrayList<Participant>()

    init {
        Log.d("MyLog", "INIT")
        initList(application)
        _listLiveData.value = participantList
    }

    fun setValues(value: String, position: Int, field: Int){
        when(field){
            1 -> participantList[position].field1 = value
            2 -> participantList[position].field2 = value
            3 -> participantList[position].field3 = value
            4 -> participantList[position].field4 = value
            5 -> participantList[position].field5 = value
            6 -> participantList[position].field6 = value
            7 -> participantList[position].field7 = value
        }
        Log.d("MyLog", "LIST IN MODEL: $participantList")
//        if(participantList[position].field2.isNotEmpty()){
//            Log.d("MyLog", "NOT EMPTY")
//            participantList[position].sum = participantList[position].field2
//            Log.d("MyLog", "LIST IN MODEL: $participantList")
////            Log.d("MyLog", "d: $d")
//        }

        if (participantList[position].field1.isNotEmpty() && participantList[position].field2.isNotEmpty() &&
            participantList[position].field3.isNotEmpty() && participantList[position].field4.isNotEmpty() &&
            participantList[position].field5.isNotEmpty() && participantList[position].field6.isNotEmpty() &&
            participantList[position].field7.isNotEmpty()){
            participantList[position].sum = (participantList[position].field1.toInt() +
                    participantList[position].field2.toInt() + participantList[position].field3.toInt() +
                    participantList[position].field4.toInt() + participantList[position].field5.toInt() +
                    participantList[position].field6.toInt() + participantList[position].field7.toInt()).toString()
            Log.d("MyLog", "LIST IN MODEL: $participantList")
            _listLiveData.value = participantList
            Log.d("MyLog", "LIVE DATA: ${listLiveData.value}")
        }
    }
    private fun sum(){

    }
    private fun positions(){

    }
    private fun initList(application: Application){
        participantList.add(Participant(application.getString(R.string.participant1), application.getString(
            R.string.one
        ), "0", "", "", "", "", "", "", "", ""))
        participantList.add(Participant(application.getString(R.string.participant2), application.getString(
            R.string.two
        ), "", "0", "", "", "", "", "", "", ""))
        participantList.add(Participant(application.getString(R.string.participant3), application.getString(
            R.string.three
        ), "", "", "0", "", "", "", "", "", ""))
        participantList.add(Participant(application.getString(R.string.participant4), application.getString(
            R.string.four
        ), "", "", "", "0", "", "", "", "", ""))
        participantList.add(Participant(application.getString(R.string.participant5), application.getString(
            R.string.five
        ), "", "", "", "", "0", "", "", "", ""))
        participantList.add(Participant(application.getString(R.string.participant6), application.getString(
            R.string.six
        ), "", "", "", "", "", "0", "", "", ""))
        participantList.add(Participant(application.getString(R.string.participant7), application.getString(
            R.string.seven
        ), "", "", "", "", "", "", "0", "", ""))
    }
}