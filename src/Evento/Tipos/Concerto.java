package Evento.Tipos;

import Evento.*;

public class Concerto extends Evento{

    public Concerto(String nome, int[] data, String local, double preco) {
        super(nome, data, local, preco);
        this.qtdIngressos = 150;
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
}
