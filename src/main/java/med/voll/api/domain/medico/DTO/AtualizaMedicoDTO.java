package med.voll.api.domain.medico.DTO;

import jakarta.validation.Valid;
import med.voll.api.domain.endereco.DadosEndereco;

public record AtualizaMedicoDTO(Long id,
                                String nome,
                                String telefone,
                                @Valid
                                DadosEndereco endereco) {
}
