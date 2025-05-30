package com.example.Blog.repository;

import com.example.Blog.model.MiBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<MiBlog, Long> {

    @Query("SELECT m FROM MiBlog m")
    List<MiBlog> obtenerDatos();

}

//    MiBlog encontrarPorId(Long id);


//    MiBlog encontrarPorId(Long id);

//    List<MiBlog> obtenerDatos();
//    MiBlog encontrarPorId(Long id);
//    void save (MiBlog info);

