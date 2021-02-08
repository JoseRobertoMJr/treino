package com.example.dashboard.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.dashboard.R


class TelaDoisDashboardFragment : Fragment() {

    val args: TelaDoisDashboardFragmentArgs  by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_tela_dois_dashboard, container, false)

        val textView =view.findViewById<TextView>(R.id.text_tela_dois)

        textView.text = args.texto

        return view
    }


}