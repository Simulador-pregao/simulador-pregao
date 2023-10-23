package estruturasDeDados;

//adiciona item no começo da lista, remove item no começo da lista
public class Pilha<T> {
    private ListaEncadeada<T> lista;

    public Pilha() {
        this.lista = new ListaEncadeada<T>();
    }

    public void adicionar(T valor){
        this.lista.adicionarComeco(valor);
    }

    public void remover(T valor){
        this.lista.remover(this.get());
    }

    public T get(){
        return this.lista.getPrimeiro().getValor();
    }
}