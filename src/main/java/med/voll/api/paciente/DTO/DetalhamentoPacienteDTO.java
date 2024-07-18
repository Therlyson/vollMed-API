package med.voll.api.paciente.DTO;

import med.voll.api.endereco.Endereco;
import med.voll.api.paciente.model.Paciente;

public record DetalhamentoPacienteDTO(Long id, String nome, String email, String telefone, String cpf, Endereco endereco, boolean ativo) {
    public DetalhamentoPacienteDTO(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco(), paciente.isAtivo());
    }
}