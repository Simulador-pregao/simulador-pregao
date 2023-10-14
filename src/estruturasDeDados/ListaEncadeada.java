package estruturasDeDados;
import java.util.NoSuchElementException;

public class ListaEncadeada<T> {
    private Elemento<T> primeiro;
    private Elemento<T> ultimo;
    private int tamanho;

    //---------------------------------------------------
    public void Lista (int tamanho){
        this.tamanho = 0;
    } 

    public Elemento<T> getPrimeiro() {
            return primeiro;
        }

        public void setPrimeiro(Elemento<T> primeiro) {
            this.primeiro = primeiro;
        }

    public Elemento<T> getUltimo() {
            return ultimo;
        }

        public void setUltimo(Elemento<T> ultimo) {
            this.ultimo = ultimo;
        }

    public int getTamanho() {
            return tamanho;
        }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public Elemento<T> get(int posicao){
        Elemento<T> atual = this.primeiro;
        for(int i = 0; i < posicao; i++){
            if(atual.getProximo() != null)
                atual = atual.getProximo();
        }
        return atual;
    }
    //---------------------------------------------------

    private void adicionar (T novoValor){
        Elemento<T> novoElemento = new Elemento<T>(novoValor);
        if(this.primeiro == null && this.ultimo == null){
            this.primeiro = novoElemento;
            this.ultimo = novoElemento;
        } else {
            this.ultimo.setProximo(novoElemento);
            this.ultimo = novoElemento;
        }
        this.tamanho ++;
    }


    private void remover (T valorProcurado){
        Elemento<T> anterior = null;
        Elemento<T> atual = this.primeiro;

        for(int i = 0; i <= this.getTamanho(); i++){
            if (atual.getValor().equals(valorProcurado)) {
                anterior.setProximo(atual.getProximo());
                atual = null;
                this.tamanho --;
            }
            atual = atual.getProximo();
        }
    }

}

