package sbb.bidb.projectBase.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sbb.bidb.projectBase.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

}
