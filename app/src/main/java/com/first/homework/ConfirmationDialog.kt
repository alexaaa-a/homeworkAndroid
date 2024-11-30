package com.first.homework

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ConfirmationDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val myDialog = AlertDialog.Builder(requireContext())
        myDialog.setMessage("Are you 18 years old?")
            .setPositiveButton("Yes") {_, _ ->
                onPositiveClick()
            }
            .setNegativeButton("No") {_, _ ->
                onNegativeClick()
            }
            .setNeutralButton("Cancel") {_, _ ->
                dialog?.dismiss()
            }
        return myDialog.create()
    }

    private fun onNegativeClick() {
        (activity as? HomeActivity)?.navigateToFragment(KidFragment())
    }

    private fun onPositiveClick() {
        (activity as? HomeActivity)?.navigateToFragment(AdultFragment())
    }
}