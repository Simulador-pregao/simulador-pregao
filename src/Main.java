import java.text.SimpleDateFormat;
import java.util.Scanner;
import dados.DatabaseManager;
import entidades.Cliente;
import estruturasDeDados.Arvore;
import estruturasDeDados.Elemento;
import estruturasDeDados.ListaEncadeada;
import entidades.Ativo;

public class Main {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("------------------------------------------------------------");
        System.out.println("Simulador de pregão");
        System.out.println("----------------------------------");
        System.out.println("- Qual operação você gostaria de acessar? -");
        System.out.println("Exibir[1]   Registrar[2]   Minha conta[3]   Fechar[4]");
        int opcao = sc.nextInt();
        System.out.println("------------------------------------------------------------");

        if (opcao == 1) {
            System.out.println("- O que você gostaria de exibir? -");
            System.out.println("Historico de um ativo [1]");
            System.out.println("Lista de clientes [2]");
            System.out.println("Lista de ativos [3]");
            System.out.println("Lista de empresas [4]");
            System.out.println("Lista de corretoras [5]");
            System.out.println("Lista de bolsas[6]");
            opcao = sc.nextInt();
            System.out.println("------------------------------------------------------------");

            switch (opcao) {
                case 1:
                    System.out.print("- Insira o código do ativo desejado: ");
                    String codigoAtivoExibir = sc.next();
                    // Lógica para exibir o histórico do ativo com o código informado
                    // ...
                    break;

                case 2:
                    Arvore<Cliente> clientesExibir = dbManager.lerClientes();
                    System.out.println("ID;Nome;CPF;Saldo");
                    clientesExibir.getCrescente().forEach(cliente -> System.out.println(cliente.getId() + ";" + cliente.getNome() + ";" + cliente.getCpf() + ";" + cliente.getSaldo()));
                    break;

                case 3:
                    System.out.println("- Cadastrar ativo -");
                    sc.nextLine();
                    System.out.print("Código do ativo: ");
                    String codigoAtivoCadastrar = sc.nextLine();
                    // Lógica para cadastrar o ativo com o código informado
                    // ...
                    break;

                case 4:
                    System.out.println("- Cadastrar empresa -");
                    sc.nextLine();
                    System.out.print("Nome da empresa: ");
                    String nomeEmpresa = sc.nextLine();
                    // Lógica para cadastrar a empresa com o nome informado
                    // ...
                    break;

                case 5:
                    System.out.println("- Cadastrar corretora -");
                    sc.nextLine();
                    System.out.print("Nome da corretora: ");
                    String nomeCorretora = sc.nextLine();
                    // Lógica para cadastrar a corretora com o nome informado
                    // ...
                    break;

                case 6:
                    System.out.println("- Cadastrar bolsa -");
                    sc.nextLine();
                    System.out.print("Nome da bolsa: ");
                    String nomeBolsa = sc.nextLine();
                    // Lógica para cadastrar a bolsa com o nome informado
                    // ...
                    break;

                default:
            }

        } else if (opcao == 2) {
            System.out.println("- O que você gostaria de registrar? -");
            System.out.println("Cliente [1]");
            System.out.println("Ativo [2]");
            System.out.println("Empresa [3]");
            System.out.println("Corretora [4]");
            System.out.println("Bolsa [5]");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("- Cadastrar usuário -");
                    sc.nextLine();
                    System.out.print("Nome: \n");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    // Cria id
                    Arvore<Cliente> clientesRegistrar = dbManager.lerClientes();
                    Elemento<Cliente> maiorId = clientesRegistrar.getRaiz();
                    while (maiorId.getDireita() != null) {
                        maiorId = maiorId.getDireita();
                    }
                    int id = maiorId.getValor().getId() + 1;

                    Cliente cliente = new Cliente(id, nome, cpf);
                    dbManager.gravarCliente(cliente);
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;
                default:
            }
        } else if (opcao == 3) {
            System.out.print("- Insira seu id:  ");
            //procura cliente pelo id
            int idProcurado = sc.nextInt();
            Arvore<Cliente> clientes = dbManager.lerClientes();
            Cliente conta = null;
            try {
                Elemento<Cliente> elementoClienteProcurado = new Elemento<Cliente>(new Cliente(idProcurado));
                conta = clientes.procurar(elementoClienteProcurado, clientes.getRaiz()).getValor();
            } catch (IllegalArgumentException e) {
                System.out.println("Não foi possível encontrar esse usuário.");
            }

            if (conta != null) {
                System.out.println("Bem vindo!");
                System.out.println("ID: " + conta.getId());
                System.out.println("Nome: " + conta.getNome());
                System.out.println("CPF: " + conta.getCpf());
                System.out.println("Saldo: " + conta.getSaldo());
                System.out.println("----------------------------------");
                System.out.println("- Operações -");
                System.out.println("Comprar ações[1]");
                System.out.println("Depositar[2]");
                System.out.println("Descontar[3]");
                System.out.println("Minha carteira[4]");
                System.out.println("Encerrar Operações[5]");
                opcao = sc.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("----------------------------------");
                        System.out.println("- Compra de ativos -");
                        Arvore<Ativo> ativos = dbManager.lerAtivos();

                        System.out.print("- Insira o código do ativo que deseja comprar: ");
                        //procura o ativo
                        Ativo ativoComprado = new Ativo(sc.next().toUpperCase());
                        try {
                            ativoComprado = ativos.procurar(new Elemento<Ativo>(ativoComprado), ativos.getRaiz()).getValor();
                        } catch (IllegalArgumentException e) {
                            System.out.println("Não foi possível encontrar esse ativo.");
                        }

                        System.out.println("\n - Informações do ativo -");
                        System.out.println("Empresa: " + ativoComprado.getEmpresa());
                        if (ativoComprado.isLiquidacao() == true){
                            System.out.println("Liquidação: " + "física");
                        } else {
                            System.out.println("Liquidação: " + "financeira");
                        }
                        System.out.println("Cotação do ativo: " + ativoComprado.getCotacao() + "R$");
                        System.out.println("Prazo: " + dateFormat.format(ativoComprado.getPrazo()));
                        
                        
                        if (ativoComprado.isPermiteCompra() == true) { 
                            System.out.print("- Insira a quantidade de lotes que deseja comprar: ");
                            int quantidade = sc.nextInt();
                            
                            float precoFinal = (ativoComprado.getCotacao() * quantidade);
                            if(conta.getSaldo() > precoFinal){
                                conta.setSaldo(conta.getSaldo() - precoFinal);
                                conta.getCarteira().adicionar(ativoComprado);
                                dbManager.atualizarCliente(conta);
                                System.out.println("- Compra realizada com sucesso! -");
                                System.out.println("Saldo: " + conta.getSaldo() + "R$");
                            } else {
                                System.out.println("- Saldo Insuficiente -");
                            }
                        } else {
                            System.out.println("O ativo não está disponível para venda.");
                        }
                            break;
                    case 2:
                        System.out.print("Insira o valor que deseja depositar: ");
                        float valor = sc.nextFloat();
                        conta.setSaldo(conta.getSaldo() + valor);
                        dbManager.atualizarCliente(conta);
                        System.out.println("- Despósito realizado com sucesso! -");
                        System.out.println("Valor depositado: " + valor + "R$");
                        System.out.println("Saldo: " + conta.getSaldo() + "R$");
                        break;
                    case 3:
                        System.out.print("Insira o valor que deseja descontar: ");
                        valor = sc.nextFloat();
                            
                        if(conta.getSaldo() > valor){ 
                            conta.setSaldo(conta.getSaldo() - valor);
                            dbManager.atualizarCliente(conta);
                            System.out.println("- Desconto realizado com sucesso! -");
                            System.out.println("Valor descontado: " + valor + "R$");
                            System.out.println("Saldo: " + conta.getSaldo() + "R$");
                        } else {
                            System.out.println("- Saldo Insuficiente -");
                        }
                        break;
                    case 4:
                        if(conta.getCarteira().getAtivos().getTamanho() == 0) {
                            System.out.println("Vazia.");
                        } else {
                            System.out.println("id;codigo;cotacao;liquidacao;prazo;permiteCompra");
                            conta.getCarteira().getAtivos().getCrescente().forEach(Ativo -> System.out.println(Ativo));
                        }
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Insira um valor correspondente a alguma operação.");
                }
            } else if (opcao == 4) {
            } else {
                System.out.println("Insira um valor correspondente a alguma operação.");
            }
        }
    }
}


