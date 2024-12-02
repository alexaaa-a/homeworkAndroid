package com.first.homework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.first.homework.GossipGirlRepository.gossipG
import com.first.homework.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private var binding: ActivityHomeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        binding = ActivityHomeBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        binding.let {

            it?.swipe?.setOnRefreshListener {
                refresh()
            }

            it?.gossipgirl?.adapter = GossipGirlAdapter(
                list = gossipG,
                glide = Glide.with(this)
            ) { gossipG ->
                it?.root?.show("${gossipG.character}: ${gossipG.quote}")
            }

        }

        binding?.gossipgirl?.apply {
            addItemDecoration(Decorator(this@HomeActivity, 10f))

            addItemDecoration(DividerItemDecoration(this@HomeActivity, RecyclerView.VERTICAL))

            layoutManager = LinearLayoutManager(this@HomeActivity)
        }



    }

    private fun refresh() {
        binding?.swipe?.isRefreshing = false
    }


}