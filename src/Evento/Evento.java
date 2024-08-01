package Evento;

import java.time.*;

public abstract class Evento {
    protected String nome;
    protected LocalDateTime data; //LocalDate.of() //data, hora
    protected String local;
    protected double preco;
    protected int qtdIngressos;

    public Evento(String nome, int[] data, String local, double preco) { 
        this.nome = nome;
        this.data = LocalDateTime.of(data[2], data[1], data[0], data[3], data[4]); // [DD,MM,AA,hh,mm]
        this.local = local; 
        this.preco = preco;
    }

    

}
