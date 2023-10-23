package estruturasDeDados;

public class Pilha<T> {
    private ListaEncadeada<T> itens;

    public Pilha() {
        this.itens = new ListaEncadeada<T>();
    }
}