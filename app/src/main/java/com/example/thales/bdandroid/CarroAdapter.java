package com.example.thales.bdandroid;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thales on 16/11/2017.
 */

//Classe responsavel por colocar na tela os dados e passar para a Visualização
public class CarroAdapter extends ArrayAdapter<Carro> {

    GerenciadorBanco gerenciadorBanco = new GerenciadorBanco(getContext());

    //Atributos da classe
    private ArrayList<Carro> carros;
    private Activity activity;

    //Construtor da classe
    public CarroAdapter(ArrayList<Carro> carros, Activity activity) {
        super(activity, 0, carros);
        this.carros = carros;
        this.activity = activity;
    }

    //Métodos obrigatoriamente implementados por ser uma interface
    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public Carro getItem(int position) {
        return carros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        //Reciclando a visualização
        if(view == null){
            view = this.activity.getLayoutInflater().inflate(R.layout.visualizacao, null);

            //Pegando cada posição do carro
            final Carro carro = carros.get(position);

            //Inicializando os atributos da classe carro, para serem colocadas de acordo com o que for digitado pelo usuário
            TextView nome = view.findViewById(R.id.txtNome);
            nome.setText(carro.getNome());

            TextView placa = view.findViewById(R.id.txtPlaca);
            placa.setText(carro.getPlaca());

            TextView ano = view.findViewById(R.id.txtAno);
            ano.setText(carro.getAno());

            TextView montadora = view.findViewById(R.id.txtMontadora);
            montadora.setText(carro.getMontadora());

            TextView transmissao = view.findViewById(R.id.txtTransmissao);
            transmissao.setText(carro.getTransmissao());

            Button buttonDelete = view.findViewById(R.id.buttonDelete);

            buttonDelete.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    gerenciadorBanco.removeCarro(carro);
                    carros.remove(position);
                    notifyDataSetChanged();
                }
            });

        }
        //Me retornando a lista de visualização
        return view;
    }
}
