package com.example.Clinica.Service;


import com.example.Clinica.Exception.BadRequestException;
import com.example.Clinica.Exception.ResourceNotFoundException;
import com.example.Clinica.Model.DTO.TurnoDto;

import java.util.Set;

public interface ITurnoService {

    void crearTurno(TurnoDto turnoDto) throws ResourceNotFoundException, BadRequestException;
    TurnoDto bucarTurnoPorId(long id) throws ResourceNotFoundException;
    void modificarTurno(TurnoDto turnoDto) throws ResourceNotFoundException, BadRequestException;
    void eliminarTurnoPorId(long id) throws ResourceNotFoundException;
    Set<TurnoDto> listarTodos();
}
