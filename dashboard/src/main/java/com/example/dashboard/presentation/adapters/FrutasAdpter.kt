package com.example.dashboard.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.dashboard.R
import com.example.dashboard.domain.model.FrutaEntity
import kotlinx.android.synthetic.main.fruta_item.view.*

class FrutasAdpter(val frutaList: ArrayList<FrutaEntity>, private val listener: OnItemClickListner) :
    RecyclerView.Adapter<FrutasAdpter.FrutaViewHolder>() {

    private lateinit var view: View

    inner class FrutaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var btn: Button = view.btnDelete

        init {
            btn.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position)
                }
            }
        }

        fun bind(fruta: FrutaEntity) {
            itemView.txt_fruta_nome.text = fruta.nome
        }
    }

    interface OnItemClickListner {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FrutaViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.fruta_item, parent, false)
        return FrutaViewHolder(view)
    }

    override fun onBindViewHolder(holder: FrutaViewHolder, position: Int) {
        holder.bind(frutaList[position])
    }

    override fun getItemCount(): Int = frutaList.size


}

