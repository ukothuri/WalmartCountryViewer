package com.walmart.countryviewer.repository

import com.walmart.countryviewer.data.model.Country

interface ICountryRepository {
    suspend fun getCountries(): List<Country>
}