package med.voll.api.domain.consulta.DTO;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsultaDTO(Long id,
                                           Long pacienteId,
                                           Long medicoId,
                                           LocalDateTime data ) {
}
