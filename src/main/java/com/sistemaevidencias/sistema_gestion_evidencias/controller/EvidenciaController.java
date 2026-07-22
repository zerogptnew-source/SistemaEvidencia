package com.sistemaevidencias.sistema_gestion_evidencias.controller;

import com.sistemaevidencias.sistema_gestion_evidencias.model.Evidencia;
import com.sistemaevidencias.sistema_gestion_evidencias.repository.EvidenciaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EvidenciaController {

    private final EvidenciaRepository evidenciaRepository;

    public EvidenciaController(EvidenciaRepository evidenciaRepository) {
        this.evidenciaRepository = evidenciaRepository;
    }

    // Ruta para ver la lista de evidencias y el formulario
    @GetMapping("/")
    public String listarEvidencias(Model model) {
        model.addAttribute("evidencias", evidenciaRepository.findAll());
        model.addAttribute("nuevaEvidencia", new Evidencia());
        return "index";
    }

    // Ruta para procesar el formulario y guardar una evidencia
    @PostMapping("/guardar")
    public String guardarEvidencia(@ModelAttribute("nuevaEvidencia") Evidencia evidencia) {
        evidenciaRepository.save(evidencia);
        return "redirect:/";
    }

    // Ruta para eliminar una evidencia por su ID
    @GetMapping("/eliminar/{id}")
    public String eliminarEvidencia(@PathVariable("id") Long id) {
        evidenciaRepository.deleteById(id);
        return "redirect:/";
    }
}