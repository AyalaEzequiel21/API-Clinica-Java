package com.example.Clinica.Service;

import com.example.Clinica.Model.DTO.PacienteDto;

import java.util.Set;

public interface IPacienteService {

    void crearPaciente(PacienteDto pacienteDto);
    PacienteDto bucarPacientePorId(long id);
    void modificarOdontologo(PacienteDto pacienteDto);
    void eliminarPacientePorId(long id);
    Set<PacienteDto> listarTodos();
}
