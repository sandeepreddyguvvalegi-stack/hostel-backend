package com.hostel.backend.controller;

import com.hostel.backend.model.Hostel;
import com.hostel.backend.service.HostelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hostels")
@CrossOrigin(origins = "*")
public class HostelController {

    @Autowired
    private HostelService service;

    // ===================================
    // GET ALL HOSTELS
    // ===================================

    @GetMapping
    public List<Hostel> getAllHostels() {

        return service.getAllHostels();

    }

    // ===================================
    // GET HOSTEL BY ID
    // ===================================

    @GetMapping("/{id}")
    public Hostel getHostelById(
            @PathVariable Long id
    ) {

        return service.getHostelById(id);

    }

    // ===================================
    // ADD HOSTEL
    // ===================================

    @PostMapping
    public Hostel addHostel(
            @RequestBody Hostel hostel
    ) {

        return service.addHostel(hostel);

    }

}
