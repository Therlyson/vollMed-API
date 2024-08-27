package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.DTO.DadosAgendamentoDTO;

public interface ValidadorAgendamentoConsulta {
    void validar(DadosAgendamentoDTO dados);
}
