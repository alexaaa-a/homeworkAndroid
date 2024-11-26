package com.first.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.first.homework.databinding.FragmentKidBinding


class KidFragment : Fragment() {

    private var binding: FragmentKidBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_kid, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}