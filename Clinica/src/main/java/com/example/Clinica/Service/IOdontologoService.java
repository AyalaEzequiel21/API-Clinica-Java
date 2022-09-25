package com.example.Clinica.Service;

import com.example.Clinica.Exception.ResourceNotFoundException;
import com.example.Clinica.Model.DTO.OdontologoDto;

import java.util.Set;

public interface IOdontologoService {

    void crearOdontologo(OdontologoDto odontologoDto);
    OdontologoDto bucarOdontologoPorId(long id) throws ResourceNotFoundException;
    void modificarOdontologo(OdontologoDto odontologoDto) throws ResourceNotFoundException;
    void eliminarOdontologoPorId(long id) throws ResourceNotFoundException;
    Set<OdontologoDto> listarTodos();
}
