package com.first.homework

import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Priority
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.first.homework.GossipGirlListAdapter.Companion.CHARACTER
import com.first.homework.GossipGirlListAdapter.Companion.FAV
import com.first.homework.GossipGirlListAdapter.Companion.QUOTE
import com.first.homework.databinding.CardGgBinding

class GossipGirlItem(
    private val binding: CardGgBinding,
    private val lsner: (GGItem.GGUiModel) -> Unit,
    private val glide: RequestManager
): RecyclerView.ViewHolder(binding.root) {

    private val roption = RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL)
        .priority(Priority.HIGH)

    fun onBind(gossipGirl: GGItem.GGUiModel) {
        with(binding) {
            name.text = gossipGirl.character
            quote.text = gossipGirl.quote

            root.setOnClickListener {
                lsner.invoke(gossipGirl)
            }

            fav.setFav(gossipGirl.isFav)

            glide.load(gossipGirl.url)
                .error(R.drawable.error)
                .load(gossipGirl.url)
                .placeholder(R.drawable.error)
                .apply(roption)
                .into(gg)
        }
    }

    private fun ImageView.setFav(isFav: Boolean) {
        setImageResource(
            if (isFav) {
                R.drawable.baseline_favorite_24
            }
            else R.drawable.baseline_heart_broken_24
        )
    }

    fun update(bundle: Bundle){
        if (bundle.containsKey(CHARACTER)) {
            bundle.getString(CHARACTER).also {
                binding.name.text = it
            }
        }
        if (bundle.containsKey(QUOTE)) {
            bundle.getString(QUOTE).also {
                binding.quote.text = it
            }
        }

        if (bundle.containsKey(FAV)) {
            bundle.getBoolean(FAV).also {
                binding.fav.setFav(it)
            }
        }
    }
}