package one.digitalinnovation.labprojectpatternsspring.model;

import javax.persistence.*;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @ManyToOne
    private Endereco endereco;

    public Long getId() {
        return id;
    }

    public Client() {
    }

    public Client(Long id, String nome, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
