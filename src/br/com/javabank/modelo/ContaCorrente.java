package br.com.javabank.modelo;

import br.com.javabank.interfaces.Exportavel;
import br.com.javabank.interfaces.Movimentavel;
import br.com.javabank.interfaces.Transferivel;
import br.com.javabank.interfaces.Tributavel;

public class ContaCorrente extends Conta
        implements Movimentavel, Transferivel,
        Tributavel, Exportavel {

    private double limiteCredito;
    private double tarifaMensal;

    public ContaCorrente(String numero, String agencia, String titular,
                         double saldoInicial, double limiteCredito, double tarifaMensal) {
        super(numero, agencia, titular, saldoInicial);
        this.limiteCredito = limiteCredito;
        this.tarifaMensal = tarifaMensal;
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            registrarHistorico("Depósito: R$ " + String.format("%.2f", valor));
        }
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= (saldo + limiteCredito)) {
            saldo -= valor;
            registrarHistorico("Saque: R$ " + String.format("%.2f", valor));
            return true;
        }
        return false;
    }

    @Override
    public boolean transferir(double valor, Conta destino) {
        if (this.sacar(valor)) {
            destino.saldo += valor;
            this.registrarHistorico("Transferência enviada para " + destino.getNumero());
            destino.registrarHistorico("Transferência recebida de " + this.numero);
            return true;
        }
        return false;
    }

    @Override
    public double calcularImposto() {
        return saldo * 0.0038;
    }

    @Override
    public void cobrarTarifa() {
        saldo -= tarifaMensal;
        registrarHistorico("Tarifa mensal: R$ " + tarifaMensal);
    }

    @Override
    public void mostrarExtrato() {
        System.out.println("--- EXTRATO CONTA CORRENTE ---");
        historico.forEach(System.out::println);
        System.out.println("Saldo: R$ " + saldo);
    }

    @Override
    public void mostrarResumo() {
        exibirDetalhes();
    }

    @Override
    public String getTipo() { return "Conta Corrente"; }

    @Override
    public void exibirDetalhes() {
        System.out.println("[" + getTipo() + "] Titular: " + titular + " | Saldo: " + saldo);
    }
}