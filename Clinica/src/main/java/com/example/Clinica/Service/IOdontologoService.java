package com.example.Clinica.Service;

import com.example.Clinica.Model.DTO.OdontologoDto;

import java.util.Set;

public interface IOdontologoService {

    void crearOdontologo(OdontologoDto odontologoDto);
    OdontologoDto bucarOdontologoPorId(long id);
    void modificarOdontologo(OdontologoDto odontologoDto);
    void eliminarOdontologoPorId(long id);
    Set<OdontologoDto> listarTodos();
}
