package entidades;

public class Corretora {
    private int id;
    private String nome;
    private String site;
    private String perfil;
    private String codigo;
    private String cnpj;
    private boolean ativo;
    
    public Corretora(int id, String nome, String site, String perfil, String codigo, String cnpj, boolean ativo) {
        this.nome = nome;
        this.site = site;
        this.perfil = perfil;
        this.codigo = codigo;
        this.cnpj = cnpj;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSite() {
        return site;
    }
    public void setSite(String site) {
        this.site = site;
    }
    public String getPerfil() {
        return perfil;
    }
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    
    
}
