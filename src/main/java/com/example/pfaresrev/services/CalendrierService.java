package com.example.pfaresrev.services;

import com.example.pfaresrev.entities.Calendrier;
import com.example.pfaresrev.repositories.CalendrierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendrierService {

    private final CalendrierRepository calendrierRepository;

    public CalendrierService(CalendrierRepository calendrierRepository) {
        this.calendrierRepository = calendrierRepository;
    }

    public List<Calendrier> getAllCalendriers() {
        return calendrierRepository.findAll();
    }


    public Calendrier createCalendrier(Calendrier calendrier) {
        return calendrierRepository.save(calendrier);
    }


    public Calendrier getCalendrierById(Long id) {
        Optional<Calendrier> calendrier = calendrierRepository.findById(id);
        return calendrier.orElseThrow(() -> new RuntimeException("Calendrier not found with id " + id));
    }


    public Calendrier updateCalendrier(Long id, Calendrier updatedCalendrier) {
        Calendrier existingCalendrier = getCalendrierById(id);
        existingCalendrier.setDate(updatedCalendrier.getDate());
        existingCalendrier.setHeure(updatedCalendrier.getHeure());
        existingCalendrier.setDescription(updatedCalendrier.getDescription());
        return calendrierRepository.save(existingCalendrier);
    }


    public void deleteCalendrier(Long id) {
        calendrierRepository.deleteById(id);
    }
}
