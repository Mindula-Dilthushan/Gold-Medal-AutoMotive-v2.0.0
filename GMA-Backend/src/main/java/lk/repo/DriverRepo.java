//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-16
package lk.repo;

import lk.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DriverRepo extends JpaRepository<Driver,String> {

    @Query(value = "SELECT COUNT(driverId) FROM Driver ",nativeQuery = true)
    int getDriverCount();

    @Query(value = "SELECT driverId FROM driver ORDER BY driverId DESC LIMIT 1", nativeQuery = true)
    String getDriverLastID();
}
