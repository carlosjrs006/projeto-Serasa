package br.com.projeto.serasa02.dtos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class ResumoIdPessoaDTO {

    private String nome;
    private String telefone;
    private int idade;
    private String scoreDescricao;

    @JsonIgnore
    private int score;
}
