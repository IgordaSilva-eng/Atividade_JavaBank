package br.com.javabank.modelo;

import java.util.ArrayList;

public abstract class Conta {
    protected String numero;
    protected String agencia;
    protected String titular;
    protected double saldo;
    protected ArrayList<String> historico;

    public Conta(String numero, String agencia, String titular, double saldoInicial) {
        this.numero = numero;
        this.agencia = agencia;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.historico = new ArrayList<>();

        registrarHistorico("Conta aberta com saldo inicial de R$ " +
                String.format("%.2f", saldoInicial));
    }

    /**
     * Método abstrato para retornar o nome amigável do tipo de conta.
     */

    protected void registrarHistorico(String descricao) {
        historico.add(descricao);
    }

    public abstract String getTipo();

    public abstract void exibirDetalhes();

    public String getNumero() {
        return numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}