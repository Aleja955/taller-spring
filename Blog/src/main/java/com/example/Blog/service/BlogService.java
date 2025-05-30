package com.example.Blog.service;

import com.example.Blog.model.MiBlog;

import java.util.List;


public interface BlogService {

    List<MiBlog> obtenerDatos();

    MiBlog encontrarPorId(Long id);
    void save (MiBlog info);

    void deleteBlog(Long id);

    void editarBlog(Long id, MiBlog blogActualizado);

}

