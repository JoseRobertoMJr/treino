package com.example.configuracao.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.example.configuracao.R


class ConfiguracaoFragment : Fragment() {

    val args: ConfiguracaoFragmentArgs  by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_configuracao, container, false)

        val textView =view.findViewById<TextView>(R.id.text_home)

        textView.text = args.texto

        val btn = view.findViewById<Button>(R.id.btn_configuracao)

        val controller = NavHostFragment.findNavController(this)

        val action = ConfiguracaoFragmentDirections.configurationToTelaDois()
        btn.setOnClickListener {
            controller.navigate(action)
        }


        return view
    }
}