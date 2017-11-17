package hu.drumbun.repository.path;

import hu.drumbun.entities.Path;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PathRepository extends JpaRepository<Path, Long>{

    List<Path> findAll();
    Path findByStart(String start);
    Path findByDestination(String destination);

}
