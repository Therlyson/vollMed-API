package med.voll.api.medico.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DTO.AtualizaMedicoDTO;
import med.voll.api.medico.DTO.DadosMedicoDTO;
import med.voll.api.medico.DTO.DetalhamentoMedicoDTO;
import med.voll.api.medico.DTO.ListagemMedicoDTO;
import med.voll.api.medico.model.Medico;
import med.voll.api.medico.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoService service;

    @PostMapping
    @Transactional //metodo de escrita precisa ter uma transação ativa
    public ResponseEntity cadastrarMedico(@RequestBody @Valid DadosMedicoDTO dados, UriComponentsBuilder uriBuilder){
        Medico medico = service.cadastrar(dados);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoMedicoDTO(medico));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemMedicoDTO>> listarMedicos(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        Page<ListagemMedicoDTO> page = service.listar(pageable);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarMedico(@RequestBody @Valid AtualizaMedicoDTO novoMedico){
        Medico medico = service.atualizar(novoMedico);
        return ResponseEntity.ok(new DetalhamentoMedicoDTO(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarMedico(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarMedico(@PathVariable Long id){
        var medico = service.buscarPorId(id);
        return ResponseEntity.ok(new DetalhamentoMedicoDTO(medico));
    }
}