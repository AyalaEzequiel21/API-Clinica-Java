package com.example.Clinica.Controller;

import com.example.Clinica.Exception.BadRequestException;
import com.example.Clinica.Exception.ResourceNotFoundException;
import com.example.Clinica.Model.DTO.OdontologoDto;
import com.example.Clinica.Model.DTO.PacienteDto;
import com.example.Clinica.Model.DTO.TurnoDto;
import com.example.Clinica.Service.OdontologoService;
import com.example.Clinica.Service.PacienteService;
import com.example.Clinica.Service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    TurnoService turnoService;

    @PostMapping
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDto turnoDto) throws ResourceNotFoundException, BadRequestException {
        turnoService.crearTurno(turnoDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TurnoDto buscarTurnoPorId(@PathVariable Long id) throws ResourceNotFoundException {
        return turnoService.bucarTurnoPorId(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoDto turnoDto) throws ResourceNotFoundException, BadRequestException {
        turnoService.modificarTurno(turnoDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id) throws ResourceNotFoundException {
        turnoService.eliminarTurnoPorId(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<TurnoDto> listarTodos(){
        return turnoService.listarTodos();
    }
}
