package Evento.Tipos;

import Evento.*;
import java.util.*;
public class Concerto extends Evento{

    public Concerto(String nome, Date data, String local, double preco) {
        super(nome, data, local, preco);
        this.qtdIngressos = 150;
        maxIngressos[2] = 15;
    }

    @Override
    public String toString() {
        String s =
                "Concerto " + nome + "\n" +
                "Data: " + data + "\n" +
                "Local: " + local + "\n" +
                "Preço do ingresso: R$" + preco;
        return s;
    }

    @Override
    public double calculaReceita() {
        double total = 0;
        for (int i = 0; i < totalIngressosVendidos; i++){
            if (ingressos[i] !=null) total += ingressos[i].calculaReceita();
        }
        return total;
    }

    @Override
    public String exibeExtrato() {
        String s = "Concerto " + nome + "\n" +
                "Total de ingressos vendidos: " + totalIngressosVendidos + "\n" +
                "Receita total gerada: R$" + calculaReceita() + "\n";
        return s;
    }
}
