package Evento.Tipos;

import Evento.*;
import java.util.*;

public class Filme extends Evento{

    public Filme(String nome, Date data, String local, float preco) {
        super(nome, data, local, preco);
        this.qtdIngressos = 150;
        this.qtdMeia_Entrada = 50;
        this.qtdIngressos_VIP = 0;
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
