package entidades;

public class Custodia {
    private Cliente retentor;
    private Bolsa custodiante;
    private Ativo acao;
    private Corretora corretora;

    public Custodia (Cliente retentor, Bolsa custodiante, Ativo acao, Corretora corretora){
        this.retentor = retentor;
        this.custodiante = custodiante;
        this.acao = acao;
        this.corretora = corretora;
    }
}
    