//CÓDIGO ANTIGO:
/*import java.util.Scanner;

import dados.DatabaseManager;
import entidades.Cliente;
import entidades.Empresa;
import estruturasDeDados.Arvore;
import estruturasDeDados.Elemento;
import estruturasDeDados.ListaEncadeada;

public class Main{
    public static void main(String[] args) {
        
        DatabaseManager dbManager = new DatabaseManager();
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------------------------------------------------");
        System.out.println("Simulador de pregão");
        System.out.println("----------------------------------");
        System.out.println("- Qual operação você gostaria de acessar? -");
        System.out.println("Exibir[1]   Registrar[2]   Minha conta[3]   Fechar[4]");
        int opcao = sc.nextInt();
        System.out.println("------------------------------------------------------------");

        if(opcao == 1){
            System.out.println("- O que você gostaria de exibir? -");
            System.out.println("Historico de um ativo [1]");
            System.out.println("Lista de clientes [2]");
            System.out.println("Lista de ativos [3]");
            System.out.println("Lista de empresas [4]");
            System.out.println("Lista de corretoras [5]");
            System.out.println("Lista de bolsas[6]");
            opcao = sc.nextInt();
            System.out.println("------------------------------------------------------------");

            switch(opcao){
                case 1:
                System.out.print("- Insira o código do ativo desejado: ");
                String codigoAtivo = sc.next();
                    break;

                    case 1.1:
    System.out.print("- Insira o código do ativo desejado: ");
    String codigoAtivo = sc.next();
    // Lógica para exibir o histórico do ativo com o código informado
    // ...

    break;

                case 2:
                    Arvore<Cliente> clientes = dbManager.lerClientes();
                    System.out.println("ID;Nome;CPF;Saldo");
                    clientes.getCrescente(clientes.getRaiz());
                    break;

                case 3:
            System.out.println("- Cadastrar ativo -");
            sc.nextLine();
            System.out.print("Código do ativo: ");
            String codigoAtivo = sc.nextLine();
                    break;

                case 4:
                System.out.println("- Cadastrar empresa -");
    sc.nextLine();
    System.out.print("Nome da empresa: ");
    String nomeEmpresa = sc.nextLine();
                    break;

                case 5:
                System.out.println("- Cadastrar corretora -");
    sc.nextLine();
    System.out.print("Nome da corretora: ");
    String nomeCorretora = sc.nextLine();
                    break;

                case 6:
                System.out.println("- Cadastrar bolsa -");
    sc.nextLine();
    System.out.print("Nome da bolsa: ");
    String nomeBolsa = sc.nextLine();
                    break;

                default:
            }

        } else if (opcao == 2){
            System.out.println("- O que você gostaria de registrar? -");
            System.out.println("Cliente [1]");
            System.out.println("Ativo [2]");
            System.out.println("Empresa [3]");
            System.out.println("Corretora [4]");
            System.out.println("Bolsa [5]");
            opcao = sc.nextInt();

            switch(opcao){
                case 1:
                    System.out.println("- Cadastrar usuário -");
                    sc.nextLine();
                    System.out.print("Nome: \n");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    //cria id
                    Arvore<Cliente> clientes = dbManager.lerClientes();
                    Elemento<Cliente> maiorId = clientes.getRaiz();
                    while (maiorId.getDireita() != null){
                        maiorId = maiorId.getDireita();
                    }
                    int id = maiorId.getValor().getId() + 1;

                    Cliente cliente = new Cliente(id, nome, cpf);
                    dbManager.gravarCliente(cliente);
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;
                default:
            } 
        } else if (opcao == 3) {
            System.out.print("- Insira seu id:  ");
            int idProcurado = sc.nextInt();
            
            Arvore<Cliente> clientes = dbManager.lerClientes();
            Elemento<Cliente> conta = null;
            try {
                Elemento<Cliente> elementoClienteProcurado = new Elemento<Cliente>(new Cliente(idProcurado));
                conta = clientes.procurar(elementoClienteProcurado, clientes.getRaiz());
            } catch (IllegalArgumentException e){
                System.out.println("Não foi possível encontrar esse usuário.");
            }

            if (conta != null) {
                System.out.println("Bem vindo!");
                System.out.println("ID: " + conta.getValor().getId());
                System.out.println("Nome: " + conta.getValor().getNome());
                System.out.println("CPF: " + conta.getValor().getCpf());
                System.out.println("----------------------------------");
                System.out.println("- Operações -");
                System.out.println("Comprar ativo[1]     Depositar[2]     Descontar[3]    Encerrar Operações[4]");
                opcao = sc.nextInt();

                switch(opcao){
                    case 1:

                        break;
                    case 2:
                        System.out.print("Insira o valor que deseja depositar: ");
                        float valorDepositado = sc.nextFloat();
                        break;
                    case 3:
                        System.out.print("Insira o valor que deseja descontar: ");
                        float valorDescontado = sc.nextFloat();
                        break;
                    case 4:
                        break;
                    default:
                } 
                return;
            } else if (opcao == 4) {
            } else {
                System.out.println("Não foi possível encontrar esse id registrado.");
                 return;
            }
        }
    }

}*/

