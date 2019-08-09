package com.github.pacey.launchpal.ui.launches

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.pacey.launchpal.R
import com.github.pacey.launchpal.data.Launch
import kotlinx.android.extensions.LayoutContainer

import kotlinx.android.synthetic.main.launch_item.*
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class LaunchesAdapter : ListAdapter<Launch, LaunchesAdapter.LaunchesViewHolder>(LaunchDiffCallback()) {

    val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchesViewHolder {
        return LaunchesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.launch_item, parent, false))
    }

    override fun onBindViewHolder(holder: LaunchesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class LaunchesViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(item: Launch) {
            Glide.with(containerView)
                .load(item.rocket?.getImageAt(200))
                .centerCrop()
                .into(rocket_image)
            launch_name.text = item.name
            launch_date.text = dateTimeFormatter.format(item.getDate().atZone(ZoneId.systemDefault()))
            launch_location.text = item.location?.name ?: "unknown location"
        }
    }

    private class LaunchDiffCallback : DiffUtil.ItemCallback<Launch>() {
        override fun areItemsTheSame(oldItem: Launch, newItem: Launch): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Launch, newItem: Launch): Boolean {
            return oldItem == newItem
        }
    }
}
