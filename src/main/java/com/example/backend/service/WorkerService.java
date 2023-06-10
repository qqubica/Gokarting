package com.example.backend.service;

import com.example.backend.model.Worker;
import com.example.backend.repository.WorkerRepository;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.EnumSet;
import java.util.Random;

@Service
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class WorkerService {
    WorkerRepository workerRepository;
    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
        if (workerRepository.count() == 0) {
            populateWithRandomData(5);
            System.out.println("Populated worker repository with random data.");
        }
    }
    public void populateWithRandomData(int n) {
        String[] names = {"John", "Emma", "Michael", "Sophia", "William"};
        String[] lastNames = {"Smith", "Johnson", "Brown", "Taylor", "Anderson"};
        EnumSet<Worker.WorkerRole> roles = Worker.getWorkerRoles();

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            Worker worker = new Worker();

            // Generate random name and last name
            String name = names[random.nextInt(names.length)];
            String lastName = lastNames[random.nextInt(lastNames.length)];

            worker.setName(name);
            worker.setSurname(lastName);

            // Generate random email
            String email = name.toLowerCase() + "." + lastName.toLowerCase() + random.nextDouble() + "@example.com";
            worker.setEmail(email);

            // Generate random password
            String password = worker.getEmail() + "123";
            worker.setPassword(password);

            // Generate random work start date (within the last year)
            Date currentDate = new Date();
            long oneYearInMillis = 365L * 24 * 60 * 60 * 1000;
            long randomMillis = (long) (random.nextDouble() * oneYearInMillis);
            Date workStartDate = new Date(currentDate.getTime() - randomMillis);

            worker.setWorkStartDate(workStartDate);

            // Generate random worker role
            Worker.WorkerRole role = (Worker.WorkerRole)roles.toArray()[random.nextInt(roles.size())];
            worker.setWorkerRole(role);

            workerRepository.save(worker);
        }
    }
}