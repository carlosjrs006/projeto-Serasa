package br.com.projeto.serasa02.rest;

import br.com.projeto.serasa02.dtos.models.PessoaDTO;
import br.com.projeto.serasa02.dtos.forms.PessoaFormPostDTO;
import br.com.projeto.serasa02.dtos.models.ResumoPessoaDTO;
import br.com.projeto.serasa02.mappers.PessoaMapper;
import br.com.projeto.serasa02.mappers.ResumoPessoaMapper;
import br.com.projeto.serasa02.model.entity.Pessoa;
import br.com.projeto.serasa02.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaMapper pessoaMapper;

    @Autowired
    private ResumoPessoaMapper resumoPessoaMapper;


    @PostMapping
    public ResponseEntity<PessoaDTO> save(@RequestBody PessoaFormPostDTO pessoaFormPostDTO) {
        Pessoa pessoa = pessoaMapper.dtoPostToModel(pessoaFormPostDTO);
        PessoaDTO pessoaDTO = pessoaMapper.modelToDto(pessoaService.save(pessoa));
        return new ResponseEntity<PessoaDTO>(pessoaDTO, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<ResumoPessoaDTO>> listar() {

        List<Pessoa> pessoas = pessoaService.findAll();
        List<ResumoPessoaDTO> pessoaListDTO = resumoPessoaMapper.modelListToDtoList(pessoas);

        for (Pessoa pessoa : pessoas) {
            for (ResumoPessoaDTO pessoaDTO : pessoaListDTO) {
                pessoaDTO.setScoreDescricao(pessoaService.getScoreDescription(pessoa.getScore()));
            }
        }

        return ResponseEntity.ok(pessoaListDTO);
    }


}
