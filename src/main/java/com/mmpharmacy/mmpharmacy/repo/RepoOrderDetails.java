package com.mmpharmacy.mmpharmacy.repo;

import com.mmpharmacy.mmpharmacy.entity.OrderDetails;
import com.mmpharmacy.mmpharmacy.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoOrderDetails extends JpaRepository<OrderDetails,Integer> {
       

}
