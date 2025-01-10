package com.example.projeto_13.data

import com.example.projeto_13.model.Carro

class CarroMock {
    var listaCarros = ArrayList<Carro>()
    init{
        for(i in 0..10){
            listaCarros.add(Carro(i, i.toString()))
        }
    }
}