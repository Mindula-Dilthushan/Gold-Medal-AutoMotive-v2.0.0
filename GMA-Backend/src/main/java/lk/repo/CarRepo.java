//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-16
package lk.repo;

import lk.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepo extends JpaRepository<Car,String> {

    @Query(value = "SELECT COUNT(carId) FROM Car ",nativeQuery = true)
    int getCarCount();

    @Query(value = "SELECT carId FROM car ORDER BY carId DESC LIMIT 1", nativeQuery = true)
    String getCarLastID();

    @Query(value = "SELECT carRegistrationNumber FROM car ORDER BY carRegistrationNumber DESC LIMIT 1", nativeQuery = true)
    String getCarRegNoID();
}
