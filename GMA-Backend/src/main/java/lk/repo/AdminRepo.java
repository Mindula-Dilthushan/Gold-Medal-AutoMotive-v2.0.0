//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
package lk.repo;

import lk.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository<Admin,String> {
//    @Query(value = "SELECT COUNT(customerId) FROM Customer")
//    Admin adminCustomerCount();

}
