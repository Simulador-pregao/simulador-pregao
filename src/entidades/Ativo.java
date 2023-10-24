package entidades;
import java.util.Date;

public class Ativo {
    private int id;
    private int codigo;
    private float cotacao;
    private boolean liquidacao;
    private Date prazo;
    private Bolsa emissor;

     public Ativo(int id, int codigo, float cotacao, boolean liquidacao, Date prazo, Bolsa emissor) {
        this.id = id;
        this.codigo = codigo;
        this.cotacao = cotacao;
        this.liquidacao = liquidacao;
        this.prazo = prazo;
        this.emissor = emissor;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getCodigo() {
        return codigo;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public float getCotacao() {
        return cotacao;
    }


    public void setCotacao(float cotacao) {
        this.cotacao = cotacao;
    }


    public boolean isLiquidacao() {
        return liquidacao;
    }


    public void setLiquidacao(boolean liquidacao) {
        this.liquidacao = liquidacao;
    }


    public Date getPrazo() {
        return prazo;
    }


    public void setPrazo(Date prazo) {
        this.prazo = prazo;
    }


    public Bolsa getEmissor() {
        return emissor;
    }


    public void setEmissor(Bolsa emissor) {
        this.emissor = emissor;
    }

    
}
