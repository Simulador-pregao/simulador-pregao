package entidades;
import java.util.ArrayList;
import java.util.List;

public class Carteira {
    private Cliente investidor;
    private List<Ativo> listAtivos = new ArrayList<Ativo>();


    public Carteira(Cliente investidor, List<Ativo> listAtivos) {
        this.investidor =  investidor;
        this.listAtivos = listAtivos;
    }

}