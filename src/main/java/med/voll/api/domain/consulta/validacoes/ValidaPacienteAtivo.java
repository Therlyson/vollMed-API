package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DTO.DadosAgendamentoDTO;
import med.voll.api.domain.paciente.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaPacienteAtivo implements ValidadorAgendamentoConsulta{
    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DadosAgendamentoDTO dados){
        var paciente = pacienteRepository.getReferenceById(dados.pacienteId());
        if(!paciente.isAtivo()){
            throw new ValidacaoException("Erro! Não é possivel agendar uma consulta para um paciente inativo.");
        }
    }
}
