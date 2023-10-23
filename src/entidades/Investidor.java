package entidades;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

public class Cliente {
    private String nome;
    private BigInteger cpf;

    public Cliente(String nome, BigInteger cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public BigInteger getCpf() {
        return cpf;
    }

    public String salvar(){
        try {
            FileWriter fw = new FileWriter("C:\\dados\\lientes.txt", null, false);
            PrintWriter pw = new PrintWriter(fw, false, null);
            pw.print(this.nome + ";");
            pw.println(this.cpf);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
