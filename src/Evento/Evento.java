package Evento;


import java.util.*;

public abstract class Evento {
    protected String nome;
    protected Date data; //LocalDate.of() //data, hora
    protected String local;
    protected float preco;
    protected int qtdIngressos;
    protected int qtdIngressos_VIP;
    protected int qtdMeia_Entrada;
    public Evento(String nome, Date data, String local, float preco) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public abstract String toString();
}
