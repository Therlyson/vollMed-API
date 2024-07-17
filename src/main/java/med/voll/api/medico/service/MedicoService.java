package med.voll.api.medico.service;

import med.voll.api.medico.DTO.AtualizaMedicoDTO;
import med.voll.api.medico.DTO.DadosMedicoDTO;
import med.voll.api.medico.DTO.ListagemMedicoDTO;
import med.voll.api.medico.model.Medico;
import med.voll.api.medico.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository repository;

    public void cadastrar(DadosMedicoDTO dados){
        repository.save(new Medico(dados));
    }

    public Page<ListagemMedicoDTO> listar(Pageable pageable){
        return repository.findAllByAtivoTrue(pageable).map(ListagemMedicoDTO::new);
    }

    public void atualizar(AtualizaMedicoDTO novoMedico){
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
    }

    public void deletar(Long id){
        Medico medico = repository.getReferenceById(id);
        medico.setAtivo(false);
    }
}
