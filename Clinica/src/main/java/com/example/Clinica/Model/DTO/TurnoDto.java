package com.example.Clinica.Model.DTO;

import com.example.Clinica.Model.Entity.Odontologo;
import com.example.Clinica.Model.Entity.Paciente;

import java.time.LocalDate;
import java.util.Date;

public class TurnoDto {

    private long id;
    private PacienteDto paciente;
    private OdontologoDto odontologo;
    private LocalDate fechaDelTurno;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PacienteDto getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDto paciente) {
        this.paciente = paciente;
    }

    public OdontologoDto getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(OdontologoDto odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDate getFechaDelTurno() {
        return fechaDelTurno;
    }

    public void setFechaDelTurno(LocalDate fechaDelTurno) {
        this.fechaDelTurno = fechaDelTurno;
    }
}
