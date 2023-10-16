package estruturasDeDados;

public class Fila {
     //Remove primeiro da fila e adiciona no final
    private ListaEncadeada<T> lista;

    public Fila(ListaEncadeada<T> lista) {
        this.lista = lista;
    }

    public void adicionar (T valor){
        this.lista.adicionar(valor);
    }

    public void remover (){
        this.lista.remover(this.lista.getPrimeiro().getValor());
    }
}

