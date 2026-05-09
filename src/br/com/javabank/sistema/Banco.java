package br.com.javabank.sistema;

import br.com.javabank.modelo.Conta;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    /**
     * Adiciona uma conta ao sistema do banco.
     * Aceita qualquer subclasse de Conta (Corrente, Poupanca, Investimento).
     */
    public void abrirConta(Conta conta) {
        if (conta != null) {
            this.contas.add(conta);
            System.out.println("✅ " + conta.getTipo() + " de " + conta.getTitular() + " aberta com sucesso!");
        }
    }

    /**
     * Lista todas as contas cadastradas no banco utilizando o polimorfismo.
     */
    public void listarContas() {
        System.out.println("\n=== RELATÓRIO DE CONTAS - " + nome.toUpperCase() + " ===");
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
        } else {
            for (Conta c : contas) {
                // Chama o exibirDetalhes implementado em cada tipo de conta específico
                c.exibirDetalhes();
            }
        }
    }

    /**
     * Busca uma conta específica pelo número.
     */
    public Conta buscarConta(String numero) {
        for (Conta c : contas) {
            if (c.getNumero().equals(numero)) {
                return c;
            }
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return contas;
    }
}