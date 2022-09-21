package com.example.Clinica.Repository;

import com.example.Clinica.Model.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
}
