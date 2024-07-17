package med.voll.api.paciente.repository;

import med.voll.api.paciente.DTO.ListagemPacienteDTO;
import med.voll.api.paciente.model.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<ListagemPacienteDTO> findAllByAtivoTrue(Pageable pageable);
}
