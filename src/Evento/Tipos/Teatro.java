package Evento.Tipos;

import Evento.*;

public class Teatro extends Evento{

    public Teatro(String nome, int[] data, String local, double preco) {
        super(nome, data, local, preco);
        this.qtdIngressos = 250;
    }
    
}
