package entidades;
import java.util.List;
import estruturasDeDados.ListaEncadeada;

public class Carteira {
    private int id;
    private Cliente cliente;
    private ListaEncadeada<Ativo> listAtivos = new ListaEncadeada<Ativo>();
    private float saldo;

    public Carteira(int id, Cliente cliente, List<Ativo> listAtivos, float saldo) {
        this.id =  id;
        this.cliente = cliente;
        this.listAtivos = new ListaEncadeada<Ativo>();
        this.saldo = saldo;
    }
    public Carteira(int id, Cliente cliente, List<Ativo> listAtivos) {
        this.id =  id;
        this.cliente = cliente;
        this.listAtivos = new ListaEncadeada<Ativo>();
    }
    
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public ListaEncadeada<Ativo> getListAtivos() {
        return listAtivos;
    }

    public void setListAtivos(ListaEncadeada<Ativo> listAtivos) {
        this.listAtivos = listAtivos;
    }

}