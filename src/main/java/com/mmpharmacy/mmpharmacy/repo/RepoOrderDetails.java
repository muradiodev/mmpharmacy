package com.mmpharmacy.mmpharmacy.repo;

import com.mmpharmacy.mmpharmacy.entity.OrderDetails;
import com.mmpharmacy.mmpharmacy.entity.Orders;
import com.mmpharmacy.mmpharmacy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Optional;

@Repository
public interface RepoOrderDetails extends JpaRepository<OrderDetails,Integer> {

    Optional<List<OrderDetails>> findAllBy();

}
