package Evento.Tipos;

import Evento.*;

public class Teatro extends Evento{

    public Teatro(String nome, int[] data, String local, double preco) {
        super(nome, data, local, preco);
        this.qtdIngressos = 250;
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
}
