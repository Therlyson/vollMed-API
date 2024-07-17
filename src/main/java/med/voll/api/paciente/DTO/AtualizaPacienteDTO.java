package med.voll.api.paciente.DTO;

import jakarta.validation.Valid;
import med.voll.api.endereco.DadosEndereco;

public record AtualizaPacienteDTO(Long id, String nome, String telefone,
                                  @Valid
                                  DadosEndereco endereco) {
}
