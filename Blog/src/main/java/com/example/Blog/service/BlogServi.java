package com.example.Blog.service;

import com.example.Blog.model.MiBlog;
import com.example.Blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServi implements BlogService{

    private final BlogRepository blogRepository;

    @Autowired
    public BlogServi(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    @Override
    public List<MiBlog> obtenerDatos() {
      return blogRepository.obtenerDatos();
    }

    @Override
    public MiBlog encontrarPorId(Long id) {
        return null;
    }

    public MiBlog obtenerBlogPorId(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog no encontrado"));
    }

    @Override
    public void save(MiBlog info) {
        blogRepository.save(info);
    }

    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);

    }

    @Override
    public void editarBlog(Long id, MiBlog blogActualizado) {
        //Saber si existe
        MiBlog blogExistente = blogRepository.findById(id).orElse(null);

        if(blogExistente != null) {
            //Actualizar los cargos de blog existente
            blogExistente.setContenido(blogActualizado.getContenido());
            blogExistente.setTitulo(blogActualizado.getTitulo());

            //Guardo al blog actualizado
            blogRepository.save(blogExistente);
        } else {
            throw new RuntimeException("Blog no encontrado con el id " + id);
        }

    }

}
