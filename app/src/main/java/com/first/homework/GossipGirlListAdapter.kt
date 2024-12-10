package com.first.homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.RequestManager
import com.first.homework.databinding.CardGgBinding

class GossipGirlListAdapter (
    private val glide: RequestManager,
    private val lsner: (GGItem.GGUiModel) -> Unit
): ListAdapter<GGItem.GGUiModel, GossipGirlItem>(object : DiffUtil.ItemCallback<GGItem.GGUiModel>() {
    override fun areItemsTheSame(oldItem: GGItem.GGUiModel, newItem: GGItem.GGUiModel):
            Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: GGItem.GGUiModel, newItem: GGItem.GGUiModel):
            Boolean = oldItem == newItem

    override fun getChangePayload(oldItem: GGItem.GGUiModel, newItem: GGItem.GGUiModel): Any? {
        val bundle = Bundle()

        if (oldItem.character != newItem.character) bundle.putString(CHARACTER, newItem.character)

        if (oldItem.quote != newItem.quote) bundle.putString(QUOTE, newItem.quote)

        if (oldItem.isFav != newItem.isFav) bundle.putBoolean(FAV, newItem.isFav)

        return if (!bundle.isEmpty) bundle else null
    }
})

{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            GossipGirlItem = GossipGirlItem(
        binding = CardGgBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false), glide = glide, lsner = lsner)

    override fun onBindViewHolder(holder: GossipGirlItem, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onBindViewHolder(holder: GossipGirlItem, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        }
        else {
            holder.update(payloads.last() as Bundle)
        }
    }

    companion object {
        const val CHARACTER = "character"
        const val QUOTE = "quote"
        const val FAV = "fav"
    }
}