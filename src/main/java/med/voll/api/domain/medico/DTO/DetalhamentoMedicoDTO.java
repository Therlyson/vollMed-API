package med.voll.api.domain.medico.DTO;

import med.voll.api.domain.medico.model.Especialidade;
import med.voll.api.domain.medico.model.Medico;
import med.voll.api.domain.endereco.Endereco;

public record DetalhamentoMedicoDTO(Long id, String nome, String email, String telefone, String crm, Especialidade especialidade,
                                    Endereco endereco, boolean ativo) {
    public DetalhamentoMedicoDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(),
            medico.getEndereco(), medico.isAtivo());
    }
}
