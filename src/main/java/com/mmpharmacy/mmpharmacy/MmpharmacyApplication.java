package com.mmpharmacy.mmpharmacy;

//import com.prethesis.controller.ControllerTicket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.security.SecureRandom;


@SpringBootApplication
public class MmpharmacyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmpharmacyApplication.class, args);

        System.out.println("Hello MMPharmacy");
    }

    protected static SecureRandom random = new SecureRandom();

    public static String generateToken() {

        long longToken = Math.abs(random.nextLong());
        String random = Long.toString(longToken, 16);
        System.out.println("asdfg:" + random);
        return ("asdfg:" + random);
    }

}
