package com.mmpharmacy.mmpharmacy.repo;

import com.mmpharmacy.mmpharmacy.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoOrderDetailsDTO extends JpaRepository<OrderDetails,Integer> {

    List<OrderDetails> findAll();

}
