package com.example.projeto_13.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projeto_13.adapter.CarroListAdapter
import com.example.projeto_13.data.CarroMock
import com.example.projeto_13.databinding.ActivityMainBinding
import com.example.projeto_13.model.Carro

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CarroListAdapter
    private lateinit var mock:CarroMock
    private var pos = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        mock = CarroMock()
        binding.recyclerView.adapter =
            CarroListAdapter(mock.listaCarros, CarroListAdapter.OnClieckListener {
                //  Toast.makeText(this, it.modelo, Toast.LENGTH_SHORT).show()
                pos = pequisaPosicao()

                binding.editModelo.setText(mock.listaCarros[pos].modelo)
            })
        binding.recyclerView.adapter = adapter

        binding.buttonInserir.setOnClickListener {
            val modelo = binding.editModelo.text.toString().toInt()
            mock.listaCarros.add(Carro(modelo, modelo.toString()))

            adapter.notifyDataSetChanged()

        }

        binding.buttonEditar.setOnClickListener {
            if (pos >= 0) {
                val modelo = binding.editModelo.text.toString()
                mock.listaCarros[pos].modelo = modelo
                mock.listaCarros[pos].id = modelo.toInt()

                pos = -1

                adapter.notifyDataSetChanged()
            }
        }
        binding.buttonRemover.setOnClickListener {
            if (pos >= 0) {
                mock.listaCarros.removeAt(pos)
                pos = -1
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun pequisaPosicao(): Int {
        for (i in 0 .. mock.listaCarros.size){
            if(mock.listaCarros[i].id == binding.editModelo.text.toString().toInt()){
                return 1
            }
        }
        return -1
    }
}

