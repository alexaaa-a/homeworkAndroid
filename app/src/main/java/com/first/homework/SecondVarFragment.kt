package com.first.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import com.first.homework.databinding.FragmentSecondVarBinding


class SecondVarFragment : Fragment() {

    private var binding: FragmentSecondVarBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second_var, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSecondVarBinding.bind(view)

        val navController = findNavController(view)

        binding?.btnSecret?.setOnClickListener {
            navController.navigate(R.id.action_secondVarFragment_to_secretFragment)
        }
    }

}