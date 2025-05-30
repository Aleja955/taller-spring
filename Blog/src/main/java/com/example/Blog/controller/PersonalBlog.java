package com.example.Blog.controller;

import com.example.Blog.model.MiBlog;
import com.example.Blog.service.BlogServi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PersonalBlog {

    private final BlogServi service;

    public PersonalBlog(BlogServi service) {
        this.service = service;
    }

    // Obtener todos los posts
    @GetMapping
    public List<MiBlog> obtenerPosts() {
        return service.obtenerDatos();
    }

    // Obtener un post por ID
    @GetMapping("/{id}")
    public ResponseEntity<MiBlog> obtenerPorId(@PathVariable("id") Long id) {
        MiBlog post = service.encontrarPorId(id);
        if (post != null) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear uno nuevo
    @PostMapping
    public ResponseEntity<String> crearPost(@RequestBody MiBlog info) {
        service.save(info);
        return ResponseEntity.ok("Post creado con éxito");
    }

    // Editar
    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editarPost(@PathVariable Long id, @RequestBody MiBlog postActualizado) {
        try {
            service.editarBlog(id, postActualizado);
            return ResponseEntity.ok("Post actualizado con éxito");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> eliminarPost(@PathVariable Long id) {
        service.deleteBlog(id);
        return ResponseEntity.ok("Post eliminado con éxito");
    }
}
