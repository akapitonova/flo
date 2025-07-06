package com.kap.flowershop.back.repository;

import com.kap.flowershop.back.entity.CustomerOrder;
import com.kap.flowershop.front.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, String> {

    @Query("SELECT t FROM CustomerOrder t WHERE t.status IN (:statusList)")
    List<CustomerOrder> getCustomerOrders(@Param("statusList") Set<Status> statuses);

    @Query("SELECT t FROM CustomerOrder t WHERE t.status = :status AND t.user.userId=:userId")
    List<CustomerOrder> getCustomerOrdersForUser(@Param("status") Status status, @Param("userId") Long userId);
}
