package br.com.projeto.serasa02.dtos.models;

import lombok.*;

import java.io.Serializable;


@Data
public class PessoaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private int idade;
    private String telefone;
    private String cidade;
    private String estado;
    private int score;


}
