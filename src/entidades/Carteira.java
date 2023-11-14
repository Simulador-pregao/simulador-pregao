package entidades;
import java.util.List;

import estruturasDeDados.Arvore;
import estruturasDeDados.ListaEncadeada;

public class Carteira {
    private Arvore<Ativo> ativos = new Arvore<Ativo>();

    public Carteira() {
        this.ativos = new Arvore<>();
    }

    public void adicionar(Ativo ativo){
        ativos.adicionar(ativo);
    }

    public void remover(Ativo ativo){
        ativos.remover(ativo);
    }

    public Arvore<Ativo> getAtivos(){
        return ativos;
    }

}