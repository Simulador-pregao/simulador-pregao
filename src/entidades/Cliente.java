package entidades;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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


    // !!! essa parte ainda nao ta pronta !!!
    // public String salvar(){
    //     try {    
    //         FileWriter fw = new FileWriter("C:\\dados\\lientes.txt", null, false);
    //         PrintWriter pw = new PrintWriter(fw, false, null);
    //         pw.print(this.nome + ";");
    //         pw.println(this.cpf);
    //         pw.flush();
    //         pw.close();
    //         fw.close();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

}
