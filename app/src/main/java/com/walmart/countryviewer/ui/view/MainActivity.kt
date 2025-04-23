package com.walmart.countryviewer.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.walmart.countryviewer.data.model.ResultState
import com.walmart.countryviewer.databinding.ActivityMainBinding
import com.walmart.countryviewer.repository.CountryRepository
import com.walmart.countryviewer.ui.viewmodel.CountryViewModel
import com.walmart.countryviewer.ui.viewmodel.CountryViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CountryViewModel by viewModels {
        CountryViewModelFactory(CountryRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        viewModel.state.observe(this) { state ->
            when (state) {
                is ResultState.Loading -> binding.tvStatus.text = "Loading..."
                is ResultState.Success -> {
                    binding.tvStatus.text = "" // Clear status

                    binding.recyclerView.layoutManager = LinearLayoutManager(this)
                    binding.recyclerView.adapter = CountryAdapter(state.data)
                }
                is ResultState.Error -> binding.tvStatus.text = "Error: ${state.exception.message}"
            }
        }

        viewModel.loadCountries()
    }
}