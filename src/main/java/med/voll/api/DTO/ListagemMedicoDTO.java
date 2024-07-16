package med.voll.api.DTO;

import med.voll.api.model.Especialidade;
import med.voll.api.model.Medico;

public record ListagemMedicoDTO(String nome, String email, String crm, Especialidade especialidade) {
    public ListagemMedicoDTO(Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getEmail(), medico.getEspecialidade());
    }
}
