package com.example.thales.bdandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by thales on 16/11/2017.
 */

//Classe responsável por gerenciar todo o meu banco de dados SQLITE
public class GerenciadorBanco extends SQLiteOpenHelper {
    static final String name = "bd";
    static final int version = 6;


    //Script de criação do banco de dados, da tabela carro
    String[]scriptCriaBanco = {"create table carro(_id integer primary key autoincrement, nome text not null, placa text not null, ano text not null, montadora text not null, transmissao text not null)"};

    //String final de verificação se existe alguma tabela com o mesmo nome
    public final String scriptApagaBD = "DROP TABLE IF EXISTS carro";


    //Construtor da classe
    public GerenciadorBanco(Context context) {
        super(context, name, null, version);
        //vrContexto = this.context;

    }
    //Método onCreate onde será executado apenas uma vez
    @Override
    public void onCreate(SQLiteDatabase db) {
        for(int iIndex=0; iIndex<scriptCriaBanco.length; iIndex++){
            db.execSQL(scriptCriaBanco[iIndex]);
        }

    }

    //Método inserirCarro, onde vão irão ser inseridas todas as características do carro
    public void inserirCarro(Carro carro){
        int id = carro.id;
        SQLiteDatabase db = getWritableDatabase();
        try{
            ContentValues values = new ContentValues();
            values.put("nome", carro.getNome());
            values.put("placa", carro.getPlaca());
            values.put("ano", carro.getAno());
            values.put("montadora", carro.getMontadora());
            values.put("transmissao", carro.getTransmissao());
            db.insert("carro", null, values);
        }catch (Exception e){

        }
    }

    //Atualização do banco de dados
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(scriptApagaBD);

        for (String sql: scriptCriaBanco){
            db.execSQL(sql);
        }
    }

    //Remoção do banco de dados
    public void removeCarro(Carro carro) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("carro", "nome=?", new String[]{carro.getNome()});

    }

    //Método para listar por placa, passando por parâmetro a placa do carro ..  método não utilizado
    public List<Carro>findAllByPlaca(String placa){
        SQLiteDatabase db = getReadableDatabase();
        try{
            Cursor c = db.query("carro", null, "placa = '" + placa+"'", null, null, null,null);
            return toList(c);
        }finally {
            db.close();
        }
    }

    //Método para listar por ano, passando por parâmetro o ano do carro .. método não utilizado
    public List<Carro>findAllByAno(String ano){
        SQLiteDatabase db = getReadableDatabase();
        try{
            Cursor c = db.query("carro", null, "ano = '" + ano+"'", null, null, null,null);
            return toList(c);
        }finally {
            db.close();
        }
    }

    /*Método para listar os itens pesquisados, seja digitando somente a placa, ano, ou a montadora
    Te retornará um list de resultados daquela pesquisa
     */
    public List<Carro>findByPlacaOrAnoOrMontadora(String placa, String ano, String montadora){
        SQLiteDatabase db = getReadableDatabase();
        try{
            Cursor c = db.query("carro", null, "ano = ? or placa = ? or montadora = ?", new String[]{ano, placa, montadora}, null, null, null,null);
            return toList(c);
        }finally {
            db.close();
        }

    }

    //Método usado para listar todos os atributos dos carros.
    public List<Carro>toList(Cursor c){
        List<Carro> carros = new ArrayList<Carro>();
        if (c.moveToFirst()){
            do{
                Carro carro = new Carro();
                carros.add(carro);
                //Recupera os atributos do carro
                carro.setNome(c.getString(1));
                carro.setPlaca(c.getString(2));
                carro.setAno(c.getString(3));
                carro.setMontadora(c.getString(4));
                carro.setTransmissao(c.getString(5));

            }while(c.moveToNext());
        }
        return carros;
    }

    //Método para buscar todos os carros no banco de dados e me retornar uma lista
    public ArrayList<Carro> listaCarros(){
        ArrayList<Carro> lista = new ArrayList<Carro>();
        SQLiteDatabase bancoDados = this.getReadableDatabase();
        Cursor cursor = bancoDados.query("carro", new String[]{"nome", "placa", "ano", "montadora", "transmissao"}, null, null, null, null, null);

        while(cursor.moveToNext()){
            Carro carro = new Carro();
            carro.setNome(cursor.getString(0));
            carro.setPlaca(cursor.getString(1));
            carro.setAno(cursor.getString(2));
            carro.setMontadora(cursor.getString(3));
            carro.setTransmissao(cursor.getString(4));
            lista.add(carro);
        }
        return lista;
    }
}
