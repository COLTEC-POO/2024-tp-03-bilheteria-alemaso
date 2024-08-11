package Ingresso;

import java.util.*;

public abstract class Ingresso {
    protected Date dataVenda;
    protected double valor;

    public Ingresso(Date data) {
        this.dataVenda = data;
        this.valor = valor;
    }

    abstract protected int calculaMaximo();
}
