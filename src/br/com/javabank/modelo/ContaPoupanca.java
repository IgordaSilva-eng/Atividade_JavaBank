package br.com.javabank.modelo;

import br.com.javabank.interfaces.Exportavel;
import br.com.javabank.interfaces.Movimentavel;
import br.com.javabank.interfaces.Rendavel;

public class ContaPoupanca extends Conta
        implements Movimentavel, Rendavel, Exportavel {

    private double taxaRendimento;

    public ContaPoupanca(String numero, String agencia, String titular, double saldoInicial, double taxa) {
        super(numero, agencia, titular, saldoInicial);
        this.taxaRendimento = taxa;
    }

    @Override
    public void aplicarRendimento() {
        saldo += (saldo * taxaRendimento);
    }

    @Override
    public double getTaxaRendimento() { return taxaRendimento; }

    @Override
    public void depositar(double valor) { saldo += valor; }

    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public void mostrarExtrato() { historico.forEach(System.out::println); }

    @Override
    public void mostrarResumo() { exibirDetalhes(); }

    @Override
    public String getTipo() { return "Conta Poupança"; }

    @Override
    public void exibirDetalhes() { System.out.println(getTipo() + " - Saldo: " + saldo); }
}