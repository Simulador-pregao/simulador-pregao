package estruturasDeDados;

public class Elemento<T> {
    private T valor;
    private Elemento<T> proximo;

    public Elemento(T novoValor){
        this.valor = novoValor;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Elemento<T> getProximo() {
        return proximo;
    }

    public void setProximo(Elemento<T> proximo) {
        this.proximo = proximo;
    }

}
