package com.example.configuracao.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.configuracao.R


class TelasDoisFragment : Fragment() {

     val args: TelasDoisFragmentArgs  by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_telas_dois, container, false)


        val textView =view.findViewById<TextView>(R.id.text_tela_dois)

        textView.text = args.texto

        return view
    }
}