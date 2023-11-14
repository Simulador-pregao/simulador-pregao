package estruturasDeDados;
import estruturasDeDados.Elemento;

public class Arvore<T extends Comparable<T>> {
    private Elemento<T> raiz;
    private int tamanho;

    //---------------------------------------------------
    
    public void Arvore(){
        this.raiz = null;
        this.tamanho = 0;
    }

    public Elemento<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(Elemento<T> raiz) {
        this.raiz = raiz;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    //---------------------------------------------------

    public ListaEncadeada<T> getCrescente (){
        ListaEncadeada<T> listaCresc = new ListaEncadeada<>();
        getCrescente(this.raiz, listaCresc);
        return listaCresc;
    }

    public void getCrescente (Elemento<T> atual, ListaEncadeada<T> listaCresc){
        if (atual != null){
            getCrescente(atual.getEsquerda(), listaCresc);
            listaCresc.adicionarFinal(atual.getValor());
            getCrescente(atual.getDireita(), listaCresc);
        }
    }

    public ListaEncadeada<T> getDecrescente(Elemento<T> atual) {
        ListaEncadeada<T> listaDecresc = new ListaEncadeada<>();
        getDecrescente(atual, listaDecresc);
        return listaDecresc;
    }
    
    private void getDecrescente(Elemento<T> atual, ListaEncadeada<T> listaDecresc) {
        if (atual != null) {
            getDecrescente(atual.getDireita(), listaDecresc); 
            listaDecresc.adicionarFinal(atual.getValor());
            getDecrescente(atual.getEsquerda(), listaDecresc); 
        }
    }

    public Elemento<T> procurar(Elemento<T> procurado, Elemento<T> raiz) {
        if (raiz == null)
            return null;
    
        Elemento<T> atual = raiz;
    
        if (procurado.getValor().compareTo(atual.getValor()) == 0) {
            return atual;

        } else if (procurado.getValor().compareTo(atual.getValor())  < 0) {
            if (atual.getEsquerda() != null && atual.getEsquerda() == procurado) {
                return atual.getEsquerda();
            }
            return procurar(procurado, atual.getEsquerda());

        } else if (procurado.getValor().compareTo(atual.getValor())  > 0) {
            if (atual.getDireita() != null && atual.getDireita() == procurado) {
                return atual.getDireita();
            }
            return procurar(procurado, atual.getDireita());
        }
        throw new IllegalArgumentException("O valor não foi encontrado.");
    }

    public void adicionar (T Valor){
        Elemento<T> novoElemento = new Elemento<T>(Valor);
        if (this.raiz == null){
            this.raiz = novoElemento; 
        } else {
            Elemento<T> atual = this.raiz;
            while(true){
                if (novoElemento.getValor().compareTo(atual.getValor()) < 0){
                    if(atual.getEsquerda() != null){
                        atual = atual.getEsquerda();
                    } else {
                        atual.setEsquerda(novoElemento);
                        this.tamanho ++;
                        break;
                    }
                } else if (novoElemento.getValor().compareTo(atual.getValor()) > 0){
                    if(atual.getDireita() != null){
                        atual = atual.getDireita();
                    } else {
                        atual.setDireita(novoElemento);
                        this.tamanho ++;
                        break;
                    }
                } else {
                    throw new IllegalArgumentException("Esse valor já existe.");
                }
            }
        } 
    }

    public boolean remover (T valorProcurado){
        Elemento<T> atual = this.raiz;
        Elemento<T> pai = null;
        while(true) {
            if (atual.getValor().equals(valorProcurado)){
                break;
            } else if (valorProcurado.compareTo(atual.getValor()) < 0){ //valor procurado é menor que valor atual
                pai = atual;
                atual = atual.getEsquerda();
            } else {
                pai = atual;
                atual = atual.getDireita();
            }
        }
        
        // verifica se o elemento existe
        if (atual != null){
            if (atual.getDireita() != null){ // tem filhos (nos dois lados ou só a direita)
                Elemento<T> substituto = atual.getDireita();
                Elemento<T> paiSubstituto = atual;
                while(substituto.getDireita() != null){
                    paiSubstituto = substituto;
                    substituto = substituto.getDireita(); 
                }

                if(pai != null){
                    if (atual.getValor().compareTo(pai.getValor()) < 0){
                        pai.setEsquerda(substituto);
                    } else {
                        pai.setDireita(substituto);
                    }
                } else {
                    this.raiz = substituto;
                }

            } else if (atual.getEsquerda() != null){ // tem filhos so a esquerda
                Elemento<T> substituto = atual.getEsquerda();
                Elemento<T> paiSubstituto = atual;
                while(substituto.getDireita() != null){
                    paiSubstituto = substituto;
                    substituto = substituto.getDireita(); 
                }

                if(pai != null){
                    if (atual.getValor().compareTo(pai.getValor()) < 0){
                        pai.setEsquerda(substituto);
                    } else {
                        pai.setDireita(substituto);
                    }
                } else {
                    this.raiz = substituto;
                }

                if(substituto.getValor().compareTo(paiSubstituto.getValor()) < 0){
                    paiSubstituto.setEsquerda(null);
                } else {
                    paiSubstituto.setDireita(null);
                }

            } else { // não tem filhos
                if(pai != null){
                    if (atual.getValor().compareTo(pai.getValor()) < 0){//atual > paiAtual
                        pai.setEsquerda(null);
                    } else { 
                        pai.setDireita(null);
                    }
                } else {
                    this.raiz = null;
                }
            }
            tamanho --;
            return true;
        } else {
            return false;
        }
    }
}
