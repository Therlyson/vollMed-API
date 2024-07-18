package med.voll.api.medico.DTO;

import med.voll.api.endereco.Endereco;
import med.voll.api.medico.model.Especialidade;
import med.voll.api.medico.model.Medico;

public record DetalhamentoMedicoDTO(Long id, String nome, String email, String telefone, String crm, Especialidade especialidade,
                                    Endereco endereco, boolean ativo) {
    public DetalhamentoMedicoDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(),
            medico.getEndereco(), medico.isAtivo());
    }
}
