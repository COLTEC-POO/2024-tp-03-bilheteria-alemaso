package Ingresso.Tipos_Ingressos;

import java.util.*;
import Ingresso.*;

public class Ingresso_Normal extends Ingresso {

    public Ingresso_Normal(Date dataVenda , double preco)
    {
        super(dataVenda, preco);
    }

    @Override
    public double calculaReceita() {
        return preco;
    }

    @Override
    public String exibeExtrato() {
        String s = "Ingresso Normal - " + dataVenda + " - R$" + calculaReceita();
        return s;
    }
}
