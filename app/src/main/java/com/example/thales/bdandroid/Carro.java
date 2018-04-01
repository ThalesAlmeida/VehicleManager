package com.example.thales.bdandroid;

/**
 * Created by thales on 16/11/2017.
 */

public class Carro {
    //Atributos da classe Carro, características de um carro ou de uma moto
    int id;
    String nome;
    String placa;
    String ano;
    String montadora;
    String transmissao;

    //Construtor da classe carro
    public Carro(String nome, String placa, String ano, int id, String montadora, String transmissao) {

        this.nome = nome;
        this.placa = placa;
        this.ano = ano;
        this.id = id;
        this.montadora = montadora;
        this.transmissao = transmissao;

    }

    //Construtor vazio da classe carro
    public Carro() {

    }

    //Métodos Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public String getTransmissao() {
        return transmissao;
    }

    public void setTransmissao(String transmissao) {
        this.transmissao = transmissao;
    }

}
