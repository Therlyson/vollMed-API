package med.voll.api.domain.consulta.service;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DTO.DadosAgendamentoDTO;
import med.voll.api.domain.consulta.model.Consulta;
import med.voll.api.domain.consulta.repository.ConsultaRepository;
import med.voll.api.domain.consulta.validacoes.ValidadorAgendamentoConsulta;
import med.voll.api.domain.medico.model.Medico;
import med.voll.api.domain.medico.repository.MedicoRepository;
import med.voll.api.domain.paciente.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoConsulta> validadores;

    public Consulta agendar(DadosAgendamentoDTO dados){
        if(!pacienteRepository.existsById(dados.pacienteId())){
            throw new ValidacaoException("Id do paciente não existe no banco de dados");
        }
        if(dados.medicoId() != null && !medicoRepository.existsById(dados.medicoId())){
            throw new ValidacaoException("Id do médico não existe no banco de dados");
        }
        validadores.forEach(v -> v.validar(dados)); //dessa forma testa todos os métodos VALIDAR das classes que implementam essa interface

        var medico = escolherMedico(dados);
        if(medico == null){
            throw new ValidacaoException("Não foi possível encontrar um médico disponível para a data informada");
        }
        var paciente = pacienteRepository.getReferenceById(dados.pacienteId());
        var consulta = new Consulta(null, paciente, medico, dados.data());
        return consultaRepository.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoDTO dados) {
        if(dados.medicoId() != null){
            Medico medico = medicoRepository.getReferenceById(dados.medicoId());
            return medico;
        }

        if(dados.especialidade() == null){
            throw new ValidacaoException("Especialidade é obrigatória quando não se informa o médico!");
        }
        return medicoRepository.findBySpecialtyRandomDoctorFreeOnDate(dados.especialidade(), dados.data());
    }
}
;