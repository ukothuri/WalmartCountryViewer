package com.walmart.countryviewer.repository

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.walmart.countryviewer.data.model.Country
import okhttp3.OkHttpClient
import okhttp3.Request

class CountryRepository : ICountryRepository {
    override suspend fun getCountries(): List<Country> {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://gist.githubusercontent.com/peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw Exception("Unexpected response")
            val json = response.body?.string() ?: throw Exception("Empty response")
            val listType = object : TypeToken<List<Country>>() {}.type
            return Gson().fromJson(json, listType)
        }
    }
}