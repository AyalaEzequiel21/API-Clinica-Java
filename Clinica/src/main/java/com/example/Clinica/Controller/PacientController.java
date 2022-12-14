package com.example.Clinica.Controller;

import com.example.Clinica.Exception.ResourceNotFoundException;
import com.example.Clinica.Model.DTO.PacienteDto;
import com.example.Clinica.Model.Entity.Paciente;
import com.example.Clinica.Repository.IPacienteRepository;
import com.example.Clinica.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacientController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> crearPaciente(@RequestBody PacienteDto pacienteDto){
        pacienteService.crearPaciente(pacienteDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDto buscarPacientePorID(@PathVariable long id) throws ResourceNotFoundException {
        return pacienteService.bucarPacientePorId(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDto pacienteDto) throws ResourceNotFoundException {
        pacienteService.modificarOdontologo(pacienteDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPacientePorId(@PathVariable long id) throws ResourceNotFoundException {
        pacienteService.eliminarPacientePorId(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<PacienteDto> listarTodos(){
        return pacienteService.listarTodos();
    }
}
