package re.res;

import re.res.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by songqiuming on 2018/1/7.
 */
public interface UserJPARepository extends JpaRepository<User,Integer> {
    User findById(Integer id);
    List<User> findByCountry(String country);
}
