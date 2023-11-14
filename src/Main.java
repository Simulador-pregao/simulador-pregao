import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDateTime;

import dados.DatabaseManager;
import entidades.Cliente;
import entidades.Historico;
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
            System.out.println("Lista de clientes [1]");
            System.out.println("Lista de ativos [2]");;
            opcao = sc.nextInt();
            System.out.println("------------------------------------------------------------");

            switch (opcao) {
                case 1:
                    Arvore<Cliente> clientesExibir = dbManager.lerClientes();
                    System.out.println("ID;Nome;CPF;Saldo");
                    clientesExibir.getCrescente().forEach(cliente -> System.out.println(cliente.getId() + ";" + cliente.getNome() + ";" + cliente.getCpf() + ";" + cliente.getSaldo()));
                    break;
                case 2:
                    Arvore<Ativo> ativosExibir = dbManager.lerAtivos();
                    System.out.println("ID;Codigo;Cotacao;Prazo;Empresa");
                    ativosExibir.getCrescente().forEach(ativo -> System.out.println(ativo.getId() + ";" + ativo.getCodigo() + ";" + ativo.getCotacao() + ";" + ativo.getPrazo() + ";" + ativo.getEmpresa()));
                    break;
                default:
                    System.out.println("Insira um valor correspondente a alguma operação.");
            }

        } else if (opcao == 2) {
            System.out.println("- O que você gostaria de registrar? -");
            System.out.println("Cliente [1]");
            System.out.println("Ativo [2]");
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
                    Elemento<Cliente> maiorIdCliente = clientesRegistrar.getRaiz();
                    while (maiorIdCliente.getDireita() != null) {
                        maiorIdCliente = maiorIdCliente.getDireita();
                    }
                    int idCliente = maiorIdCliente.getValor().getId() + 1;

                    Cliente cliente = new Cliente(idCliente, nome, cpf);
                    dbManager.gravarCliente(cliente);
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("- Cadastrar ativo -");
                    sc.nextLine();
                    System.out.print("Codigo: \n");
                    String codigo = sc.nextLine();
                    System.out.print("Cotação: \n");
                    Float cotacao = sc.nextFloat();
                    System.out.print("liquidacao [1]Física, [2]Financeira: \n");
                    int liquidacaoInserida = sc.nextInt();
                    boolean liquidacao = true;
                    switch(liquidacaoInserida){
                        case 1:
                            liquidacao = true;
                            break;
                        case 2:
                            liquidacao = false;
                            break;
                        default:
                            System.out.println("Insira uma liquidação válida.");
                    }
                    System.out.print("Prazo: \n");
                    Date prazo = null;
                    try{
                        prazo = dateFormat.parse(sc.nextLine());
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    System.out.println("Empresa: ");
                    String empresaAtivo = sc.next();
                    //gera id
                    Arvore<Ativo> ativosRegistrar = dbManager.lerAtivos();
                    Elemento<Ativo> maiorIdAtivo = ativosRegistrar.getRaiz();
                    while (maiorIdAtivo.getDireita() != null) {
                        maiorIdAtivo = maiorIdAtivo.getDireita();
                    }
                    int idAtivo = maiorIdAtivo.getValor().getId() + 1;

                    Ativo ativo = new Ativo(idAtivo, codigo, cotacao, liquidacao, prazo, empresaAtivo, true);
                    dbManager.gravarAtivo(ativo);
                    break;
                default:
                    System.out.println("Insira um valor correspondente a alguma operação.");
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

                                // Cria id, cria um hsitorico de compra
                                ListaEncadeada<Historico> historico = dbManager.lerHistorico();
                                int id = 0;
                                if(historico.getTamanho() == 0){
                                    id = 1;
                                } else {
                                    Elemento<Historico> maiorId = historico.getPrimeiro();
                                    while (maiorId.getProximo() != null) {
                                        maiorId = maiorId.getProximo();
                                    }
                                    id = maiorId.getValor().getId() + 1;
                                }
                                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                                dbManager.gravarHistorico(new Historico(id, ativoComprado, conta, quantidade, ativoComprado.getCotacao(), java.time.LocalDateTime.now()));
                                
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
                        ListaEncadeada<Historico> historico = dbManager.lerHistorico();
                        System.out.println(historico.get(1).getValor());
                        if(historico.getTamanho() == 0){
                            System.out.println("Histórico vazio");
                        } else {
                            System.out.println("- Minha carteira -");
                            System.out.println("id;codigo;cliente;operacao;quantiaLotes;valorUnitario;dataHora");
                            for(int i = 0; i == historico.getTamanho(); i++){
                                Historico naCarteira = new Historico(conta, "compra");
                                if (historico.get(i).equals(naCarteira)){
                                    System.out.println(historico.get(i).getValor());
                                }
                            }
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



    
