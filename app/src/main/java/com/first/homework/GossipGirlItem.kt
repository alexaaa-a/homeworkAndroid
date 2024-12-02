package com.first.homework

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Priority
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.first.homework.databinding.ItemGossipgirlBinding

class GossipGirlItem (
    private val binding: ItemGossipgirlBinding,
    private val lsner: (GossipGirl) -> Unit,
    private val glide: RequestManager
): RecyclerView.ViewHolder(binding.root) {

    private val roption = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH)

    fun onBind(gossipGirl: GossipGirl) {
        with(binding) {
            name.text = gossipGirl.character
            quote.text = gossipGirl.quote

            root.setOnClickListener {
                lsner.invoke(gossipGirl)
            }

            glide.load(gossipGirl.url)
                .error(R.drawable.error)
                .load(gossipGirl.url)
                .placeholder(R.drawable.error)
                .apply(roption)
                .into(gg)
        }
    }
}