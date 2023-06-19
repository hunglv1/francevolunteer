package ept.volunteer.ws.responsitory;

import ept.volunteer.ws.models.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
    Boolean existsByEmail(String email);

    Optional<UserLogin> findByEmail(String email);

    List<UserLogin> findAll();

}
