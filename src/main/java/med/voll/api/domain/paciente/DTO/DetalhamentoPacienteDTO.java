package med.voll.api.domain.paciente.DTO;

import med.voll.api.domain.paciente.model.Paciente;
import med.voll.api.domain.endereco.Endereco;

public record DetalhamentoPacienteDTO(Long id, String nome, String email, String telefone, String cpf, Endereco endereco, boolean ativo) {
    public DetalhamentoPacienteDTO(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco(), paciente.isAtivo());
    }
}
