package Evento.Tipos;

import Evento.*;
import java.util.*;
public class Teatro extends Evento{

    public Teatro(String nome, Date data, String local, float preco) {
        super(nome, data, local, preco);
        this.qtdIngressos = 175;
        this.qtdIngressos_VIP = 25;
        this.qtdMeia_Entrada = 50;

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
