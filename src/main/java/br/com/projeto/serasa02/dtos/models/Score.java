package br.com.projeto.serasa02.dtos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Score {

    INSUFICIENTE("Insuficiente"),
    INACEITAVEL("Inaceitável"),
    ACEITAVEL("Aceitável"),
    RECOMENDAVEL("Recomendável");

    private final String descricao;
}
