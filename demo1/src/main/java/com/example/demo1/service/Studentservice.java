package com.example.demo1.service;

import com.example.demo1.entity.Studententity;
import com.example.demo1.repository.Studentrepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Studentservice {

    private final Studentrepository studentRepository;

    public Studentservice(Studentrepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Studententity createStudent(Studententity student) {
        return studentRepository.save(student);
    }

    public List<Studententity> getAllStudents() {
        return studentRepository.findAll();
    }

    public Studententity getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public Studententity updateStudent(Long id, Studententity updatedStudent) {
        Studententity existing = getStudentById(id);
        existing.setName(updatedStudent.getName());
        existing.setEmail(updatedStudent.getEmail());
        existing.setDepartment(updatedStudent.getDepartment());
        existing.setSalary(updatedStudent.getSalary());
        return studentRepository.save(existing);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}