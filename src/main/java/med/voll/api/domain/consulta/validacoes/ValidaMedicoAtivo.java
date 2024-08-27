package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DTO.DadosAgendamentoDTO;
import med.voll.api.domain.medico.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaMedicoAtivo implements ValidadorAgendamentoConsulta{
    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoDTO dados){
        if(dados.medicoId() == null){
            return;
        }
        var medico = medicoRepository.getReferenceById(dados.medicoId());
        if(!medico.isAtivo()){
            throw new ValidacaoException("Erro! Não é possivel agendar uma consulta para um médico inativo.");
        }
    }
}
