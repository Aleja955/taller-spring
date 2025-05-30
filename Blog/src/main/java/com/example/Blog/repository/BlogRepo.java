//package com.example.Blog.repository;
//
//import com.example.Blog.model.MiBlog;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class BlogRepo implements BlogRepository{
//    public List<MiBlog> blog = new ArrayList<>();
//    @Override
//    public List<MiBlog> obtenerDatos() {
//        return blog;
//    }
//
//    @Override
//    public MiBlog encontrarPorId(Long id) {
//        for (MiBlog b : blog){
//            if (b.getId().equals(id)){
//                return b;}
//        }return null;
//    }
//
//    @Override
//    public void save(MiBlog info) {
//        blog.add(info);
//    }
//}
