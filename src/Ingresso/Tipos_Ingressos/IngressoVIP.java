package Ingresso.Tipos_Ingressos;

import java.util.*;
import Ingresso.*;

public class IngressoVIP extends Ingresso {

    protected float preco;
    protected char tipo;

    public IngressoVIP(Date dataVenda , float preco , char type)
    {
        super(dataVenda);
        this.preco = preco;
        this.tipo = type;
    }

    @Override
    public int calculaMaximo() {
        return 0;
    }
}
