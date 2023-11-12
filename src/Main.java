import java.util.Scanner;


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
        System.out.println("----------------------------------");
        System.out.println("Simulador de pregão");
        System.out.println("----------------------------------");
        System.out.println("- Qual operação você gostaria de acessar? -");
        System.out.println("Exibir[1]   Registrar[2]   Minha conta[3]   Fechar[4]");
        int opcao = sc.nextInt();
        System.out.println("----------------------------------");

        if(opcao == 1){
            System.out.println("- O que você gostaria de exibir? -");
            System.out.println("Historico de um ativo [1]");
            System.out.println("Lista de clientes [2]");
            System.out.println("Lista de ativos [3]");
            System.out.println("Lista de empresas [4]");
            System.out.println("Lista de corretoras [5]");
            System.out.println("Lista de bolsas[6]");
            opcao = sc.nextInt();
            System.out.println("----------------------------------");

            switch(opcao){
                case 1:
                
                    break;
                case 2:
                    Arvore<Cliente> clientes = dbManager.lerClientes();
                    System.out.println("ID;Nome;CPF;Saldo");
                    clientes.getCrescente(clientes.getRaiz());
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
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

}

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
    
