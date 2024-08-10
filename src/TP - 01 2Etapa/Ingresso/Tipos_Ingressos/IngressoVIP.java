package Ingresso.Tipos_Ingressos;
import java.util.*;
import Ingresso.*;

public class IngressoVIP extends Ingresso { 

    protected int preco;
    protected char tipo;

    public IngressoVIP(Date dataVenda , int preco , char type)
    {
        super(dataVenda);
        this.preco = preco;
        this.tipo = type;
    }
}
