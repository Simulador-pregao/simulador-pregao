package dados;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import entidades.Cliente; 
import entidades.Ativo;
import entidades.Empresa;
import estruturasDeDados.Arvore;
import estruturasDeDados.Elemento;
import estruturasDeDados.ListaEncadeada;

public class DatabaseManager {
    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
    
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
            return "Erro ao gravar ativo.";
        }
    }

    public Arvore<Ativo> lerAtivos() {
    Arvore<Ativo> ativos = new Arvore<>();
    try (BufferedReader br = new BufferedReader((new FileReader("src/dados/ativos.txt")))){
        String linha;
        while ((linha = br.readLine()) != null) {
            try{
                String[] parte = linha.split(";");
                Ativo ativo = new Ativo(Integer.parseInt(parte[0]), parte[1], Float.valueOf(parte[2]), Boolean.valueOf(parte[3]), this.dateFormatter.parse(parte[4]) , parte[5], Boolean.valueOf(parte[6]));
                ativos.adicionar(ativo);
            } catch (ParseException e) {
                e.printStackTrace();
            }
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

    public Boolean atualizarCliente(Cliente clienteAtualizado) {
        Arvore<Cliente> clientes = lerClientes();
        Cliente clienteExistente = clientes.procurar(new Elemento<Cliente>(clienteAtualizado), clientes.getRaiz()).getValor();
        if (clienteExistente != null) {
            // Atualizar as informações do cliente
            clienteExistente.setNome(clienteAtualizado.getNome());
            clienteExistente.setCpf(clienteAtualizado.getCpf());
            clienteExistente.setSaldo(clienteAtualizado.getSaldo());

            reescreverClientes(clientes);
            return true;
        } else {
            return false;
        }

    }

    private void reescreverClientes(Arvore<Cliente> clientes) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/dados/clientes.txt"))) {
            // Itera sobre os clientes em ordem crescente
            clientes.getCrescente().forEach(cliente -> {
                writer.println(cliente.getId() + ";" + cliente.getNome() + ";" + cliente.getCpf() + ";" + cliente.getSaldo());
            });
        } catch (IOException e) {
            e.printStackTrace();
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

}
