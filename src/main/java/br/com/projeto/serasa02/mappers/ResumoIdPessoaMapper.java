package br.com.projeto.serasa02.mappers;

import br.com.projeto.serasa02.dtos.models.ResumoIdPessoaDTO;
import br.com.projeto.serasa02.model.Pessoa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResumoIdPessoaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ResumoIdPessoaDTO modelToDto(Pessoa pessoa){

        return modelMapper.map(pessoa, ResumoIdPessoaDTO.class);
    }

    public List<ResumoIdPessoaDTO> modelListToDtoList(List<Pessoa> pessoas){

        return pessoas.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }
}

