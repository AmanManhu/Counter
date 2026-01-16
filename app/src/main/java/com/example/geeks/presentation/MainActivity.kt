package com.example.geeks.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.geeks.R
import com.example.geeks.data.datasource.CountDataSource
import com.example.geeks.data.repository.CounterRepositoryImpl
import com.example.geeks.databinding.ActivityMainBinding
import com.example.geeks.domain.usecase.DecrementUseCase
import com.example.geeks.domain.usecase.GetCountUseCase
import com.example.geeks.domain.usecase.IncrementUseCase
import com.example.geeks.domain.usecase.ResetUseCase
import com.example.geeks.presentation.ViewModel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        setupListener()
        observeData()
        viewModel.updateCounter()

    }
    private fun setupListener(){
        binding.btnDecrement.setOnClickListener {
            viewModel.decrement()
        }
        binding.btnIncrement.setOnClickListener {
            viewModel.increment()
        }
        binding.btnReset.setOnClickListener {
            viewModel.reset()
        }

    }
    private fun observeData(){
        viewModel.counterData.observe(this){counter ->
            binding.tvCount.text = counter.count.toString()
            binding.tvIncrementStats.text = "Плюсов: ${counter.countIncrement}"
            binding.tvDecrementStats.text = "Минусов: ${counter.countDecrement}"

            binding.tvLastAction.text = "Последнее действие: ${counter.reset}"
        }
    }

}