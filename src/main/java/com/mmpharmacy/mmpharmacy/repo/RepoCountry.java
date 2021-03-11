package com.mmpharmacy.mmpharmacy.repo;

import com.mmpharmacy.mmpharmacy.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoCountry extends JpaRepository<Country, Integer> {

    List<Country> findAll();


}
