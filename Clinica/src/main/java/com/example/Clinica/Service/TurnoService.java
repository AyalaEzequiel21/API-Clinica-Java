package com.example.Clinica.Service;

import com.example.Clinica.Model.DTO.TurnoDto;
import com.example.Clinica.Model.Entity.Turno;
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
    ObjectMapper objectMapper;

    @Override
    public void crearTurno(TurnoDto turnoDto) {
        guardarTurno(turnoDto);
    }

    @Override
    public TurnoDto bucarTurnoPorId(long id) {
        TurnoDto turnoDto = null;
        Optional<Turno> turno = turnoRepository.findById(id);
        if (turno.isPresent()){
            turnoDto = objectMapper.convertValue(turno, TurnoDto.class);
        }
        return turnoDto;
    }

    @Override
    public void modificarTurno(TurnoDto turnoDto) {
        guardarTurno(turnoDto);
    }

    @Override
    public void eliminarTurnoPorId(long id) {
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

    public void guardarTurno(TurnoDto turnoDto){
        Turno turno = objectMapper.convertValue(turnoDto, Turno.class);
        turnoRepository.save(turno);
    }
}
