import java.util.ArrayList;
import java.util.List;

public class Carteira {
    private Investidor investidor;
    private List<Ativo> listAtivos = new ArrayList<Ativo>();


    public Carteira(Investidor investidor, List<Ativo> listAtivos) {
        this.investidor =  investidor;
        this.listAtivos = listAtivos;
    }

}