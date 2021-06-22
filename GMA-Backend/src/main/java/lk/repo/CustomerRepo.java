//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-16
package lk.repo;

import lk.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepo extends JpaRepository<Customer,String> {

    @Query(value = "SELECT * FROM customer WHERE customerEmail=:customerEmail AND customerPassword=:customerPassword",nativeQuery = true)
    Customer customerLogin(@Param("customerEmail") String custEmail, @Param("customerPassword") String custPassword);
}
