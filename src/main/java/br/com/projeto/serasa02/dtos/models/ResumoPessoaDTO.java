package br.com.projeto.serasa02.dtos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ResumoPessoaDTO {

    private String nome;
    private String cidade;
    private String estado;
    private String scoreDescricao;

    @JsonIgnore
    private int score;
}
