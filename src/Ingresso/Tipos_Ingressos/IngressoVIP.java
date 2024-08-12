package Ingresso.Tipos_Ingressos;

import java.util.*;
import Ingresso.*;

public class IngressoVIP extends Ingresso {

    protected double preco;

    public IngressoVIP(Date dataVenda , double preco)
    {
        super(dataVenda, preco);
    }

    @Override
    public double calculaReceita() {
        return preco * 2;
    }

    @Override
    public String exibeExtrato() {
        String s = "Ingresso VIP - " + dataVenda + " - R$" + calculaReceita();
        return s;
    }
}
