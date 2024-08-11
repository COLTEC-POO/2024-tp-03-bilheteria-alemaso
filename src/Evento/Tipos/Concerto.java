package Evento.Tipos;

import Evento.*;
import java.util.*;

public class Concerto extends Evento{

    public Concerto(String nome, Date data, String local, float preco) {
        super(nome, data, local, preco);
        this.qtdIngressos = 100;
        this.qtdIngressos_VIP = 15;
        this.qtdMeia_Entrada = 35;
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
