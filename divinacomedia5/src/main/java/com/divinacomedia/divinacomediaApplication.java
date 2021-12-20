package com.divinacomedia;
import com.divinacomedia.repository.crud.HairProductsCrudRepository;
import com.divinacomedia.repository.crud.OrderCrudRepository;
import com.divinacomedia.repository.crud.UserCrudRepository;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class divinacomediaApplication implements CommandLineRunner {

    @Autowired
    private HairProductsCrudRepository crudRepository;
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private OrderCrudRepository orderCrudRepository;

    public static void main(String[] args) {
        SpringApplication.run(divinacomediaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        crudRepository.deleteAll();
        userCrudRepository.deleteAll();
        orderCrudRepository.deleteAll(); 
    }
}
