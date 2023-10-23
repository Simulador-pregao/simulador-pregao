import entidades.Investidor;
import estruturasDeDados.ListaEncadeada;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada<Investidor> investidores = new ListaEncadeada<Investidor>();
        Investidor luciana = new Investidor(new BigInteger("123456789101"), "Luciana Naomi Tamashiro");
        Investidor jujuba = new Investidor (new BigInteger("67861448954"), "Jujuba Yukina Tamashiro Yorinori");

        investidores.adicionarFinal(luciana);
        investidores.adicionarFinal(jujuba);

        System.out.println("Tamanho da lista: " + investidores.getTamanho());
        System.out.println("----------------------------------------------");
        for(int i = 0; i < investidores.getTamanho(); i++){
            System.out.println("Nome: " + investidores.get(i).getValor().getNome());
            System.out.println("CPF: " + investidores.get(i).getValor().getCpf());
        }
    }
}