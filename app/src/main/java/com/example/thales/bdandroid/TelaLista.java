package com.example.thales.bdandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TelaLista extends AppCompatActivity {

    //Atributos da classe
    ArrayList<Carro> carros;

    //Método que vai ser chamado apenas uma vez
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_lista);

        //Iniciando a tela apenas comos atributos da tela com os dados salvos
        ListView listCarros = findViewById(R.id.listView);
        GerenciadorBanco gerenciadorBanco = new GerenciadorBanco(this);
        carros = gerenciadorBanco.listaCarros();
        CarroAdapter adapter = new CarroAdapter(carros, this);
        listCarros.setAdapter(adapter);
    }
}
