package med.voll.api.domain.consulta.repository;

import med.voll.api.domain.consulta.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
    @Query("select c from Consulta c where c.medico.id = :medicoId and c.data = :data")
    List<Consulta> findByMedicoIdAndData(Long medicoId, LocalDateTime data);

    Boolean existsByMedicoIdAndDataAndAtivoTrue(Long medicoId, LocalDateTime data);

    Boolean existsByPacienteIdAndDataBetweenAndAtivoTrue(Long pacienteId, LocalDateTime primeiraData, LocalDateTime segundaData);
}
