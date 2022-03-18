package br.com.projeto.serasa02.service;

import br.com.projeto.serasa02.dtos.models.Score;
import br.com.projeto.serasa02.model.entity.Pessoa;
import br.com.projeto.serasa02.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;


    public Pessoa save(Pessoa pessoa) {
        return repository.save(pessoa);
    }


    public Optional<Pessoa> listById(Long id) {
        return repository.findById(id);
    }


    public List<Pessoa> findAll() {
        return repository.findAll();
    }


    public String getScoreDescription(int score) {
        var scoreDescricao = "";

        if (score == 0 || score <= 200) {
            scoreDescricao = Score.INSUFICIENTE.toString();
        } else if (score == 201 || score <= 500) {
            scoreDescricao = Score.INACEITAVEL.toString();
        } else if (score == 501 || score <= 700) {
            scoreDescricao = Score.ACEITAVEL.toString();
        } else if (score == 701 || score <= 1000 || score > 1000) {
            scoreDescricao = Score.RECOMENDAVEL.toString();
        }

        return scoreDescricao;
    }


}
