package estruturasDeDados;

public class Fila<T> {
     //Remove primeiro da fila e adiciona no final
    private ListaEncadeada<T> lista;

    public Fila(ListaEncadeada<T> lista) {
        this.lista = lista;
    }

    public void adicionar (T valor){
        this.lista.adicionarFinal(valor);
    }

    public void remover (){
        this.lista.remover(this.lista.getPrimeiro().getValor());
    }
}

