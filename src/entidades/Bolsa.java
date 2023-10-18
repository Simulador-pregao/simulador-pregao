package Miau;
public class Bolsa {
    private String nome;
    private String servico;
    private String site;
    private String perfil;
    private String codigo;
    private int cnpj;
    private boolean ativo;

    public Bolsa (String nome, String servico, String site, String perfil, String codigo, int cnpj, boolean ativo){
        this.nome = nome;
        this.servico = servico;
        this.site = site;
        this.perfil = perfil;
        this.codigo = codigo;
        this.cnpj = cnpj;
        this.ativo = ativo;
    }
}
