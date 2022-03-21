package br.com.projeto.serasa02.service;

import br.com.projeto.serasa02.dtos.models.Score;
import br.com.projeto.serasa02.exceptions.RecursoNaoEncontradoException;
import br.com.projeto.serasa02.model.Pessoa;
import br.com.projeto.serasa02.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;


    public Pessoa salvar(Pessoa pessoa) {
        return repository.save(pessoa);
    }


    public Pessoa buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário com o codigo: " + id + " não foi encontrado!"));
    }


    public List<Pessoa> buscarTodos() {
        try {
            return repository.findAll();
        }catch (RuntimeException e){
            throw new RecursoNaoEncontradoException("Usuarios nao encontrados.");
        }
    }


    public String getScoreDescricao(int score) {
        var scoreDescricao = "";

        if (score <= 200) {
            scoreDescricao = Score.INSUFICIENTE.getDescricao();
        } else if (score <= 500) {
            scoreDescricao = Score.INACEITAVEL.getDescricao();
        } else if (score <= 700) {
            scoreDescricao = Score.ACEITAVEL.getDescricao();
        } else if (score <= 1000) {
            scoreDescricao = Score.RECOMENDAVEL.getDescricao();
        } else {
            throw new RuntimeException("Erro score fora dos parâmetros estabelecidos.");
        }

        return scoreDescricao;
    }


}
