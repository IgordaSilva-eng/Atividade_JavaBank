package br.com.javabank.principal;

import br.com.javabank.interfaces.*;
import br.com.javabank.modelo.*;
import java.util.ArrayList;

public class JavaBank {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente("1001", "001", "Ana", 0, 1000, 10);
        ContaPoupanca cp = new ContaPoupanca("2001", "001", "Carlos", 0, 0.005);
        ContaInvestimento ci = new ContaInvestimento("3001", "001", "Ana", 0, "CDB", 0.01, 0.15);

        cc.depositar(1000);
        cc.transferir(200, cp);

        ArrayList<Exportavel> lista = new ArrayList<>();
        lista.add(cc);
        lista.add(cp);
        lista.add(ci);

        for (Exportavel e : lista) {
            e.mostrarResumo();
        }
    }
}