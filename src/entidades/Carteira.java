package entidades;
import java.util.List;
import estruturasDeDados.ListaEncadeada;

public class Carteira {
    private Cliente investidor;
    private ListaEncadeada<Ativo> listAtivos = new ListaEncadeada<Ativo>();


    public Carteira(Cliente investidor, List<Ativo> listAtivos) {
        this.investidor =  investidor;
        this.listAtivos = new ListaEncadeada<Ativo>();
    }
    
    public Cliente getInvestidor() {
        return investidor;
    }


    public void setInvestidor(Cliente investidor) {
        this.investidor = investidor;
    }


    public ListaEncadeada<Ativo> getListAtivos() {
        return listAtivos;
    }


    public void setListAtivos(ListaEncadeada<Ativo> listAtivos) {
        this.listAtivos = listAtivos;
    }

}