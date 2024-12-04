package com.example.pfaresrev.repositories;

import com.example.pfaresrev.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
