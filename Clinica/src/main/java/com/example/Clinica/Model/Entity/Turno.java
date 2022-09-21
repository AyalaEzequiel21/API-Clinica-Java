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

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente" , referencedColumnName = "id", nullable = false)
    private Paciente paciente;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_odontologo" , referencedColumnName = "id", nullable = false)
    private Odontologo odontologo;
    private LocalDate fechaDelTurno;
}
