package med.voll.api.domain.consulta.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsultaDTO(Long id,
                                           Long pacienteId,
                                           Long medicoId,
                                           @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                           LocalDateTime data ) {
}
