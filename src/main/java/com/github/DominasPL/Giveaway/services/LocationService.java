package com.github.DominasPL.Giveaway.services;

import com.github.DominasPL.Giveaway.domain.entities.Location;
import com.github.DominasPL.Giveaway.domain.repositories.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    private static final Logger logger = LoggerFactory.getLogger(LocationService.class);

    private LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getLocations() {
        return locationRepository.findAll();

    }

    public Location findLocationById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id nie może być null");
        }

        Optional<Location> locationOptional = locationRepository.findById(id);
        Location location = locationOptional.orElse(null);

        if (location == null) {
            logger.debug("Nie znaleziono lokalizacji");
            return null;
        }

        return location;
    }
}
