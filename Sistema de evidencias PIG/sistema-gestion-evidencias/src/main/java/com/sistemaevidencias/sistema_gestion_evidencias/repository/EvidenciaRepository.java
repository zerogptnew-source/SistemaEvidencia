package com.sistemaevidencias.sistema_gestion_evidencias.repository;

import com.sistemaevidencias.sistema_gestion_evidencias.model.Evidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvidenciaRepository extends JpaRepository<Evidencia, Long> {
}