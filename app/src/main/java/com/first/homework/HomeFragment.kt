package com.first.homework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.first.homework.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)
        parentFragmentManager.popBackStack()

        binding?.myButton?.setOnClickListener {
            showDialog()
        }

        binding?.button1?.setOnClickListener {
            showSheet()
        }
    }

    private fun showDialog() {
        ConfirmationDialog().show(parentFragmentManager, "confirmationDialog")
    }

    private fun showSheet() {
        val bSheet = BottomSheetDialog(requireContext())
        with(bSheet) {
            setTitle("Welcome!")
            setContentView(R.layout.bottomsheet)
            show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        const val TAG = "HomeFragment"
        const val ARG_KEY = "ARG_KEY"

        fun newInstance(arg: String) = HomeFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_KEY, arg)
            }
        }
    }
}