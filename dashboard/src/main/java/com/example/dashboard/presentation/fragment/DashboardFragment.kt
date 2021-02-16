package com.example.dashboard.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.presentation.viewModel.ViewStates
import com.example.dashboard.databinding.FragmentDashboardBinding
import com.example.dashboard.domain.model.FrutaEntity
import com.example.dashboard.presentation.adapters.FrutasAdpter
import com.example.dashboard.presentation.viewmodel.DashboardFragmentViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import kotlinx.android.synthetic.main.fragment_tela_dois_dashboard.*
import kotlinx.android.synthetic.main.fragment_tela_dois_dashboard.view.*
import kotlinx.android.synthetic.main.fruta_item.view.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class DashboardFragment : Fragment(), FrutasAdpter.OnItemClickListner {


    val listFruta: ArrayList<FrutaEntity> = ArrayList()
    private lateinit var binding: FragmentDashboardBinding
    private val viewModel: DashboardFragmentViewModel by sharedViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)

        binding.recyclerViewFrutas.layoutManager = LinearLayoutManager(requireContext())


        observeListaFruta();
        viewModel.getListaFrutas()

        btnAddFruta()
        return binding.root

    }

    private fun observeListaFruta() {
        viewModel.viewStates.observe(viewLifecycleOwner, Observer { retorno ->
            when (retorno) {

                is ViewStates.Sucesso<*> -> {
                    listFruta.addAll((retorno.list as List<FrutaEntity>))

                    binding.recyclerViewFrutas.adapter = FrutasAdpter(
                        listFruta, this
                    )
                }

                is ViewStates.Error -> {
                    this.context?.let {
                        Toast.makeText(
                            this.context,
                            "erro ao listar frutas",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        })
    }


    private fun btnAddFruta() {
        binding.btnAdicionar.setOnClickListener {
            val frutaEntity = FrutaEntity(null, binding.inputTextFruta.text.toString())

            listFruta.add(frutaEntity)
            viewModel.insertFruta(frutaEntity)

            binding.recyclerViewFrutas.adapter?.notifyItemInserted(listFruta.indexOf(listFruta.last()))
            binding.recyclerViewFrutas.input_text_fruta.text?.clear()
        }
    }


    override fun onItemClick(position: Int) {
        Toast.makeText(context, "position $position", Toast.LENGTH_LONG).show()
        listFruta.removeAt(position)
        binding.recyclerViewFrutas.adapter?.notifyItemRemoved(position)

    }

}