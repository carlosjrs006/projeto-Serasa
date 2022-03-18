package br.com.projeto.serasa02.dtos.forms;

import lombok.Data;


@Data
public class PessoaFormPostDTO {

    private String nome;
    private int idade;
    private String telefone;
    private String cidade;
    private String estado;
    private int score;
}
