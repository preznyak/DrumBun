package hu.drumbun.repository.userprofile;

import hu.drumbun.entities.User;
import hu.drumbun.entities.UserProfile;
import hu.drumbun.enums.DriverLicense;
import hu.drumbun.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long>{

    UserProfile findByUser(User user);

    List<UserProfile> findAll();

    List<UserProfile> findAllByDriverLicense(DriverLicense driverLicense);

    List<UserProfile> findAllByGender(Gender gender);

}
