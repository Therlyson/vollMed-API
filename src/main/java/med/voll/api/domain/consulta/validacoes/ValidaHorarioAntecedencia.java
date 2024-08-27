package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DTO.DadosAgendamentoDTO;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
@Component
public class ValidaHorarioAntecedencia implements ValidadorAgendamentoConsulta{

    public void validar(DadosAgendamentoDTO dados){
        var dataConsulta = dados.data();
        var dataAtual = LocalDateTime.now();
        var diferenca = Duration.between(dataAtual, dataConsulta).toMinutes();

        if(diferenca < 30){
            throw new ValidacaoException("Erro! Não é possivel agendar uma consulta com menos de 30 minutos de antecedência.");
        }
    }
}
