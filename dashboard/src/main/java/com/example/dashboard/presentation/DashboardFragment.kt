package com.example.dashboard.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dashboard.R
import com.example.dashboard.presedntation.Fruta
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import kotlinx.android.synthetic.main.fragment_tela_dois_dashboard.*
import kotlinx.android.synthetic.main.fragment_tela_dois_dashboard.view.*
import kotlinx.android.synthetic.main.fruta_item.view.*


class DashboardFragment : Fragment(), FrutasAdpter.OnItemClickListner {


    val listFruta: ArrayList<Fruta> = ArrayList()
    lateinit var viewDashboard: View
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDashboard = inflater.inflate(R.layout.fragment_dashboard, container, false)

        recyclerView = viewDashboard.findViewById<RecyclerView>(R.id.recycler_view_frutas)!!


        val list = mutableListOf(
            Fruta(),
            Fruta("1"),
            Fruta("2"),
            Fruta("3"),
            Fruta("4"),
            Fruta("5"),
            Fruta("6"),
            Fruta("7"),
            Fruta("8"),
            Fruta("9")

        )

        listFruta.addAll(list)

        recyclerView.adapter = FrutasAdpter(
            listFruta, this
        )


        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        btnAddFruta()
        return viewDashboard

    }


    private fun btnAddFruta() {
        viewDashboard.btnAdicionar.setOnClickListener {
            listFruta.add(Fruta(viewDashboard.input_text_fruta.text.toString()))
            recyclerView.adapter?.notifyItemInserted(listFruta.indexOf(listFruta.last()))
            viewDashboard.input_text_fruta.text?.clear()
        }
    }


    override fun onItemClick(position: Int) {
        Toast.makeText(context, "position $position", Toast.LENGTH_LONG).show()
        listFruta.removeAt(position)
        recyclerView.adapter?.notifyItemRemoved(position)


    }


}