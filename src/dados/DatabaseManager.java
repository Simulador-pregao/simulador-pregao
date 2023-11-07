package dados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import entidades.Cliente;
import entidades.Empresa;
import estruturasDeDados.ListaEncadeada;

public class DatabaseManager {

    public String gravarCliente(Cliente cliente){
        try {    
            FileWriter fw = new FileWriter("src/dados/clientes.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.print("\n" + cliente.getId() + ";");
            pw.print(cliente.getNome() + ";");
            pw.print(cliente.getCpf());
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
    try (BufferedReader br = new BufferedReader((new FileReader("src/dados/empresas.txt")))){
        String linha;
        while ((linha = br.readLine()) != null) {
            String[] parte = linha.split(";");
            Empresa empresa = new Empresa(parte[0], parte[1], parte[2], parte[3], parte[4], true);
            empresas.adicionarFinal(empresa);
        }
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return empresas;
    }

    public ListaEncadeada<Cliente> lerClientes() {
    ListaEncadeada<Cliente> clientes = new ListaEncadeada<>();
    try (BufferedReader br = new BufferedReader((new FileReader("src/dados/clientes.txt")))){
        String linha;
        while ((linha = br.readLine()) != null) {
            String[] parte = linha.split(";");
            Cliente cliente = new Cliente(Integer.parseInt(parte[0]), parte[1], parte[2], Float.valueOf(parte[4]));
            clientes.adicionarFinal(cliente);
        }
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return clientes;
    }
}
