package com.sistemaevidencias.sistema_gestion_evidencias.controller;

import com.sistemaevidencias.sistema_gestion_evidencias.model.Evidencia;
import com.sistemaevidencias.sistema_gestion_evidencias.repository.EvidenciaRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EvidenciaController {

    private final EvidenciaRepository evidenciaRepository;

    public EvidenciaController(EvidenciaRepository evidenciaRepository) {
        this.evidenciaRepository = evidenciaRepository;
    }

    // Pantalla de Login (Control de acceso con usuario y contraseña)
    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    // Procesar Inicio de Sesión
    @PostMapping("/login")
    public String procesarLogin(@RequestParam("usuario") String usuario,
                                @RequestParam("password") String password,
                                HttpSession session,
                                Model model) {
        // Credenciales básicas de acceso para el administrador del taller
        if ("admin".equals(usuario) && "1234".equals(password)) {
            session.setAttribute("usuarioLogueado", usuario);
            return "redirect:/";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }

    // Cerrar Sesión
    @GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    // Vista Principal con Filtro/Consulta y Registro
    @GetMapping("/")
    public String listarEvidencias(@RequestParam(value = "categoria", required = false) String categoria,
                                   HttpSession session,
                                   Model model) {
        // Verificar sesión de usuario
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/login";
        }

        List<Evidencia> lista;
        if (categoria != null && !categoria.isEmpty()) {
            lista = evidenciaRepository.findAll().stream()
                    .filter(e -> e.getCategoria().equalsIgnoreCase(categoria))
                    .toList();
        } else {
            lista = evidenciaRepository.findAll();
        }

        model.addAttribute("evidencias", lista);
        model.addAttribute("nuevaEvidencia", new Evidencia());
        model.addAttribute("categoriaSeleccionada", categoria);
        return "index";
    }

    // Guardar Evidencia
    @PostMapping("/guardar")
    public String guardarEvidencia(@ModelAttribute("nuevaEvidencia") Evidencia evidencia, HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/login";
        }
        evidenciaRepository.save(evidencia);
        return "redirect:/";
    }

    // Eliminar Evidencia
    @GetMapping("/eliminar/{id}")
    public String eliminarEvidencia(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/login";
        }
        evidenciaRepository.deleteById(id);
        return "redirect:/";
    }
}