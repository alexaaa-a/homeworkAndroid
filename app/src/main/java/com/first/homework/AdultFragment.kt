package com.first.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.first.homework.databinding.FragmentAdultBinding


class AdultFragment : Fragment() {

    private var binding: FragmentAdultBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_adult, container, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}