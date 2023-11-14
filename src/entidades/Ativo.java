package entidades;
import java.util.Date;

public class Ativo {
    private int id;
    private int codigo;
    private float cotacao;
    private boolean liquidacao;
    private Date prazo;
    private String empresa;
    private boolean permiteCompra; 

     public Ativo(int id, int codigo, float cotacao, boolean liquidacao, Date prazo, String empresa, boolean permiteCompra) {
        this.id = id;
        this.codigo = codigo;
        this.cotacao = cotacao;
        this.liquidacao = liquidacao;
        this.prazo = prazo;
        this.empresa = empresa;
        this.permiteCompra = permiteCompra;
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


    public String getEmpresa() {
        return empresa;
    }


    public void setEmissor(String empresa) {
        this.empresa = empresa;
    }

    public boolean isPermiteCompra() {
        return permiteCompra;
    }

    public boolean setPermiteCompra(boolean permiteCompra) {
        return this.permiteCompra = permiteCompra;
    }
    
    public int compareTo(Ativo o) {
        return Integer.compare(this.codigo, o.getCodigo());
    }

    public String toString() {
        return (this.id + ";" + this.codigo + ";" + this.cotacao + ";" + this.liquidacao + ";" + this.prazo + ";" + this.empresa.getNome() + ";" + this.permiteCompra);
    }
}
