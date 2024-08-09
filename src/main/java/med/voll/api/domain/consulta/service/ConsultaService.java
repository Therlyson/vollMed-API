package med.voll.api.domain.consulta.service;

import med.voll.api.domain.consulta.DTO.DadosAgendamentoDTO;
import med.voll.api.domain.consulta.model.Consulta;
import med.voll.api.domain.consulta.repository.ConsultaRepository;
import med.voll.api.domain.medico.repository.MedicoRepository;
import med.voll.api.domain.paciente.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoDTO dados){
        var medico = medicoRepository.findById(dados.medicoId()).get();
        var paciente = pacienteRepository.findById(dados.pacienteId()).get();
        var consulta = new Consulta(null, paciente, medico, dados.data());

        consultaRepository.save(consulta);
    }
}
