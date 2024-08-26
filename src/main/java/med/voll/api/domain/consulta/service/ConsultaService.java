package med.voll.api.domain.consulta.service;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DTO.DadosAgendamentoDTO;
import med.voll.api.domain.consulta.model.Consulta;
import med.voll.api.domain.consulta.repository.ConsultaRepository;
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

    public Consulta agendar(DadosAgendamentoDTO dados){
        if(!pacienteRepository.existsById(dados.pacienteId())){
            throw new ValidacaoException("Id do paciente não existe no banco de dados");
        }
        if(dados.medicoId() != null && !medicoRepository.existsById(dados.medicoId())){
            throw new ValidacaoException("Id do médico não existe no banco de dados");
        }

        var medico = escolherMedico(dados);
        var paciente = pacienteRepository.getReferenceById(dados.pacienteId());
        var consulta = new Consulta(null, paciente, medico, dados.data());

        return consultaRepository.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoDTO dados) {
        if(dados.medicoId() != null){
            Medico medico = medicoRepository.getReferenceById(dados.medicoId());
            List<Consulta> consultas = medicoRepository.findByMedicoIdAndData(medico.getId(), dados.data());
            if(!consultas.isEmpty()){
                throw new ValidacaoException("Médico já possui consulta agendada para a data informada");
            }
            return medico;
        }

        if(dados.especialidade() == null){
            throw new ValidacaoException("Especialidade é obrigatória quando não se informa o médico!");
        }

        return medicoRepository.findBySpecialtyRandomDoctorFreeOnDate(dados.especialidade(), dados.data());
    }
}
;