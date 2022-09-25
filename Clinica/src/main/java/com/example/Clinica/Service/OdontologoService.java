package com.example.Clinica.Service;

import com.example.Clinica.Exception.ResourceNotFoundException;
import com.example.Clinica.Model.DTO.OdontologoDto;
import com.example.Clinica.Model.Entity.Odontologo;
import com.example.Clinica.Repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService{

    @Autowired
    IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper objectMapper;


    @Override
    public void crearOdontologo(OdontologoDto odontologoDto) {
        guardarOdontologo(odontologoDto);
    }

    @Override
    public OdontologoDto bucarOdontologoPorId(long id) throws ResourceNotFoundException {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        if(!odontologo.isPresent()){
            throw new ResourceNotFoundException("El odontologo no existe");
        }
        OdontologoDto odontologoDto = objectMapper.convertValue(odontologo, OdontologoDto.class);
        return odontologoDto;
    }

    @Override
    public void modificarOdontologo(OdontologoDto odontologoDto) throws ResourceNotFoundException {
        if (!odontologoRepository.findById(odontologoDto.getId()).isPresent()){
            throw new ResourceNotFoundException("El odonotologo no existe");
        }
        guardarOdontologo(odontologoDto);
    }

    @Override
    public void eliminarOdontologoPorId(long id) throws ResourceNotFoundException {
        if (!odontologoRepository.findById(id).isPresent()){
            throw new ResourceNotFoundException("Los datos ingresados no son validos.");
        }
        odontologoRepository.deleteById(id);
    }

    @Override
    public Set<OdontologoDto> listarTodos() {
        Set<OdontologoDto> lista = new HashSet<>();
        List<Odontologo> ListaOdontologos = odontologoRepository.findAll();
        for (Odontologo odontologo : ListaOdontologos) {
            lista.add(objectMapper.convertValue(odontologo, OdontologoDto.class));
        }
        return lista;
    }

    public void guardarOdontologo(OdontologoDto odontologoDto){
        Odontologo odontologo = objectMapper.convertValue(odontologoDto, Odontologo.class);
        odontologoRepository.save(odontologo);
    }
}
