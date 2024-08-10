package med.voll.api.domain.medico.service;

import med.voll.api.domain.medico.DTO.AtualizaMedicoDTO;
import med.voll.api.domain.medico.DTO.DadosMedicoDTO;
import med.voll.api.domain.medico.model.Medico;
import med.voll.api.domain.medico.repository.MedicoRepository;
import med.voll.api.domain.medico.DTO.ListagemMedicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository repository;

    public Medico cadastrar(DadosMedicoDTO dados){
        Medico medico = new Medico(dados);
        repository.save(medico);
        return medico;
    }

    public Page<ListagemMedicoDTO> listar(Pageable pageable){
        return repository.findAllByAtivoTrue(pageable).map(ListagemMedicoDTO::new);
    }

    public Medico atualizar(AtualizaMedicoDTO novoMedico){
        Medico medico = repository.getReferenceById(novoMedico.id());
        if (novoMedico.nome() != null) {
            medico.setNome(novoMedico.nome());
        }
        if (novoMedico.telefone() != null) {
            medico.setTelefone(novoMedico.telefone());
        }
        if(novoMedico.endereco() != null){
            medico.getEndereco().atualizarEndereco(novoMedico.endereco());
        }
        return medico;
    }

    public void deletar(Long id){
        Medico medico = repository.getReferenceById(id);
        medico.setAtivo(false);
    }

    public Medico buscarPorId(Long id) {
        return repository.getReferenceById(id);
    }
}
