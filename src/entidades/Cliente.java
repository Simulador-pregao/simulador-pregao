package entidades;

public class Cliente {
    private int id;
    private String cpf;
    private String nome;

    public Cliente(int id, String cpf, String nome){
            this.id = id;
            this.cpf = cpf;
            this.nome = nome;
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



