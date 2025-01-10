package com.example.projeto_13.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_13.R
import com.example.projeto_13.model.Carro

class CarroListAdapter(val listaCarros: ArrayList<Carro>,val onClickListener: OnClieckListener):
    RecyclerView.Adapter<CarroListAdapter.CarroViewHolder>() {

        var contadorOnCreate = 0
        var contadorOnBind = 0

    class CarroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text_modelo)
    }

    class OnClieckListener(val clickListener: (carro: Carro) -> Unit) {
        fun onClick(carro: Carro) = clickListener(carro)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarroViewHolder {

        contadorOnCreate++
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_carro_list, parent, false)

        return CarroViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaCarros.size
    }

    override fun onBindViewHolder(holder: CarroViewHolder, position: Int) {

        contadorOnBind++
        val carro = listaCarros[position]
        holder.textView.setText(carro.modelo)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(carro)
        }

    }
}