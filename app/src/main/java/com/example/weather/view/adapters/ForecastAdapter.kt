package com.example.weather.view.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.databinding.ForecastItemBinding
import com.example.weather.model.ForecastDay

class ForecastAdapter(
    var forecast: MutableList<ForecastDay>
): RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {
    private lateinit var context: Context

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ForecastItemBinding.bind(view)

        fun setupUI(item: ForecastDay) {
            binding.dateTextView.text = item.date
            binding.maxTempTextView.text = item.day.maxTemp.toString() + "°C"
            binding.minTempTextView.text = item.day.minTemp.toString() + "°C"

            binding.containerView.setOnClickListener {
                Log.i("MENSAJE", "El clima estara: ${item.day.condition.text}")
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastAdapter.ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context)
            .inflate(R.layout.forecast_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return forecast.count()
    }

    override fun onBindViewHolder(holder: ForecastAdapter.ViewHolder, position: Int) {
        holder.setupUI(forecast[position])
    }
}