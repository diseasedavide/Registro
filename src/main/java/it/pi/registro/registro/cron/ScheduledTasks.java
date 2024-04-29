package it.pi.registro.registro.cron;

import it.pi.registro.registro.entity.User;
import it.pi.registro.registro.service.ScheduledService;
import it.pi.registro.registro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class ScheduledTasks {

    @Autowired
    private ScheduledService scheduledService;

    @Autowired
    private UserService userService;

    @Scheduled(cron = "0 * * * * *")
    public void execute() {
        scheduledService.createReport();
        long unixTimestamp = System.currentTimeMillis() / 1000L;
        System.out.println("REPORT_" + unixTimestamp);

//        File report = new File("REPORT_" + unixTimestamp + ".txt");
//        try {
//            FileWriter fileWriter = new FileWriter(report);
//
//            for(User u : userService.getUsersWithoutDetails()) {
//                fileWriter.append(u.getFirstName() + " " + u.getLastName() + "\n");
//            }
//            fileWriter.flush();
//            fileWriter.close();
//        } catch (IOException e) {
//            System.out.println("Error creating file");
//            e.printStackTrace();
//        }
    }


}
