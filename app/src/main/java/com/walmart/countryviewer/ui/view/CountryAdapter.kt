package com.walmart.countryviewer.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.walmart.countryviewer.data.model.Country
import com.walmart.countryviewer.databinding.ItemCountryBinding


class CountryAdapter(private val countries: List<Country>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]
        holder.binding.tvNameRegion.text = "${country.name}, ${country.region}       ${country.code}"
        holder.binding.tvCapital.text = country.capital
    }

    override fun getItemCount(): Int = countries.size
}