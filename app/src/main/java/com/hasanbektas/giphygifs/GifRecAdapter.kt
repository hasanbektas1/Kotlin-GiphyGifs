package com.hasanbektas.giphygifs

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hasanbektas.giphygifs.databinding.RecyclerRowBinding

class GifRecAdapter(val context: Context, val gifList: List<GifDataModel>) : RecyclerView.Adapter<GifRecAdapter.GifRowHolder>() {

    class GifRowHolder(val binding: RecyclerRowBinding):RecyclerView.ViewHolder(binding.root) {
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifRowHolder {

        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return GifRowHolder(binding)
    }
    override fun onBindViewHolder(holder: GifRowHolder, position: Int) {

        val data = gifList[position]

        Glide.with(context).load(data.images.original.url)
            .into(holder.binding.imageView)

    }
    override fun getItemCount(): Int {
        return gifList.size
    }
}