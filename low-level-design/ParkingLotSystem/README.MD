# Parking Lot Management System

## Problem Statement

Design a Parking Lot Management System that supports parking and unparking of vehicles in a multi-floor parking lot.

The system supports:

- Parking and unparking vehicles
- Automatic parking spot allocation
- Ticket generation
- Fare calculation based on parking duration and vehicle type
- Multiple floors and parking spot types
- Extensible allocation and pricing strategies

---

## Assumptions

- Multi-floor parking lot
- Dedicated spots for Bike, Car and Truck
- Vehicles can park only in matching spot types
- First Available Spot allocation strategy
- Hourly pricing strategy
- Parking ticket is mandatory for exit

---

## Design

### Entities

- ParkingLot
- ParkingFloor
- ParkingSpot
- Vehicle
- Ticket
- Receipt

### Design Patterns

- **Singleton** → ParkingLot
- **Strategy** → Spot Allocation & Fare Calculation

### Strategies Implemented

- FirstAvailableSpotAllocationStrategy
- HourlyFareCalculationStrategy

---

## Concurrency

- Thread-safe spot reservation using **AtomicBoolean**
- Thread-safe ticket management using **ConcurrentHashMap**
- Atomic parking spot allocation using `compareAndSet()`
- Atomic ticket removal during unparking

---

## Parking Flow

```text
Vehicle
   ↓
ParkingService
   ↓
Allocate Spot
   ↓
Generate Ticket
   ↓
Return Ticket
```

## Unparking Flow

```text
Vehicle Exit
     ↓
Validate Ticket
     ↓
Release Spot
     ↓
Calculate Fare
     ↓
Generate Receipt
```

---

## SOLID Principles

- SRP
- OCP
- DIP

---

## Features

- ✅ Multi-floor Parking Lot
- ✅ Vehicle Parking & Unparking
- ✅ Ticket Generation
- ✅ Receipt Generation
- ✅ Hourly Fare Calculation
- ✅ Strategy Pattern
- ✅ Singleton Pattern
- ✅ Constructor Injection
- ✅ Thread-safe Spot Allocation
- ✅ Concurrent Ticket Management
- ✅ Custom Exception Handling

---

## Current Limitations

- No payment integration
- No lost ticket handling
- No entry/exit gate abstraction
- No display board
- No database persistence

---

## Tech Stack

- Java
- Core Java Collections
- Java Concurrency (`AtomicBoolean`, `ConcurrentHashMap`)
- Object-Oriented Design
- SOLID Principles
- Strategy Pattern
- Singleton Pattern

---

## Author

Built as part of my Low-Level Design (LLD) practice to strengthen Java, OOP, SOLID, Design Patterns, and Concurrency
concepts.