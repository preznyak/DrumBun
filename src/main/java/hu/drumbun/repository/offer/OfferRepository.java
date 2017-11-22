package hu.drumbun.repository.offer;

import hu.drumbun.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long>{
    List<Offer> findAll();
    List<Offer> findByPath_Start(String start);
    List<Offer> findByPath_Destination(String destination);
    List<Offer> findByStartTimeBefore(Date date);
    List<Offer> findByStartTimeAfter(Date date);

}