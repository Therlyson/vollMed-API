package med.voll.api.paciente.DTO;

import med.voll.api.paciente.model.Paciente;

public record ListagemPacienteDTO(Long id, String nome, String email, String cpf) {
    public ListagemPacienteDTO(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
