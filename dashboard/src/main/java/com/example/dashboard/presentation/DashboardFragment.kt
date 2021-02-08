package com.example.dashboard.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.NavHostFragment
import com.example.dashboard.R


class DashboardFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

       val controller = NavHostFragment.findNavController(this)

        val btn = view.findViewById<Button>(R.id.btn_dashboard)

        val action = DashboardFragmentDirections.dashboardToTelaDois()
        btn.setOnClickListener {
            controller.navigate(action)
        }

        return view

    }


}