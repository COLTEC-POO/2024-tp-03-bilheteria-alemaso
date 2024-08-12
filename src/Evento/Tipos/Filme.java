package Evento.Tipos;

import Evento.*;
import java.util.*;
public class Filme extends Evento{

    public Filme(String nome, Date data, String local, double preco) {
        super(nome,  data, local, preco);
        this.qtdIngressos = 200;
        maxIngressos[2] = 0;
    }

    @Override
    public String toString() {
        String s =
                "Filme " + nome + "\n" +
                "Data: " + data + "\n" +
                "Local: " + local + "\n" +
                "Preço do ingresso: R$" + preco;
        return s;
    }

    @Override
    public double calculaReceita() {
        double total = 0;
        for (int i = 0; i < totalIngressosVendidos; i++){
            total += ingressos[i].calculaReceita();
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
