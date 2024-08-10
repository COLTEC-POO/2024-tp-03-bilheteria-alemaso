package Evento.Tipos;

import Evento.*;

public class Concerto extends Evento{

    public Concerto(String nome, int[] data, String local, double preco) {
        super(nome, data, local, preco);
        this.qtdIngressos = 150;
    }
    
}
