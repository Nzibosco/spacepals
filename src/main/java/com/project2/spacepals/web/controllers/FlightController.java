package com.project2.spacepals.web.controllers;

import com.project2.spacepals.entities.Flight;
import com.project2.spacepals.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private FlightService flightService;

    @Autowired
    public FlightController(FlightService service){
        super();
        this.flightService = service;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Flight addFlight(Flight newFlight){return flightService.addNewFlight(newFlight);}


}
