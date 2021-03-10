package com.mmpharmacy.mmpharmacy;

import com.mmpharmacy.mmpharmacy.entity.Supplier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@ComponentScan(basePackageClasses = Supplier.class)
//@EnableJpaRepositories(basePackages = "com.mmpharmacy.mmpharmacy.repo")
//@EnableJpaAuditing
@EnableJpaRepositories
@SpringBootApplication
public class MmpharmacyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MmpharmacyApplication.class, args);
    }
}
