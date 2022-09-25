package com.example.Clinica.Controller;

import com.example.Clinica.Exception.ResourceNotFoundException;
import com.example.Clinica.Model.DTO.OdontologoDto;
import com.example.Clinica.Service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?> registrarOdontologo(@RequestBody OdontologoDto odontologoDto){
        odontologoService.guardarOdontologo(odontologoDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDto buscarOdotologoPorId(@PathVariable Long id) throws ResourceNotFoundException {
        return odontologoService.bucarOdontologoPorId(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDto odontologoDto) throws ResourceNotFoundException {
        odontologoService.modificarOdontologo(odontologoDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        odontologoService.eliminarOdontologoPorId(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public Collection<OdontologoDto> listarTodos(){
        return odontologoService.listarTodos();
    }
}
