package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Historico{
    private int id; 
    private Ativo ativo;
    private Cliente investidor;
    private String operacao; //compra, venda, divisão, agrupamento, pagamento de dividendos, ajuste
    private int quantidade;
    private float precoUnitario;
    private LocalDateTime dataHora;

    public Historico(int id, Ativo ativo, Cliente investidor, String operacao, int quantidade, float precoUnitario, LocalDateTime dataHora) {
        this.id = id;
        this.ativo = ativo;
        this.investidor = investidor;
        this.operacao = operacao;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.dataHora = dataHora;
    }

    public Historico(Cliente investidor, String operacao) {
        this.ativo = ativo;
        this.investidor = investidor;
        this.operacao = operacao;
    }

    public Historico(int id, Ativo ativo, Cliente investidor, int quantidade, float precoUnitario, LocalDateTime dataHora) {
        this.id = id;
        this.ativo = ativo;
        this.investidor = investidor;
        this.operacao = "compra";
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.dataHora = dataHora;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Ativo getAtivo() {
        return ativo;
    }
    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }
    public Cliente getInvestidor() {
        return investidor;
    }
    public void setInvestidor(Cliente investidor) {
        this.investidor = investidor;
    }
    public String getOperacao() {
        return operacao;
    }
    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public float getPrecoUnitario() {
        return precoUnitario;
    }
    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    
     public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return this.id + ";" +
                this.ativo.getCodigo() + ";" +
                this.investidor.getNome() + ";" +
                this.operacao + ";" +
                this.quantidade + ";" +
                this.precoUnitario + ";" +
                this.dataHora.format(formatter);
    }
}