//ESSE CÓDIGO TERMINA AQUI

    //     DatabaseManager dbManager = new DatabaseManager();
    //     ListaEncadeada<Empresa> empresasList = dbManager.lerEmpresas();
    //     for(int i = 0; i < empresasList.getTamanho(); i++){
    //         System.out.print("\n");
    //         System.out.print(empresasList.get(i).getValor().getCnpj() + ";");
    //         System.out.print(empresasList.get(i).getValor().getNome() + ";");
    //         System.out.print(empresasList.get(i).getValor().getCodigo() + ";");
    //         System.out.print(empresasList.get(i).getValor().getPerfil() + ";");
    //         System.out.print(empresasList.get(i).getValor().getSite() + ";");
    //     }

    //     Cliente cl1 = new Cliente (1, "50746467826", "Jujuba Yukina Tamashiro Yorinori");
    //     Cliente cl2 = new Cliente (2, "26552352856", "Luciana Naomi Tamashiro");
    //     dbManager.gravarCliente(cl1);
    //     dbManager.gravarCliente(cl2);
    //     ListaEncadeada<Cliente> clientesList = dbManager.lerClientes();
    //     for(int i = 0; i < clientesList.getTamanho(); i++){
    //         System.out.print("\n");
    //         System.out.print(clientesList.get(i).getValor().getCpf() + ";");
    //         System.out.print(clientesList.get(i).getValor().getNome() + ";");
    //     }
    
