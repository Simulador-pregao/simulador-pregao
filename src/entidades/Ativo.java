package Miau;
import java.text.DateFormat;
import java.text.DecimalFormat;

import java.util.Date;

public class Ativo {
    private int codigo;
    private float cotacao;
    private boolean liquidacao;
    private Date prazo;
    private Carteira carteira; 
    private Bolsa emissor;
    

    public void Ativo(int codigo, float cotacao, boolean liquidacao, Date prazo, Carteira carteira,Bolsa emissor){
        this.codigo = codigo;
        this.cotacao = cotacao;
        this.liquidacao = liquidacao;
        this.prazo = prazo;
        this.carteira = carteira;
        this.emissor = emissor;
    } 

    
}
