package Ingresso.Tipos;

import java.time.LocalDate;
import Ingresso.*;

public class Meia extends Ingresso {

    public Meia(LocalDate dataVenda, double precoBase){   
        super(dataVenda, precoBase);
        this.preco /= 2;
    }
    
}
