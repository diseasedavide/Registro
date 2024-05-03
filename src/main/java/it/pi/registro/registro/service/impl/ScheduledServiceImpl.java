package it.pi.registro.registro.service.impl;

import it.pi.registro.registro.service.ScheduledService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScheduledServiceImpl implements ScheduledService {
    @Override
    public void createReport() {
        System.out.println("Service called at " + LocalDateTime.now());
    }
}
