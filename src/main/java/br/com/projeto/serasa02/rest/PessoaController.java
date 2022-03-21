package br.com.projeto.serasa02.rest;

import br.com.projeto.serasa02.dtos.models.PessoaDTO;
import br.com.projeto.serasa02.dtos.forms.PessoaFormPostDTO;
import br.com.projeto.serasa02.dtos.models.ResumoIdPessoaDTO;
import br.com.projeto.serasa02.dtos.models.ResumoPessoaDTO;
import br.com.projeto.serasa02.mappers.PessoaMapper;
import br.com.projeto.serasa02.mappers.ResumoIdPessoaMapper;
import br.com.projeto.serasa02.mappers.ResumoPessoaMapper;
import br.com.projeto.serasa02.model.Pessoa;
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

    @Autowired(required = true)
    private ResumoIdPessoaMapper resumoIdPessoaMapper;


    @PostMapping
    public ResponseEntity<PessoaDTO> salvar(@RequestBody PessoaFormPostDTO pessoaFormPostDTO) {
        Pessoa pessoa = pessoaMapper.dtoPostToModel(pessoaFormPostDTO);
        PessoaDTO pessoaDTO = pessoaMapper.modelToDto(pessoaService.salvar(pessoa));
        return new ResponseEntity<PessoaDTO>(pessoaDTO, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<ResumoPessoaDTO>> buscarTodos() {

        List<Pessoa> pessoas = pessoaService.buscarTodos();
        List<ResumoPessoaDTO> pessoaListDTO = resumoPessoaMapper.modelListToDtoList(pessoas);
        pessoaListDTO.forEach(pessoaDTO -> pessoaDTO.setScoreDescricao(pessoaService.getScoreDescricao(pessoaDTO.getScore())));

        return ResponseEntity.ok(pessoaListDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResumoIdPessoaDTO> buscarPorId(@PathVariable Long id) {

        Pessoa pessoa = pessoaService.buscarPorId(id);
        ResumoIdPessoaDTO resumoIdPessoaDTO = resumoIdPessoaMapper.modelToDto(pessoa);
        resumoIdPessoaDTO.setScoreDescricao(pessoaService.getScoreDescricao(resumoIdPessoaDTO.getScore()));

        return ResponseEntity.ok(resumoIdPessoaDTO);
    }


}
