package med.voll.api.domain.paciente.DTO;

import jakarta.validation.Valid;
import med.voll.api.domain.endereco.DadosEndereco;

public record AtualizaPacienteDTO(Long id, String nome, String telefone,
                                  @Valid
                                  DadosEndereco endereco) {
}
