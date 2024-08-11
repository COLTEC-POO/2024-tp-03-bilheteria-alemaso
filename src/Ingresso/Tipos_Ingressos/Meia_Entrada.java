package Ingresso.Tipos_Ingressos;

import java.util.*;
import Ingresso.*;

public class Meia_Entrada extends Ingresso {

    protected float preco;
    protected char tipo;

    public Meia_Entrada(Date dataVenda , float preco , char type)
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
