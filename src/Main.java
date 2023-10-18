import Miau.Investidor;
import estruturasDeDados.ListaEncadeada;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada<Investidor> investidores = new ListaEncadeada<Investidor>();
        Investidor luciana = new Investidor("Luciana Naomi Tamashiro",new BigInteger("123456789101"));
        Investidor jujuba = new Investidor ("Jujuba Yukina Tamashiro Yorinori", new BigInteger("67861448954"));

        investidores.adicionar(luciana);
        investidores.adicionar(jujuba);

        System.out.println("Tamanho da lista: " + investidores.getTamanho());
        System.out.println("----------------------------------------------");
        for(int i = 0; i < investidores.getTamanho(); i++){
            System.out.println("Nome: " + investidores.get(i).getValor().getNome());
            System.out.println("CPF: " + investidores.get(i).getValor().getCpf());
        }
    }
}