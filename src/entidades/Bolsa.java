package entidades;
public class Bolsa {
    private int id;
    private String nome;
    private String servico;
    private String site;
    private String perfil;
    private String codigo;
    private int cnpj;
    private boolean ativo;

    public Bolsa (int id, String nome, String servico, String site, String perfil, String codigo, int cnpj, boolean ativo){
        this.id = id;
        this.nome = nome;
        this.servico = servico;
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

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
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

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
