package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DTO.DadosAgendamentoDTO;
import med.voll.api.domain.consulta.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoConsulta{
    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoDTO dados){
        Boolean medicoPossuiConsultaNoHorario = consultaRepository.existsByMedicoIdAndData(dados.medicoId(), dados.data());
        if(medicoPossuiConsultaNoHorario){
            throw new ValidacaoException("Médico já possui consulta agendada para a data informada");
        }
    }
}
