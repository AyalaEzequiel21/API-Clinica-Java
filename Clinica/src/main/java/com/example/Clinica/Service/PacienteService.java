package com.example.Clinica.Service;

import com.example.Clinica.Exception.ResourceNotFoundException;
import com.example.Clinica.Model.DTO.DomicilioDto;
import com.example.Clinica.Model.DTO.OdontologoDto;
import com.example.Clinica.Model.DTO.PacienteDto;
import com.example.Clinica.Model.Entity.Domicilio;
import com.example.Clinica.Model.Entity.Odontologo;
import com.example.Clinica.Model.Entity.Paciente;
import com.example.Clinica.Repository.IDomicilioRepository;
import com.example.Clinica.Repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    IPacienteRepository pacienteRepository;

//    @Autowired
//    IDomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void crearPaciente(PacienteDto pacienteDto) {
        guardarPaciente(pacienteDto);
    }

    @Override
    public PacienteDto bucarPacientePorId(long id) throws ResourceNotFoundException {

        PacienteDto pacienteDto = null;
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(!paciente.isPresent()){
            throw new ResourceNotFoundException("El paciente no existe.");
        }
        pacienteDto = objectMapper.convertValue(paciente, PacienteDto.class);
        return pacienteDto;
    }

    @Override
    public void modificarOdontologo(PacienteDto pacienteDto) throws ResourceNotFoundException {
        if (!pacienteRepository.findById(pacienteDto.getId()).isPresent()){
            throw new ResourceNotFoundException("El paciente no existe");
        }
        guardarPaciente(pacienteDto);
    }

    @Override
    public void eliminarPacientePorId(long id) throws ResourceNotFoundException {
        if (!pacienteRepository.findById(id).isPresent()){
            throw new ResourceNotFoundException("Los datos ingresados no son validos.");
        }
        pacienteRepository.deleteById(id);
    }

    @Override
    public Set<PacienteDto> listarTodos() {
        List<Paciente> listaPacientes = pacienteRepository.findAll();
        Set<PacienteDto> lista = new HashSet<>();

        for (Paciente paciente : listaPacientes) {
            lista.add(objectMapper.convertValue(paciente, PacienteDto.class));
        }
        return lista;
    }

    public void guardarPaciente(PacienteDto pacienteDto){
        Paciente paciente = objectMapper.convertValue(pacienteDto, Paciente.class);
        pacienteRepository.save(paciente);
    }
}
