package br.com.javabank.modelo;

import br.com.javabank.interfaces.Exportavel;
import br.com.javabank.interfaces.Movimentavel;
import br.com.javabank.interfaces.Rendavel;
import br.com.javabank.interfaces.Tributavel;

public class ContaInvestimento extends Conta
        implements Movimentavel, Rendavel, Tributavel, Exportavel {

    private double taxaRendimento;
    private double aliquotaIR;

    public ContaInvestimento(String numero, String agencia, String titular,
                             double saldoInicial, String tipo, double taxa, double ir) {
        super(numero, agencia, titular, saldoInicial);
        this.taxaRendimento = taxa;
        this.aliquotaIR = ir;
    }

    @Override
    public void aplicarRendimento() {
        double rendimento = saldo * taxaRendimento;
        saldo += rendimento;
        registrarHistorico("Rendimento: R$ " + rendimento);
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
    public double calcularImposto() { return saldo * aliquotaIR; }

    @Override
    public void cobrarTarifa() { /* Não possui */ }

    @Override
    public void mostrarExtrato() { historico.forEach(System.out::println); }

    @Override
    public void mostrarResumo() { exibirDetalhes(); }

    @Override
    public String getTipo() { return "Conta Investimento"; }

    @Override
    public void exibirDetalhes() { System.out.println(getTipo() + " - Saldo: " + saldo); }
}