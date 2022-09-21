package com.example.Clinica.Controller;

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
    public OdontologoDto buscarOdotologoPorId(@PathVariable Long id){
        return odontologoService.bucarOdontologoPorId(id);
    }

    @PutMapping
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDto odontologoDto){
        odontologoService.modificarOdontologo(odontologoDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id){
        ResponseEntity response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if(odontologoService.bucarOdontologoPorId(id) != null){
            odontologoService.eliminarOdontologoPorId(id);
            response = (new ResponseEntity<>(HttpStatus.OK));
        }
        return response;
    }

    @GetMapping
    public Collection<OdontologoDto> listarTodos(){
        return odontologoService.listarTodos();
    }
}
