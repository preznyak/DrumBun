package hu.drumbun.service.path;

import hu.drumbun.entities.Path;

import java.util.List;

public interface PathService {
    List<Path> findAll();
    Path findById(long id);
    Path findByStart(String start);
    Path findByDestination(String destination);
    void updatePath(Path path);
    void createPath(Path path);
}
