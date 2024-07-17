package med.voll.api.medico.DTO;

import jakarta.validation.Valid;
import med.voll.api.endereco.DadosEndereco;

public record AtualizaMedicoDTO(Long id,
                                String nome,
                                String telefone,
                                @Valid
                                DadosEndereco endereco) {
}
