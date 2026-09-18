package com.example.java_spring_demo.repository;
import com.example.java_spring_demo.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Libraryrepository extends JpaRepository<Library,Long> {

}
