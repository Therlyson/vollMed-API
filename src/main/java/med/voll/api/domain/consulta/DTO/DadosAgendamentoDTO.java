package med.voll.api.domain.consulta.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.model.Especialidade;

import java.time.LocalDateTime;

public record DadosAgendamentoDTO(
        @NotNull
        @JsonAlias("paciente_id")
        Long pacienteId,
        @JsonAlias("medico_id")
        Long medicoId,
        @NotNull
        @Future
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime data,
        Especialidade especialidade) {
}
