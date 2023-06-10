package com.example.backend.service;

import com.example.backend.repository.RideRepository;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class RideService {
    RideRepository rideRepository;
    @Autowired
    public RideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
        if (rideRepository.count() == 0) {
            populateWithRandomData();
            System.out.println("Populated ride repository with random data.");
        }
    }
    public void populateWithRandomData() {
//        String[] names = {"John", "Emma", "Michael", "Sophia", "William"};
//        String[] lastNames = {"Smith", "Johnson", "Brown", "Taylor", "Anderson"};
//        EnumSet<Ride.RideRole> roles = Ride.getRideRoles();
//
//        Random random = new Random();
//
//        for (int i = 0; i < 10; i++) {
//            Ride ride = new Ride();
//
//            // Generate random name and last name
//            String name = names[random.nextInt(names.length)];
//            String lastName = lastNames[random.nextInt(lastNames.length)];
//
//            ride.setName(name);
//            ride.setSurname(lastName);
//
//            // Generate random email
//            String email = name.toLowerCase() + "." + lastName.toLowerCase() + random.nextDouble() + "@example.com";
//            ride.setEmail(email);
//
//            // Generate random password
//            String password = ride.getEmail() + "123";
//            ride.setPassword(password);
//
//            // Generate random work start date (within the last year)
//            Date currentDate = new Date();
//            long oneYearInMillis = 365L * 24 * 60 * 60 * 1000;
//            long randomMillis = (long) (random.nextDouble() * oneYearInMillis);
//            Date workStartDate = new Date(currentDate.getTime() - randomMillis);
//
//            ride.setWorkStartDate(workStartDate);
//
//            // Generate random ride role
//            Ride.RideRole role = (Ride.RideRole)roles.toArray()[random.nextInt(roles.size())];
//            ride.setRideRole(role);
//
//            rideRepository.save(ride);
    }
}

