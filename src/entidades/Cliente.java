package entidades;
import java.math.BigInteger;

public class Cliente {
    private BigInteger cpf;
    private String nome;

    public Cliente(BigInteger cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public BigInteger getCpf() {
        return cpf;
    }


}
