//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-16
package lk.repo;

import lk.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer,String> {

    @Query(value = "SELECT customerId FROM customer ORDER BY customerId DESC LIMIT 1", nativeQuery = true)
    String getCustomerLastID();

    @Query(value = "SELECT COUNT(customerId) FROM Customer ",nativeQuery = true)
    int getCustomerCount();

    @Query(value = "SELECT customerDrivingLIC FROM customer ORDER BY customerDrivingLIC DESC LIMIT 1", nativeQuery = true)
    String getCustomerDLIC();
}
