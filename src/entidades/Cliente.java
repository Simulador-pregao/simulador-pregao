package entidades;

public class Cliente {
    private int id;
    private String cpf;
    private String nome;
    private float saldo;

    public Cliente(int id, String cpf, String nome, float saldo) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.saldo = saldo;
    }

    public Cliente(int id, String nome, String cpf){
            this.id = id;
            this.cpf = cpf;
            this.nome = nome;
            this.saldo = 0;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

}



