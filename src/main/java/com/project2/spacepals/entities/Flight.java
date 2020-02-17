package com.project2.spacepals.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="FLIGHTS")
@SequenceGenerator(name="flight_seq_gen", sequenceName = "flight_seq", allocationSize = 1)
public class Flight {

    @Id
    @Column(name="flight_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name="available_seats", nullable = false)
    private int availableSeats;

    @Column(name="total_seats", nullable = false)
    private int totalSeats;

    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    private Company company;

    @Column(name="flight_duration")
    private String flightDuration;

    @Column(name="arrival_time")
    private Timestamp arrivalTime;

    @Column(name = "departure_time")
    private Timestamp departureTime;

    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    private Planet flightDestination;

    @JoinColumn
    @ManyToOne(cascade = CascadeType.ALL)
    private Planet flightDeparturePoint;

    @Column(name="flight_cost")
    private double flightCost;

    @Enumerated(EnumType.ORDINAL)
    private FlightStatus flightStatus;

    @JoinTable(name = "USERS_FLIGHTS", joinColumns = @JoinColumn(name="flight_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Users> passengers ;

    public Flight(){
        super();
    }

    public Flight(int availableSeats, int totalSeats, Company company, String flightDuration, Timestamp arrivalTime, Timestamp departureTime, Planet flightDestination, Planet flightDeparturePoint, double flightCost, FlightStatus flightStatus, List<Users> passengers) {
        this.availableSeats = availableSeats;
        this.totalSeats = totalSeats;
        this.company = company;
        this.flightDuration = flightDuration;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.flightDestination = flightDestination;
        this.flightDeparturePoint = flightDeparturePoint;
        this.flightCost = flightCost;
        this.flightStatus = flightStatus;
        this.passengers = passengers;
    }

    public Flight(int id, int availableSeats, int totalSeats, Company company, String flightDuration, Timestamp arrivalTime, Timestamp departureTime, Planet flightDestination, Planet flightDeparturePoint, double flightCost, FlightStatus flightStatus) {
        this.id = id;
        this.availableSeats = availableSeats;
        this.totalSeats = totalSeats;
        this.company = company;
        this.flightDuration = flightDuration;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.flightDestination = flightDestination;
        this.flightDeparturePoint = flightDeparturePoint;
        this.flightCost = flightCost;
        this.flightStatus = flightStatus;
    }

    public Flight(int id, int availableSeats, int totalSeats, Company company, String flightDuration, Timestamp arrivalTime, Timestamp departureTime, Planet flightDestination, Planet flightDeparturePoint, double flightCost, FlightStatus flightStatus, List<Users> passengers) {
        this.id = id;
        this.availableSeats = availableSeats;
        this.totalSeats = totalSeats;
        this.company = company;
        this.flightDuration = flightDuration;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.flightDestination = flightDestination;
        this.flightDeparturePoint = flightDeparturePoint;
        this.flightCost = flightCost;
        this.flightStatus = flightStatus;
        this.passengers = passengers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(String flightDuration) {
        this.flightDuration = flightDuration;
    }

    public Planet getFlightDestination() {
        return flightDestination;
    }

    public void setFlightDestination(Planet flightDestination) {
        this.flightDestination = flightDestination;
    }

    public Planet getFlightDeparturePoint() {
        return flightDeparturePoint;
    }

    public void setFlightDeparturePoint(Planet flightDeparturePoint) {
        this.flightDeparturePoint = flightDeparturePoint;
    }

    public double getFlightCost() {
        return flightCost;
    }

    public void setFlightCost(double flightCost) {
        this.flightCost = flightCost;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public List<Users> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Users> passengers) {
        this.passengers = passengers;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public void addPassenger(Users... passenger) {
        if (passenger == null) passengers = new ArrayList<>();
        for (Users p : passenger) {
            passengers.add(p);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id &&
                availableSeats == flight.availableSeats &&
                totalSeats == flight.totalSeats &&
                Double.compare(flight.flightCost, flightCost) == 0 &&
                Objects.equals(company, flight.company) &&
                Objects.equals(flightDuration, flight.flightDuration) &&
                Objects.equals(arrivalTime, flight.arrivalTime) &&
                Objects.equals(departureTime, flight.departureTime) &&
                Objects.equals(flightDestination, flight.flightDestination) &&
                Objects.equals(flightDeparturePoint, flight.flightDeparturePoint) &&
                flightStatus == flight.flightStatus &&
                Objects.equals(passengers, flight.passengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, availableSeats, totalSeats, company, flightDuration, arrivalTime, departureTime, flightDestination, flightDeparturePoint, flightCost, flightStatus, passengers);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", availableSeats=" + availableSeats +
                ", totalSeats=" + totalSeats +
                ", company=" + company +
                ", flightDuration='" + flightDuration + '\'' +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", flightDestination=" + flightDestination +
                ", flightDeparturePoint=" + flightDeparturePoint +
                ", flightCost=" + flightCost +
                ", flightStatus=" + flightStatus +
                ", passengers=" + passengers +
                '}';
    }
}
