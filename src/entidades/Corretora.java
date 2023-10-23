package entidades;

import java.math.BigInteger;

public class Corretora {
    private String nome;
    private String site;
    private String perfil;
    private String codigo;
    private BigInteger cnpj;
    private boolean ativo;

    public Corretora (String nome, String site, String perfil, String codigo, BigInteger cnpj, boolean ativo){
        this.nome = nome;
        this.site = site;
        this.perfil = perfil;
        this.codigo = codigo;
        this.cnpj = cnpj;
        this.ativo = ativo;
    }
}
