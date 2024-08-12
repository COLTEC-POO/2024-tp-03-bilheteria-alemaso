package Ingresso.Tipos_Ingressos;

import java.util.*;
import Ingresso.*;

public class Meia_Entrada extends Ingresso {

    protected double preco;

    public Meia_Entrada(Date dataVenda , double preco)
    {
        super(dataVenda, preco);
    }

    @Override
    public double calculaReceita() {
        return preco / 2;
    }

    @Override
    public String exibeExtrato() {
        String s = "Meia entrada - " + dataVenda + " - R$" + calculaReceita();
        return s;
    }
}
