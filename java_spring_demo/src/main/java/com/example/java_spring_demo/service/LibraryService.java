package com.example.java_spring_demo.service;

import com.example.java_spring_demo.entity.Library;
import com.example.java_spring_demo.repository.Libraryrepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    private final Libraryrepository libraryRepository;

    public LibraryService(Libraryrepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public Library createLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    public Optional<Library> getLibraryById(Long id) {
        return libraryRepository.findById(id);
    }

    public Library updateLibrary(Long id, Library library) {
        Library existingLibrary = libraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Library not found"));

        existingLibrary.setName(library.getName());
        existingLibrary.setLocation(library.getLocation());

        return libraryRepository.save(existingLibrary);
    }

    public void deleteLibrary(Long id) {
        if (!libraryRepository.existsById(id)) {
            throw new RuntimeException("Library not found");
        }

        libraryRepository.deleteById(id);
    }
}
