package com.first.homework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.first.homework.GossipGirlRepository.GGUI
import com.first.homework.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private var binding: ActivityHomeBinding? = null
    private var adapter: GossipGirlListAdapter?  = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        binding = ActivityHomeBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        adapter = GossipGirlListAdapter(glide = Glide.with(this)){
            onClickGG(it)
        }

        binding.let {

            it?.gossipgirl?.adapter = adapter

            it?.swipe?.setOnRefreshListener {
                refresh()
            }

            adapter?.submitList(GGUI) {
                it?.gossipgirl?.scrollToPosition(0)
            }

        }

        binding?.gossipgirl?.apply {

            addItemDecoration(DividerItemDecoration(this@HomeActivity, RecyclerView.VERTICAL))

            layoutManager = LinearLayoutManager(this@HomeActivity)
        }

    }

    private fun refresh() {
        binding?.swipe?.isRefreshing = false
    }

    fun onClickGG(gossipGirl: GGItem.GGUiModel) {
        val idx = GossipGirlRepository.gossipG.indexOfFirst { it.id == gossipGirl.id }
        val gg_idx = GossipGirlRepository.gossipG[idx]
        val GG = gg_idx.copy(
            isFav = !gg_idx.isFav
        )

        GossipGirlRepository.gossipG.removeAt(idx)
        GossipGirlRepository.gossipG.add(idx, GG)

        adapter?.submitList(GGUI)
    }


}