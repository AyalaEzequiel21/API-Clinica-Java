package com.example.Clinica.Service;


import com.example.Clinica.Model.DTO.TurnoDto;

import java.util.Set;

public interface ITurnoService {

    void crearTurno(TurnoDto turnoDto);
    TurnoDto bucarTurnoPorId(long id);
    void modificarTurno(TurnoDto turnoDto);
    void eliminarTurnoPorId(long id);
    Set<TurnoDto> listarTodos();
}
