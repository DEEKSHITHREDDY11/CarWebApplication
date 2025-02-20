package com.MicroService.MicroService.repo;


import com.MicroService.MicroService.displayers.CarDetails;
import com.MicroService.MicroService.displayers.CarDisplay;
import com.MicroService.MicroService.displayers.CarMap;
import com.MicroService.MicroService.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Cars,Integer>
{
    List<CarDisplay> findAllBy();
    List<CarDetails> findAllByCarid (int carid);

    @Query("SELECT c.user.userid AS userid, c.carid AS carid, c.carname AS carname, c.user.username AS username FROM Cars c WHERE c.user.userid IS NOT NULL")
    List<CarMap> findCarAndUserDetails();

    @Modifying
    @Query("UPDATE Cars c SET c.price  = :price WHERE c.carid = :carid")
    void updateCarPrice(@Param("carid") Integer carid, @Param("price") int price);

    @Query("SELECT c.carid AS carid,c.carname AS carname,c.user.userid AS userid,c.user.username AS username FROM Cars c WHERE c.user.userid = :userid")
    List<CarMap> findRentalDetails(@Param("userid") Integer userid);

    @Query("SELECT SUM(c.price) AS totalPrice, STRING_AGG(c.carname, ', ') AS carNames FROM Cars c WHERE c.user.userid = :userid")
    Object getRevenue (@Param("userid") Integer userid);

    @Modifying
    @Query("UPDATE Cars c SET c.user.userid = :userid WHERE c.carid = :carid")
    void getCart(@Param("userid") Integer userid , @Param("carid") Integer carid);

}
