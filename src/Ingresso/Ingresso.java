package Ingresso;

import java.util.*;

public abstract class Ingresso implements Receita{
    protected Date dataVenda;
    protected double preco;

    public Ingresso(Date data, Double preco) {
        this.dataVenda = data;
        this.preco = preco;
    }
}
