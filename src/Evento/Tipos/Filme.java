package Evento.Tipos;

import Evento.*;

public class Filme extends Evento{

    public Filme(String nome, int[] data, String local, double preco) {
        super(nome, data, local, preco);
        this.qtdIngressos = 200;
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
}
