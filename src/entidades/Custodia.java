package entidades;

public class Custodia {
    private Investidor retentor;
    private Bolsa custodiante;
    private Ativo acao;
    private Corretora corretora;

    public Custodia (Investidor retentor, Bolsa custodiante, Ativo acao, Corretora corretora){
        this.retentor = retentor;
        this.custodiante = custodiante;
        this.acao = acao;
        this.corretora = corretora;
    }
}
    
