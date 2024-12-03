package com.first.homework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.first.homework.databinding.ItemGossipgirlBinding

class GossipGirlAdapter (
    private val list: List<GossipGirl>,
    private val glide: RequestManager,
    private val lsner: (GossipGirl) -> Unit
): RecyclerView.Adapter<GossipGirlItem>() {

    override fun onCreateViewHolder (
        prnt: ViewGroup,
        type: Int): GossipGirlItem = GossipGirlItem(
            binding = ItemGossipgirlBinding.inflate(LayoutInflater.from(prnt.context), prnt,
                false), glide = glide, lsner = lsner)

    override fun onBindViewHolder(
        holder: GossipGirlItem,
        position: Int
    ) {
        holder.onBind(list[position])
    }


    override fun getItemCount(): Int = list.size


}