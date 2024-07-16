package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.DTO.DadosMedicoDTO;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional //metodo de escrita precisa ter uma transação ativa
    public void cadastrarMedico(@RequestBody @Valid DadosMedicoDTO dados){
        repository.save(new Medico(dados));
    }
}