package com.example.Clinica.Service;

import com.example.Clinica.Exception.ResourceNotFoundException;
import com.example.Clinica.Model.DTO.PacienteDto;

import java.util.Set;

public interface IPacienteService {

    void crearPaciente(PacienteDto pacienteDto);
    PacienteDto bucarPacientePorId(long id) throws ResourceNotFoundException;
    void modificarOdontologo(PacienteDto pacienteDto) throws ResourceNotFoundException;
    void eliminarPacientePorId(long id) throws ResourceNotFoundException;
    Set<PacienteDto> listarTodos();
}
