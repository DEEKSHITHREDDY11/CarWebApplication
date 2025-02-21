package com.MicroService.MicroService.repo;


import com.MicroService.MicroService.displayers.UserDetails;
import com.MicroService.MicroService.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer>
{
    Optional<Users> findAllByEmailidAndPassword (String emailid, String password);
    List<UserDetails> findAllByUserid (int Userid);

    @Query("SELECT u.status AS status FROM Users u WHERE u.userid = :userid")
    String getStatus (@Param("userid") Integer userid);

    @Query("SELECT u.type AS type FROM Users u WHERE u.userid = :userid")
    String getType(@Param("userid") Integer userid);

    Users findByUsername(String username);
}
