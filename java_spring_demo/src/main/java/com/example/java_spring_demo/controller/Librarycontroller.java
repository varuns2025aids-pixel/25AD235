package com.example.java_spring_demo.controller;

import com.example.java_spring_demo.entity.Library;
import com.example.java_spring_demo.service.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class Librarycontroller {

    private final LibraryService libraryService;

    public Librarycontroller(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public Library createLibrary(@RequestBody Library library) {
        return libraryService.createLibrary(library);
    }

    @GetMapping
    public List<Library> getAlllibraries() {
        return libraryService.getAllLibraries();
    }

    @GetMapping("/{id}")
    public Library getLibraryById(@PathVariable Long id) {
        return libraryService.getLibraryById(id)
                .orElseThrow(() -> new RuntimeException("Library not found"));
    }

    @PutMapping("/{id}")
    public Library updateLibrary(@PathVariable Long id, @RequestBody Library library) {
        return libraryService.updateLibrary(id, library);
    }

    @DeleteMapping("/{id}")
    public String deleteLibrary(@PathVariable Long id) {
        libraryService.deleteLibrary(id);
        return "Library with ID " + id + " deleted successfully";
    }
}