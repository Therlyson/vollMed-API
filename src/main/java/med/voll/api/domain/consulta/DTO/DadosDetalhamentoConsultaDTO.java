package med.voll.api.domain.consulta.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import med.voll.api.domain.consulta.model.Consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsultaDTO(Long id, Long pacienteId, Long medicoId,
                                           @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                           LocalDateTime data ) {
    public DadosDetalhamentoConsultaDTO(Consulta consulta) {
        this(consulta.getId(), consulta.getPaciente().getId(), consulta.getMedico().getId(), consulta.getData());
    }
}
