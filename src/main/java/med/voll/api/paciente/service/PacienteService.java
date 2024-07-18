package med.voll.api.paciente.service;

import med.voll.api.paciente.DTO.AtualizaPacienteDTO;
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

    public Paciente cadastrar(DadosPacienteDTO paciente){
        Paciente pacienteCdastro = new Paciente(paciente);
        pacienteRepository.save(pacienteCdastro);
        return pacienteCdastro;
    }

    public Page<ListagemPacienteDTO> listar(Pageable pageable){
        return pacienteRepository.findAllByAtivoTrue(pageable);
    }

    public Paciente atualizar(AtualizaPacienteDTO dados) {
        Paciente paciente = pacienteRepository.getReferenceById(dados.id());

        if(dados.nome() != null){
            paciente.setNome(dados.nome());
        }
        if(dados.telefone() != null){
            paciente.setTelefone(dados.telefone());
        }
        if(dados.endereco() != null){
            paciente.getEndereco().atualizarEndereco(dados.endereco());
        }
        return paciente;
    }

    public void desativar(Long id){
        Paciente paciente = pacienteRepository.getReferenceById(id);
        paciente.setAtivo(false);
    }

    public Paciente buscarPorId(Long id) {
        return pacienteRepository.getReferenceById(id);
    }
}