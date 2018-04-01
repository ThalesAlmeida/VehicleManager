package com.example.thales.bdandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ResultadoPesquisa extends AppCompatActivity {

    //Método que vai ser chamado apenas uma vez
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_pesquisa);

        //Passando os parâmetros da tela de pesquisa
        Bundle bundle = getIntent().getExtras();
        String ano = bundle.getString("ano");
        String placa = bundle.getString("placa");
        String montadora = bundle.getString("montadora");

        //Chamando o método para pesquisar no banco de dados, passando como parãmetros, a placa, ano e a montadora
        GerenciadorBanco gerenciadorBanco = new GerenciadorBanco(getBaseContext());
        ArrayList<Carro> resultados = (ArrayList<Carro>) gerenciadorBanco.findByPlacaOrAnoOrMontadora(placa, ano, montadora);

        //Instanciando o Adapter
        CarroAdapter carroAdapter = new CarroAdapter(resultados, this);

        //Setando o adapter
        ListView listCarros = findViewById(R.id.listViewResultado);

        listCarros.setAdapter(carroAdapter);
    }


}
