package med.voll.api.domain.paciente.repository;

import med.voll.api.domain.paciente.DTO.ListagemPacienteDTO;
import med.voll.api.domain.paciente.model.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<ListagemPacienteDTO> findAllByAtivoTrue(Pageable pageable);
}
