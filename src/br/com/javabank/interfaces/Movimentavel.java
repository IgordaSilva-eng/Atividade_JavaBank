package br.com.javabank.interfaces;

public interface Movimentavel {
    void depositar(double valor);
    boolean sacar(double valor);
    double getSaldo();
}