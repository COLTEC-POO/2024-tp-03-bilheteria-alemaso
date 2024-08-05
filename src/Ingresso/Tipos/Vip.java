package Ingresso.Tipos;
import java.time.LocalDate;

import Ingresso.*;

public class Vip extends Ingresso {

    public Vip(LocalDate dataVenda, double precoBase){   
        super(dataVenda, precoBase);
        this.preco *= 2;
    }
    
}
