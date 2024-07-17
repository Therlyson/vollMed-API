package med.voll.api.paciente.service;

import med.voll.api.paciente.DTO.DadosPacienteDTO;
import med.voll.api.paciente.DTO.ListagemPacienteDTO;
import med.voll.api.paciente.model.Paciente;
import med.voll.api.paciente.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public void cadastrar(DadosPacienteDTO paciente){
        pacienteRepository.save(new Paciente(paciente));
    }

    public Page<ListagemPacienteDTO> listar(Pageable pageable){
        return pacienteRepository.findAllByAtivoTrue(pageable);
    }
}
