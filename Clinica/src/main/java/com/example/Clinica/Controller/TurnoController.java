package com.example.Clinica.Controller;

import com.example.Clinica.Model.DTO.TurnoDto;
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
    public ResponseEntity<?> crearTurno(@RequestBody TurnoDto turnoDto){
        turnoService.crearTurno(turnoDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public TurnoDto buscarTurnoPorId(@PathVariable Long id){
        return turnoService.bucarTurnoPorId(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarTurno(@RequestBody TurnoDto turnoDto){
        turnoService.crearTurno(turnoDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarTurno(Long id){
        ResponseEntity response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (turnoService.bucarTurnoPorId(id) != null){
            turnoService.eliminarTurnoPorId(id);
            response = new ResponseEntity<>(HttpStatus.OK);
        }
        return response;
    }

    @GetMapping
    public Collection<TurnoDto> listarTodos(){
        return turnoService.listarTodos();
    }
}
