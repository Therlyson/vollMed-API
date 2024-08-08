package med.voll.api.domain.paciente.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.paciente.DTO.AtualizaPacienteDTO;
import med.voll.api.domain.paciente.DTO.DadosPacienteDTO;
import med.voll.api.domain.paciente.DTO.ListagemPacienteDTO;
import med.voll.api.domain.paciente.model.Paciente;
import med.voll.api.domain.paciente.service.PacienteService;
import med.voll.api.domain.paciente.DTO.DetalhamentoPacienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarPaciente(@RequestBody @Valid DadosPacienteDTO paciente, UriComponentsBuilder uriBuilder0){
        Paciente pacienteCdastro = pacienteService.cadastrar(paciente);
        var uri = uriBuilder0.path("/pacientes/{id}").buildAndExpand(pacienteCdastro.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoPacienteDTO(pacienteCdastro));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemPacienteDTO>> listarPacientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        Page<ListagemPacienteDTO> page = pacienteService.listar(pageable);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarPaciente(@RequestBody @Valid AtualizaPacienteDTO paciente){
        Paciente pacienteCompleto = pacienteService.atualizar(paciente);
        return ResponseEntity.ok(new DetalhamentoPacienteDTO(pacienteCompleto));
    }

    @DeleteMapping("/{id}")
    @Secured("ROLE_ADMIN") //apenas admins podem desativar pacientes
    @Transactional
    public ResponseEntity desativarPaciente(@PathVariable Long id){
        pacienteService.desativar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPaciente(@PathVariable Long id){
        var paciente = pacienteService.buscarPorId(id);
        return ResponseEntity.ok(new DetalhamentoPacienteDTO(paciente));
    }
}
