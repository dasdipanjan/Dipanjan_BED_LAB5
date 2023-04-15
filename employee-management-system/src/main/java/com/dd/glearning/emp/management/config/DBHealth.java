package com.dd.glearning.emp.management.config;

import com.dd.glearning.emp.management.repository.EmployeeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * This is an implementation class of {@link HealthIndicator} interface. This provides the health information about
 * underneath database of the application.
 *
 * @author Dipanjan Das
 * @version 1.0
 * @since 11-04-2023
 */
@Component
public class DBHealth implements HealthIndicator {
    @Autowired
    private EmployeeCrudRepository empRepository;

    @Override
    public Health health() {
        long empCount = this.empRepository.count();
        if (empCount < 0) {
            return Health.down().withDetail("DB Service ", "DB service is down").build();
        }
        return Health.up().withDetail("DB Service ", "DB service is up").build();
    }
}
