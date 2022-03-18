package br.com.projeto.serasa02.repository;

import br.com.projeto.serasa02.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {

}
