package dados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import entidades.Cliente;
import entidades.Empresa;
import estruturasDeDados.ListaEncadeada;

public class DatabaseManager {

    public String gravarCliente(Cliente cliente){
        try {    
            FileWriter fw = new FileWriter("clientes.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.print("\n" + cliente.getNome() + ";");
            pw.print(cliente.getCpf() + ";");
            pw.flush();
            pw.close();
            fw.close();
            return "Cadastro efetuado com sucesso!";
        } 
        catch (IOException e) {
            e.printStackTrace();
            return "Erro ao gravar cliente.";
        }
    }

    public ListaEncadeada<Empresa> lerEmpresas() {
    ListaEncadeada<Empresa> empresas = new ListaEncadeada<>();
    try (BufferedReader br = new BufferedReader((new FileReader("empresas.txt")))){
        String linha;
        while ((linha = br.readLine()) != null) {
            String[] parte = linha.split(";");
            Empresa empresa = new Empresa();
            empresa.setCnpj(parte[0]);
            empresa.setNome(parte[1]);
            empresa.setSite(parte[2]);
            empresa.setPerfil(parte[3]);
            empresa.setCodigo(parte[4]);
            empresas.adicionarFinal(empresa);
        }
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return empresas;
    }
}
