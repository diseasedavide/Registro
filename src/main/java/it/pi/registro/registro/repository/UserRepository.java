package it.pi.registro.registro.repository;

import it.pi.registro.registro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Query("SELECT u from User u WHERE u.email = :email AND u.userType.type = :type ")
    User findByMailAndType(@Param("email") String email, @Param("type") String type);

    @Query("SELECT u from User u WHERE u.userDetail IS NULL")
    List<User> findUsersWhereDetailIsNull();
}
