package ru.veronikarepina.table.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.veronikarepina.table.Listener
import ru.veronikarepina.table.adapter.TableAdapter
import ru.veronikarepina.table.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var tableAdapter: TableAdapter
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
        setupRecyclerView()
        viewModel.listLiveData.observe(this){
            tableAdapter.submitList(it.toMutableList())
        }
    }
    private fun setupRecyclerView(){
        recyclerView = binding.recycler
        tableAdapter = TableAdapter(this, listener)
        recyclerView.adapter = tableAdapter
    }
}