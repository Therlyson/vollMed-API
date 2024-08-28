package med.voll.api.domain.consulta.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.consulta.utils.MensagemCancelamento;

public record DadosCancelamentoConsultaDTO(
        @NotNull
        @JsonAlias("consulta_id")
        Long idConsulta,
        @NotNull
        @JsonAlias({"motivo", "motivo_cancelamento"})
        MensagemCancelamento mensagem) {
}
