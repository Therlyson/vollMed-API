package med.voll.api.domain.consulta.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.consulta.DTO.DadosAgendamentoDTO;
import med.voll.api.domain.consulta.DTO.DadosCancelamentoConsultaDTO;
import med.voll.api.domain.consulta.DTO.DadosDetalhamentoConsultaDTO;
import med.voll.api.domain.consulta.model.Consulta;
import med.voll.api.domain.consulta.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    @Transactional
    public ResponseEntity agendarConsulta(@RequestBody @Valid DadosAgendamentoDTO dadosConsulta){
        Consulta consulta = consultaService.agendar(dadosConsulta);
        return ResponseEntity.ok(new DadosDetalhamentoConsultaDTO(consulta));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelarConsulta(@RequestBody @Valid DadosCancelamentoConsultaDTO dados){
        consultaService.deletar(dados.idConsulta());
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoConsultaDTO>> listarConsultas(@PageableDefault(size = 10, sort = {"data"}) Pageable pageable){
        Page<DadosDetalhamentoConsultaDTO> page = consultaService.listar(pageable);
        return ResponseEntity.ok(page);
    }
}
