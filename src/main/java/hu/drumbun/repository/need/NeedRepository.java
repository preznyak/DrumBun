package hu.drumbun.repository.need;

import hu.drumbun.entities.Need;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface NeedRepository extends JpaRepository<Need, Long>{
    List<Need> findAll();
    List<Need> findByPath_Destination(String destination);
    List<Need> findByPath_Start(String start);
    List<Need> findByDateAfter(Date date);
    List<Need> findByDateBefore(Date date);
    List<Need> findByUser_Username(String username);

    List<Need> findByPath_StartAndPath_DestinationAndDateAfter(String start, String destination, Date date);
}
