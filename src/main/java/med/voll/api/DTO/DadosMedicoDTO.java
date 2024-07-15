package med.voll.api.DTO;

import med.voll.api.model.Especialidade;
import med.voll.api.model.DadosEndereco;

public record DadosMedicoDTO(String nome, String email, String telefone, String crm,
                             Especialidade especialidade, DadosEndereco endereco) {
}
