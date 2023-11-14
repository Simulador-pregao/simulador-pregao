package dados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entidades.Cliente; 
import entidades.Ativo;
import entidades.Empresa;
import estruturasDeDados.Arvore;
import estruturasDeDados.ListaEncadeada;

public class DatabaseManager {

    public String gravarAtivos(Ativo ativo){
        try {    
            FileWriter fw = new FileWriter("src/dados/ativos.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.print("\n" + ativo.getId() + ";");
            pw.print(ativo.getCodigo() + ";");
            pw.print(ativo.getCotacao() + ";");
            pw.print(ativo.isLiquidacao() + ";");
            pw.print(ativo.getPrazo() + ";");
            pw.print(ativo.getEmpresa() + ";");
            pw.print(ativo.isPermiteCompra());
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

    public Arvore<Ativo> lerAtivo() {
    Arvore<Ativo> ativos = new Arvore<>();
    try (BufferedReader br = new BufferedReader((new FileReader("src/dados/ativos.txt")))){
        String linha;
        while ((linha = br.readLine()) != null) {
            String[] parte = linha.split(";");
            Ativo ativo = new Ativo(Integer.parseInt(parte[0]), parte[1], Float.valueOf(parte[2]), Boolean.valueOf(parte[3]),Date.formatOf(parte[4]), parte[5], Boolean.valueOf(parte[6]));
            ativos.adicionar(ativo);
        }
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return ativos;
    }

    public String gravarCliente(Cliente cliente){
        try {    
            FileWriter fw = new FileWriter("src/dados/clientes.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.print("\n" + cliente.getId() + ";");
            pw.print(cliente.getNome() + ";");
            pw.print(cliente.getCpf() + ";");
            pw.print(cliente.getSaldo());
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

    public Arvore<Cliente> lerClientes() {
    Arvore<Cliente> clientes = new Arvore<>();
    try (BufferedReader br = new BufferedReader((new FileReader("src/dados/clientes.txt")))){
        String linha;
        while ((linha = br.readLine()) != null) {
            String[] parte = linha.split(";");
            Cliente cliente = new Cliente(Integer.parseInt(parte[0]), parte[1], parte[2], Float.valueOf(parte[3]));
            clientes.adicionar(cliente);
        }
        br.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return clientes;
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

}
