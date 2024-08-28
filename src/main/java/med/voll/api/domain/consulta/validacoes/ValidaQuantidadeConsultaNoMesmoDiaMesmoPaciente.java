package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DTO.DadosAgendamentoDTO;
import med.voll.api.domain.consulta.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaQuantidadeConsultaNoMesmoDiaMesmoPaciente implements ValidadorAgendamentoConsulta{
    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoDTO dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsulta = consultaRepository.existsByPacienteIdAndDataBetweenAndAtivoTrue(dados.pacienteId(), primeiroHorario, ultimoHorario);
        if(pacientePossuiOutraConsulta){
            throw new ValidacaoException("Erro! Paciente já possui consulta nesse dia");
        }
    }
}
