package estruturasDeDados;

public class ListaEncadeada<T> {
    private Elemento<T> primeiro;
    private Elemento<T> ultimo;
    private int tamanho;

    //---------------------------------------------------
    public void Lista (int tamanho){
        this.tamanho = 0;
    } 

    //gets
    public Elemento<T> getPrimeiro() {
            return primeiro;
        }

    public Elemento<T> getUltimo() {
            return ultimo;
    }

    public int getTamanho() {
            return tamanho;
    }

    public Elemento<T> get(int posicao){
        Elemento<T> atual = this.primeiro;
        for(int i = 0; i < posicao; i++){
            if(atual.getProximo() != null)
                atual = atual.getProximo();
        }
        return atual;
    }

    //sets
    private void setPrimeiro(Elemento<T> primeiro) {
        this.primeiro = primeiro;
    }

    private void setUltimo(Elemento<T> ultimo) {
        this.ultimo = ultimo;
    }

    private void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    //---------------------------------------------------

    public void adicionarFinal (T novoValor){
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

    public void adicionarComeco (T novoValor){
        Elemento<T> novoElemento = new Elemento<T>(novoValor);
        if(this.primeiro == null && this.ultimo == null){
            this.primeiro = novoElemento;
            this.ultimo = novoElemento;
        } else {
            novoElemento.setProximo(this.primeiro);
            this.primeiro = novoElemento;
        }
        this.tamanho ++;
    }

    public void remover (T valorProcurado){
        Elemento<T> anterior = null;
        Elemento<T> atual = this.primeiro;

        for(int i = 0; i <= this.getTamanho(); i++){
            if (atual.getValor().equals(valorProcurado)) {
                if (this.tamanho == 1){
                    this.primeiro = null;
                    this.ultimo = null;
                } else if (atual == this.primeiro){
                    this.primeiro = atual.getProximo();
                } else if (atual == this.ultimo){
                    this.ultimo = anterior;
                } else {
                    anterior.setProximo(atual.getProximo());
                    atual = null;
                }
                this.tamanho --;
                break;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
    }

}

