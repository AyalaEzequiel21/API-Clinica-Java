package com.example.Clinica.Service;

import com.example.Clinica.Exception.BadRequestException;
import com.example.Clinica.Exception.ResourceNotFoundException;
import com.example.Clinica.Model.DTO.OdontologoDto;
import com.example.Clinica.Model.DTO.PacienteDto;
import com.example.Clinica.Model.DTO.TurnoDto;
import com.example.Clinica.Model.Entity.Odontologo;
import com.example.Clinica.Model.Entity.Paciente;
import com.example.Clinica.Model.Entity.Turno;
import com.example.Clinica.Repository.IOdontologoRepository;
import com.example.Clinica.Repository.IPacienteRepository;
import com.example.Clinica.Repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    ITurnoRepository turnoRepository;

    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void crearTurno(TurnoDto turnoDto) throws ResourceNotFoundException, BadRequestException {
        guardarTurno(turnoDto);
    }

    @Override
    public TurnoDto bucarTurnoPorId(long id) throws ResourceNotFoundException {
        TurnoDto turnoDto = null;
        Optional<Turno> turno = turnoRepository.findById(id);
        if (!turno.isPresent()){
            throw new ResourceNotFoundException("Los datos ingresados no son validos.");
        }
        turnoDto = objectMapper.convertValue(turno, TurnoDto.class);
        return turnoDto;
    }

    @Override
    public void modificarTurno(TurnoDto turnoDto) throws ResourceNotFoundException, BadRequestException {
        if (!turnoRepository.findById(turnoDto.getId()).isPresent()){
            throw new ResourceNotFoundException("El turno no existe");
        }
        guardarTurno(turnoDto);
    }

    @Override
    public void eliminarTurnoPorId(long id) throws ResourceNotFoundException{
        if(!turnoRepository.findById(id).isPresent()){
            throw new ResourceNotFoundException("Los datos ingresados no son validos.");
        }
        turnoRepository.deleteById(id);
    }

    @Override
    public Set<TurnoDto> listarTodos() {
        Set<TurnoDto> lista = new HashSet<>();
        List<Turno> listaTurnos = turnoRepository.findAll();

        for (Turno turno : listaTurnos) {
            lista.add(objectMapper.convertValue(turno, TurnoDto.class));
        }
        return lista;
    }

    public void guardarTurno(TurnoDto turnoDto) throws BadRequestException {
        PacienteDto paciente = turnoDto.getPaciente();
        OdontologoDto odontologo = turnoDto.getOdontologo();
        if (!pacienteRepository.findById(paciente.getId()).isPresent() || !odontologoRepository.findById(odontologo.getId()).isPresent()){
            throw new BadRequestException("Algunos de los datos no son validos");
        }
        Turno turno = objectMapper.convertValue(turnoDto, Turno.class);
        turnoRepository.save(turno);
    }
}
