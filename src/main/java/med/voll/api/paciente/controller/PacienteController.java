package med.voll.api.paciente.controller;

import jakarta.validation.Valid;
import med.voll.api.paciente.DTO.DadosPacienteDTO;
import med.voll.api.paciente.DTO.ListagemPacienteDTO;
import med.voll.api.paciente.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    @Transactional
    public void cadastrarPaciente(@RequestBody @Valid DadosPacienteDTO paciente){
        pacienteService.cadastrar(paciente);
    }

    @GetMapping
    public Page<ListagemPacienteDTO> listarPacientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable){
        return pacienteService.listar(pageable);
    }

}
