package com.example.demo1.controller;

import com.example.demo1.entity.Studententity;
import com.example.demo1.entity.LeaveRequest;
import com.example.demo1.service.LeaveRequestService;
import com.example.demo1.service.Studentservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class Studentcontroller {

    private final Studentservice studentService;
    private final LeaveRequestService leaveRequestService;

    public Studentcontroller(Studentservice studentService, LeaveRequestService leaveRequestService) {
        this.studentService = studentService;
        this.leaveRequestService = leaveRequestService;
    }

    @PostMapping
    public Studententity createStudent(@RequestBody Studententity student) {
        return studentService.createStudent(student);
    }

    @GetMapping
    public List<Studententity> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Studententity getStudentById(@PathVariable("id") Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Studententity updateStudent(@PathVariable("id") Long id, @RequestBody Studententity student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return "Employee with ID " + id + " deleted successfully";
    }

    @GetMapping("/{employeeId}/leaves")
    public List<LeaveRequest> getEmployeeLeaves(@PathVariable("employeeId") Long employeeId) {
        return leaveRequestService.getForEmployee(employeeId);
    }
}
