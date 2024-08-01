package Evento.Tipos;

import Evento.*;

public class Filme extends Evento{

    public Filme(String nome, int[] data, String local, double preco) {
        super(nome, data, local, preco);
        this.qtdIngressos = 200;
    }
    
}
