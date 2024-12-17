package com.first.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import com.first.homework.databinding.FragmentChooseBinding

class ChooseFragment : Fragment() {

    private var binding: FragmentChooseBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choose, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentChooseBinding.bind(view)

        val navController = findNavController(view)

        binding?.btnCutie?.setOnClickListener {
            navController.navigate(R.id.action_chooseFragment_to_firstVarFragment)
        }

        binding?.btnChill?.setOnClickListener {
            navController.navigate(R.id.action_chooseFragment_to_secondVarFragment)
        }

        binding?.btnAngry?.setOnClickListener {
            navController.navigate(R.id.action_chooseFragment_to_thirdVarFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
