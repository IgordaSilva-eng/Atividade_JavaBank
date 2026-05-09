package br.com.javabank.interfaces;

import br.com.javabank.modelo.Conta;

public interface Transferivel {
    boolean transferir(double valor, Conta destino);
}