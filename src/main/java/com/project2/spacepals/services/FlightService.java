package com.project2.spacepals.services;

import com.project2.spacepals.entities.Flight;
import com.project2.spacepals.entities.FlightStatus;
import com.project2.spacepals.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class FlightService {

    private FlightRepository flightRepo;

    @Autowired
    public FlightService(FlightRepository repo){
        super();
        this.flightRepo = repo;
    }

    @Transactional
    public Flight addNewFlight(Flight newFlight){
        //Validation?

        newFlight.setFlightCost(sanitizeValue(newFlight.getFlightCost()));
        newFlight.setFlightStatus(FlightStatus.OPEN);
        return flightRepo.save(newFlight);
    }

    public double sanitizeValue(double amount){
        BigDecimal bd = new BigDecimal(amount).setScale(2, RoundingMode.DOWN);
        double formattedAmount = bd.doubleValue();
        return formattedAmount;
    }

}
