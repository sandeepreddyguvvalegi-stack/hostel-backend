package com.hostel.backend.service;

import com.hostel.backend.model.Hostel;
import com.hostel.backend.repository.HostelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostelService {

    @Autowired
    private HostelRepository repository;

    // =========================
    // GET ALL HOSTELS
    // =========================
    public List<Hostel> getAllHostels() {
        return repository.findAll();
    }

    // =========================
    // GET HOSTEL BY ID
    // =========================
    public Hostel getHostelById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // =========================
    // ADD HOSTEL
    // =========================
    public Hostel addHostel(Hostel hostel) {

        // -------------------------
        // INITIAL BOOKING VALUES
        // -------------------------

        hostel.setBookedBeds(0);

        // available beds = total beds initially
        hostel.setAvailableBeds(
                hostel.getTotalBeds()
        );

        // -------------------------
        // OCCUPANCY CALCULATION
        // -------------------------

        if (hostel.getTotalBeds() > 0) {

            double occupancy =
                    ((double) hostel.getBookedBeds()
                            / hostel.getTotalBeds()) * 100;

            hostel.setOccupancyPercentage(occupancy);

        } else {

            hostel.setOccupancyPercentage(0);

        }

        // -------------------------
        // SAVE TO DATABASE
        // -------------------------

        return repository.save(hostel);
    }

}
