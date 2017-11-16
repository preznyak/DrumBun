package hu.drumbun.service.path.impl;

import hu.drumbun.entities.Path;
import hu.drumbun.repository.path.PathRepository;
import hu.drumbun.service.path.PathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PathServiceImpl implements PathService {

    private final PathRepository pathRepository;

    @Autowired
    public PathServiceImpl(PathRepository pathRepository) {
        this.pathRepository = pathRepository;
    }

    @Override
    public List<Path> findAll() {
        return pathRepository.findAll();
    }

    @Override
    public Path findById(long id) {
        return pathRepository.findOne(id);
    }

    @Override
    public Path findByStart(String start) {
        return pathRepository.findByStart(start);
    }

    @Override
    public Path findByDestination(String destination) {
        return pathRepository.findByDestination(destination);
    }
}
