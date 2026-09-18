package com.example.demo1.service;

import com.example.demo1.entity.LeaveRequest;
import com.example.demo1.entity.Studententity;
import com.example.demo1.repository.LeaveRequestRepository;
import com.example.demo1.repository.Studentrepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestService {

    private final LeaveRequestRepository leaveRequestRepository;
    private final Studentrepository studentRepository;

    public LeaveRequestService(LeaveRequestRepository leaveRequestRepository,
                               Studentrepository studentRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
        this.studentRepository = studentRepository;
    }

    public LeaveRequest create(LeaveRequest leaveRequest) {
        if (leaveRequest.getStudent() == null || leaveRequest.getStudent().getId() == null) {
            throw new IllegalArgumentException("A valid student.id is required");
        }

        Studententity student = studentRepository.findById(leaveRequest.getStudent().getId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Employee not found with id: " + leaveRequest.getStudent().getId()));

        leaveRequest.setStudent(student);
        if (leaveRequest.getStatus() == null || leaveRequest.getStatus().isBlank()) {
            leaveRequest.setStatus("PENDING");
        }
        return leaveRequestRepository.save(leaveRequest);
    }

    public List<LeaveRequest> getAll() {
        return leaveRequestRepository.findAll();
    }

    public List<LeaveRequest> getForEmployee(Long employeeId) {
        if (!studentRepository.existsById(employeeId)) {
            throw new IllegalArgumentException("Employee not found with id: " + employeeId);
        }
        return leaveRequestRepository.findByStudent_Id(employeeId);
    }

    public LeaveRequest updateStatus(Long id, String status) {
        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException("status is required");
        }

        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Leave request not found with id: " + id));
        leaveRequest.setStatus(status);
        return leaveRequestRepository.save(leaveRequest);
    }

    public void delete(Long id) {
        if (!leaveRequestRepository.existsById(id)) {
            throw new IllegalArgumentException("Leave request not found with id: " + id);
        }
        leaveRequestRepository.deleteById(id);
    }
}
