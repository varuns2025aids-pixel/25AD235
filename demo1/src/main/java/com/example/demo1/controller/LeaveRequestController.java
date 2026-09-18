package com.example.demo1.controller;

import com.example.demo1.entity.LeaveRequest;
import com.example.demo1.service.LeaveRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/leaves")
public class LeaveRequestController {

    private final LeaveRequestService leaveRequestService;

    public LeaveRequestController(LeaveRequestService leaveRequestService) {
        this.leaveRequestService = leaveRequestService;
    }

    @PostMapping
    public LeaveRequest create(@RequestBody LeaveRequest leaveRequest) {
        return leaveRequestService.create(leaveRequest);
    }

    @GetMapping
    public List<LeaveRequest> getAll() {
        return leaveRequestService.getAll();
    }

    @PutMapping("/{id}/status")
    public LeaveRequest updateStatus(@PathVariable("id") Long id,
                                     @RequestBody Map<String, String> body) {
        return leaveRequestService.updateStatus(id, body.get("status"));
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        leaveRequestService.delete(id);
        return "Leave request with ID " + id + " deleted successfully";
    }
}
