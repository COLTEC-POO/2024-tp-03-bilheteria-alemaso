package Ingresso;

import java.time.LocalDate;

public abstract class Ingresso {
    protected LocalDate dataVenda;
    protected double preco;
    
    public Ingresso(LocalDate data, double preco){
        this.dataVenda = data;
        this.preco = preco;
    }
}
