package com.mmpharmacy.mmpharmacy.repo;

import com.mmpharmacy.mmpharmacy.entity.OrderDetails;
import com.mmpharmacy.mmpharmacy.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Optional;

@Repository
public interface RepoOrderDetails extends JpaRepository<OrderDetails,Integer> {


//    @Query(name = "SELECT op.id, op.orderid, op.price, o.name as name, op.quantity\n" +
//            "FROM mmpharmacy.order_product op\n" +
//            "INNER JOIN mmpharmacy.product o\n" +
//            "ON op.productid = o.productid;", nativeQuery = true)
//    List<Optional> getAll();

}
