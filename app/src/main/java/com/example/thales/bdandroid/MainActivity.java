package com.example.thales.bdandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Atributos da classe principal
    EditText nome;
    EditText placa;
    EditText ano;
    EditText montadora;
    EditText transmissao;
    Button buttonSave;
    Button view;

    //Botão excluir da tela de visualização
    Button buttonExcluir;

    @Override
    //Método chamado apenas uma vez
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);

        //Encontrado os atributos da tela de cadastro
        nome = findViewById(R.id.nome);
        placa = findViewById(R.id.placa);
        ano = findViewById(R.id.ano);
        montadora = findViewById(R.id.montadora);
        transmissao = findViewById(R.id.transmissao);
        buttonExcluir = findViewById(R.id.buttonDelete);
        buttonSave = findViewById(R.id.buttonSave);
        view = findViewById(R.id.view);

    }

    //Método me passando como parâmetro uma view, estou chamando no botão de salvar
    public void inserirBancoBd(View view){

        Carro carro = new Carro();

        carro.setNome(nome.getText().toString());
        carro.setPlaca(placa.getText().toString());
        carro.setAno(ano.getText().toString());
        carro.setMontadora(montadora.getText().toString());
        carro.setTransmissao(transmissao.getText().toString());

        GerenciadorBanco gerenciadorBanco = new GerenciadorBanco(this);
        gerenciadorBanco.inserirCarro(carro);
        menagemInserido();
    }

    //Método para exibir os dados inseridos na tela_lista
    public void exibiLista(View view){
        Intent intent = new Intent(getBaseContext(), TelaLista.class);
        startActivity(intent);
    }

    //Método para ir para a tela de Pesquisa, iniciando uma intenção
    public void goPesquisa(View view){
        Intent intent = new Intent(getBaseContext(), Pesquisa.class);
        startActivity(intent);

    }

    public void exibiTelaCreditos(View view){
        Intent intent = new Intent(getBaseContext(), TelaCreditos.class);
        startActivity(intent);
    }

    //Mensagens para melhor compreensão do usuário
    public void menagemInserido(){
        Toast.makeText(this, "Registros inseridos com sucesso", Toast.LENGTH_SHORT).show();
    }
}
