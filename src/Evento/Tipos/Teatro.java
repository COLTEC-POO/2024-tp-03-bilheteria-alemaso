package Evento.Tipos;

import Evento.*;
import Ingresso.Ingresso;
import java.util.*;
public class Teatro extends Evento{

    public Teatro(String nome, Date data, String local, double preco) {
        super(nome, data, local, preco);
        this.qtdIngressos = 250;
        this.ingressos = new Ingresso[qtdIngressos];
        maxIngressos[1] = 50;
    }

    @Override
    public String toString() {
        String s =
                "Teatro " + nome + "\n" +
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
        String s = "Teatro " + nome + "\n" +
                "Total de ingressos vendidos: " + totalIngressosVendidos + "\n" +
                "Receita total gerada: R$" + calculaReceita() + "\n";
        return s;
    }
}
