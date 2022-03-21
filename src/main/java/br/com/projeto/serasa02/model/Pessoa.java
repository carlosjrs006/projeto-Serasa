package br.com.projeto.serasa02.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 200)
    private String nome;

    @Column
    private int idade;

    @Column
    private String telefone;

    @Column
    private String cidade;

    @Column
    private String estado;

    @Column
    private int score;
}
