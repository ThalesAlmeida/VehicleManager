package com.example.thales.bdandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

//Classe responsável por pegar todos os campos digitados na tela_pesquisa
public class Pesquisa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);
    }

    //Método para passar os dados para a tela de ResultadoPesquisa
    public void mostraResultadosPesquisa(View view){

        //Campos a serem digitados na tela Pesquisa
        EditText placa;
        EditText ano;
        EditText montadora;

        //Uma intenção para a tela de ResultadoPesquisa
        Intent intent = new Intent(getBaseContext(), ResultadoPesquisa.class);
        placa = findViewById(R.id.pesquisaPlaca);
        ano = findViewById(R.id.pesquisaAno);
        montadora = findViewById(R.id.pesquisaMontadora);

        //Bundle passando os dados
        Bundle bundle = new Bundle();
        bundle.putString("placa", placa.getText().toString());
        bundle.putString("ano", ano.getText().toString());
        bundle.putString("montadora", montadora.getText().toString());
        intent.putExtras(bundle);

        //Iniciando a Tela
        startActivity(intent);
    }
}
