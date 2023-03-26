package ru.veronikarepina.table.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.veronikarepina.table.Listener
import ru.veronikarepina.table.adapter.Adapter
import ru.veronikarepina.table.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<TableViewModel>()
    private val listener = object: Listener {
        override fun setValues(value: String, position: Int, field: Int){
            viewModel.setValues(value, position, field)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recycler
        adapter = Adapter(this, listener)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        viewModel.listLiveData.observe(this){
            Log.d("MyLog", "CURRENT LIST: ${adapter.currentList}")
            Log.d("MyLog", "OBSERVE: $it")
            adapter.submitList(it.toMutableList())
        }
    }
}