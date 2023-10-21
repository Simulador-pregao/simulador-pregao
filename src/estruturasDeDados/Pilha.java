/*package estruturasDeDados;

public class Pilha {
    private lista itens;

    private Pilha (itens) {
        itens = this.itens;
    }
}*/

package estruturasDeDados;

public class Pilha<T> {
    private Lista<T> itens;

    public Pilha() {
        this.itens = new Lista<T>();
    }
}