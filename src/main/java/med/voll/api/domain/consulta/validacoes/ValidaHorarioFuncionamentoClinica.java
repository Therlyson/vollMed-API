package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DTO.DadosAgendamentoDTO;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
@Component
public class ValidaHorarioFuncionamentoClinica implements ValidadorAgendamentoConsulta{

    public void validar(DadosAgendamentoDTO dados){
        var domingo = dados.data().getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDoHorarioFuncionamento = dados.data().getHour() < 7;
        var depoisDoHorarioFuncionamento = dados.data().getHour() > 18;

        if(domingo || antesDoHorarioFuncionamento || depoisDoHorarioFuncionamento){
            throw new ValidacaoException("Erro! Não é possivel agendar uma consulta fora do horário de funcionamento.");
        }
    }
}
