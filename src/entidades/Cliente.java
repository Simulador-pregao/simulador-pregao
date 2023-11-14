package entidades;

public class Cliente implements Comparable<Cliente>{
    private int id;
    private String cpf;
    private String nome;
    private float saldo;
    private Carteira carteira = new Carteira();

    public Cliente(int id, String nome, String cpf, float saldo) {
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

    public Cliente(int id){
            this.id = id;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    public int compareTo(Cliente o) {
        return Integer.compare(this.id, o.getId());
    }

    public String toString() {
        return (this.id + ";" + this.nome + ";" + this.cpf + ";" + this.saldo);
    }
      
}

