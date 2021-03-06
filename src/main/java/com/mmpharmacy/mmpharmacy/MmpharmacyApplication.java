package com.mmpharmacy.mmpharmacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
public class MmpharmacyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmpharmacyApplication.class, args);

        System.out.println("Hello MMPharmacy");
    }

}
