package com.airsofka.infra.mongo.adapters;

import com.airsofka.flight.application.shared.ports.IFlightRepositoryPort;
import com.airsofka.flight.domain.flight.Flight;
import com.airsofka.infra.mongo.entities.FlightEntity;
import com.airsofka.infra.mongo.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MySQLAdapter implements IFlightRepositoryPort {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightAdapter flightAdapter;

    @Override
    public void saveFlight(Flight flight) {
    FlightEntity flightEntity = FlightAdapter.toEntity(flight);
    flightRepository.save(flightEntity);
    }

}
