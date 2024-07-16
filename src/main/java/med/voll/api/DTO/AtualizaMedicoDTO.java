package med.voll.api.DTO;

import jakarta.validation.Valid;
import med.voll.api.model.DadosEndereco;

public record AtualizaMedicoDTO(Long id,
                                String nome,
                                String telefone,
                                @Valid
                                DadosEndereco endereco) {
}
