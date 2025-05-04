package com.prog.tp_mascotas.controller;

import com.prog.tp_mascotas.model.Mascota;
import com.prog.tp_mascotas.service.MascotaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {
    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    public List<Mascota> listarTodas() {
        return mascotaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Mascota> obtenerPorId(@PathVariable("id") int id) {
        return mascotaService.getById(id);
    }

    @PostMapping
    public void agregar(@Valid @RequestBody Mascota mascota) {mascotaService.save(mascota);}

    @PutMapping("/{id}")
    public void actualizar(@PathVariable("id") int id, @Valid @RequestBody Mascota nuevaMascota) {
        nuevaMascota.setMascota_id(id); // solamente seteo el ID para que el modelo haga la consulta con el ID para actualizar

        mascotaService.update(nuevaMascota);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") int id) {
        mascotaService.deleteById(id);
    }

    // manejo de excepciones genéricas
    @ExceptionHandler(Exception.class)
    public String manejarErrores(Exception e) {return "Error: " + e.getMessage();}
}
