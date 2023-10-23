import entidades.Cliente;
import estruturasDeDados.Arvore;
import estruturasDeDados.ListaEncadeada;
import java.math.BigInteger;

//teste
public class Main {
    public static void main(String[] args) {
            ListaEncadeada<Cliente> investidores = new ListaEncadeada<Cliente>();
            Cliente luciana = new Cliente(new BigInteger("123456789101"), "Luciana Naomi Tamashiro");
            Cliente jujuba = new Cliente (new BigInteger("67861448954"), "Jujuba Yukina Tamashiro Yorinori");
    
            investidores.adicionarFinal(luciana);
            investidores.adicionarFinal(jujuba);
    
            System.out.println("Tamanho da lista: " + investidores.getTamanho());
            System.out.println("----------------------------------------------");
            for(int i = 0; i < investidores.getTamanho(); i++){
                System.out.println("Nome: " + investidores.get(i).getValor().getNome());
                System.out.println("CPF: " + investidores.get(i).getValor().getCpf());
            }

        Arvore<Integer> arvore = new Arvore<Integer>();
        arvore.adicionar(10);
        arvore.adicionar(8);
        arvore.adicionar(5);
        arvore.adicionar(9);
        arvore.adicionar(7);
        arvore.adicionar(18);
        arvore.adicionar(13);
        arvore.adicionar(20);
        
        System.out.println("\n\nCrescente");
        arvore.getCrescente(arvore.getRaiz());
        
        arvore.remover(9);

        System.out.println("\n\nDescrescente");
        arvore.getDecrescente(arvore.getRaiz());
        
    }
}