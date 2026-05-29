package com.hostel.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hostel.backend.model.Hostel;
import com.hostel.backend.repository.HostelRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class HostelController {

    @Autowired
    private HostelRepository hostelRepository;

    // GET ALL
    @GetMapping("/hostels")
    public List<Hostel> getAllHostels() {
        return hostelRepository.findAll();
    }

    // GET ONE
    @GetMapping("/hostels/{id}")
    public Hostel getHostel(@PathVariable Long id) {
        return hostelRepository.findById(id).orElse(null);
    }

    // ADD HOSTEL (FIXED)
    @PostMapping("/hostels")
    public ResponseEntity<?> addHostel(

            @RequestParam("name") String name,
            @RequestParam("location") String location,
            @RequestParam("price") Double price,
            @RequestParam("floors") int floors,
            @RequestParam("rooms") String rooms,
            @RequestParam("totalRooms") int totalRooms,
            @RequestParam("totalBeds") int totalBeds,
            @RequestParam("customBeds") String customBeds,
            @RequestParam("images") MultipartFile[] images
    ) {

        try {

            List<String> imagePaths = new ArrayList<>();

            // ✅ SAFE PATH (works in all systems)
            String uploadDir = System.getProperty("user.dir") + "/uploads/";

            File folder = new File(uploadDir);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // SAVE IMAGES
            for (MultipartFile file : images) {

                if (file.isEmpty()) continue;

                String fileName = System.currentTimeMillis()
                        + "_" + file.getOriginalFilename();

                File dest = new File(uploadDir + fileName);

                file.transferTo(dest);

                imagePaths.add("/uploads/" + fileName);
            }

            Hostel hostel = new Hostel();

            hostel.setName(name);
            hostel.setLocation(location);
            hostel.setPrice(price);
            hostel.setFloors(floors);
            hostel.setRooms(rooms);
            hostel.setTotalRooms(totalRooms);
            hostel.setTotalBeds(totalBeds);
            hostel.setCustomBeds(customBeds);

            hostel.setImages(
                    new ObjectMapper().writeValueAsString(imagePaths)
            );

            hostelRepository.save(hostel);

            return ResponseEntity.ok(hostel);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}