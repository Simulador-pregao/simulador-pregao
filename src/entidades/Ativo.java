package entidades;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ativo implements Comparable <Ativo>{
    private int id;
    private String codigo;
    private float cotacao;
    private boolean liquidacao;
    private Date prazo;
    private String empresa;
    private boolean permiteCompra; 

    public Ativo(int id, String codigo, Float cotacao, Boolean liquidacao, Date prazo, String empresa, boolean permiteCompra) {
        this.id = id;
        this.codigo = codigo;
        this.cotacao = cotacao;
        this.liquidacao = liquidacao;
        this.prazo = prazo;
        this.empresa = empresa;
        this.permiteCompra = permiteCompra;
    }

    public Ativo(String codigo){
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getCodigo() {
        return codigo;
    }


    public void setCodigo(String codigo) {
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
        return this.codigo.compareTo(o.getCodigo());
    }

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public String toString() {
        return (this.id + ";" + this.codigo + ";" + this.cotacao + ";" + this.liquidacao + ";" + this.prazo + ";" + this.permiteCompra);
    }
}
