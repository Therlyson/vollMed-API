package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.DTO.AtualizaMedicoDTO;
import med.voll.api.DTO.DadosMedicoDTO;
import med.voll.api.DTO.ListagemMedicoDTO;
import med.voll.api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoService service;

    @PostMapping
    @Transactional //metodo de escrita precisa ter uma transação ativa
    public void cadastrarMedico(@RequestBody @Valid DadosMedicoDTO dados){
        service.cadastrar(dados);
    }

    @GetMapping
    public Page<ListagemMedicoDTO> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return service.listar(pageable);
    }

    @PutMapping
    @Transactional
    public void atualizarMedico(@RequestBody @Valid AtualizaMedicoDTO novoMedico){
        service.atualizar(novoMedico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarMedico(@PathVariable Long id){
        service.deletar(id);
    }
}