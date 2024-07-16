package med.voll.api.DTO;

import med.voll.api.model.Especialidade;
import med.voll.api.model.Medico;

public record ListagemMedicoDTO(Long id, String nome, String email, String crm, Especialidade especialidade) {
    public ListagemMedicoDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
