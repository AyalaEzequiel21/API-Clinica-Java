package com.example.Clinica.Service;

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
    public OdontologoDto bucarOdontologoPorId(long id) {

        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDto odontologoDto = null;
        if(odontologo.isPresent()){
            odontologoDto = objectMapper.convertValue(odontologo, OdontologoDto.class);
        }
        return odontologoDto;
    }

    @Override
    public void modificarOdontologo(OdontologoDto odontologoDto) {
        guardarOdontologo(odontologoDto);
    }

    @Override
    public void eliminarOdontologoPorId(long id) {
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
