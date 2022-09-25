package com.example.Clinica.Model.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_paciente" , referencedColumnName = "id")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_odontologo" , referencedColumnName = "id")
    private Odontologo odontologo;

    private LocalDate fechaDelTurno;

    public Turno() {
    }

    public Turno(Paciente paciente, Odontologo odontologo, LocalDate fechaDelTurno) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaDelTurno = fechaDelTurno;
    }

    public long getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public LocalDate getFechaDelTurno() {
        return fechaDelTurno;
    }

    public void setFechaDelTurno(LocalDate fechaDelTurno) {
        this.fechaDelTurno = fechaDelTurno;
    }
}
