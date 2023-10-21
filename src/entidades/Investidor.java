package entidades;

import java.math.BigInteger;

public class Investidor {
    private String nome;
    private BigInteger cpf;

    public Investidor(String nome, BigInteger cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public BigInteger getCpf() {
        return cpf;
    }

}
