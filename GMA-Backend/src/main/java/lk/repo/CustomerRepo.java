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

    @Query(value = "SELECT customerId FROM customer ORDER BY customerId DESC LIMIT 1", nativeQuery = true)
    String getCustomerLastID();

    @Query(value = "SELECT * FROM customer WHERE userName=:userName AND password=:password",nativeQuery = true)
    Customer login(@Param("userName") String userName,@Param("password") String password);

    @Query(value = "UPDATE customer SET verified='1' WHERE customerId=:id",nativeQuery = true)
    void verify(@Param("id") String id);
}
