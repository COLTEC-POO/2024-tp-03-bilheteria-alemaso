package Evento;

import java.time.*;
import Ingresso.Ingresso;
import Ingresso.Receita;
import java.util.*;

public abstract class Evento implements Receita{
    protected String nome;
    protected Date data; //LocalDate.of() //data, hora
    protected String local;
    protected double preco;
    protected int qtdIngressos;
    protected Ingresso[] ingressos;
    protected int totalIngressosVendidos; // Índice do array ingressos
    protected int[] maxIngressos = {-1,-1,-1}; // -1 para quando não há limite individual

    public Evento(String nome, Date data, String local, double preco) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.preco = preco;
        this.totalIngressosVendidos = 0;
    }

    public String getNome() {
        return nome;
    }

    public int[] getMaxIngressos() {
        return maxIngressos;
    }

    public void setMaxIngressos(int[] maxIngressos) {
        this.maxIngressos = maxIngressos;
    }

    public int getTotalIngressosVendidos() {
        return totalIngressosVendidos;
    }

    public void setTotalIngressosVendidos(int totalIngressosVendidos) {
        this.totalIngressosVendidos = totalIngressosVendidos;
    }

    public Ingresso[] getIngressos() {
        return ingressos;
    }

    public void setIngressos(Ingresso[] ingressos) {
        this.ingressos = ingressos;
    }

    public int getQtdIngressos() {
        return qtdIngressos;
    }

    public double getPreco() {
        return preco;
    }

    public abstract String toString();
}
