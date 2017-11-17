package hu.drumbun.service.need.impl;

import hu.drumbun.controller.need.model.NeedModel;
import hu.drumbun.entities.Need;
import hu.drumbun.repository.need.NeedRepository;
import hu.drumbun.repository.path.PathRepository;
import hu.drumbun.service.need.NeedService;
import hu.drumbun.service.need.converter.NeedModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NeedServiceImpl implements NeedService{

    private final NeedRepository needRepository;
    private final PathRepository pathRepository;
    private final NeedModelConverter needModelConverter;

    @Autowired
    public NeedServiceImpl(NeedRepository needRepository, PathRepository pathRepository, NeedModelConverter needModelConverter) {
        this.needRepository = needRepository;
        this.pathRepository = pathRepository;
        this.needModelConverter = needModelConverter;
    }

    @Override
    public List<NeedModel> findAll() {
        return needRepository.findAll().stream()
                .map(needModelConverter::fromNeedtoNeedModel)
                .collect(Collectors.toList());
    }

    @Override
    public NeedModel findById(long id) {
        return needModelConverter.fromNeedtoNeedModel(needRepository.findOne(id));
    }

    @Override
    public List<NeedModel> findByPath_Destination(String destination) {
        return needRepository.findByPath_Destination(destination).stream()
                .map(needModelConverter::fromNeedtoNeedModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<NeedModel> findByPath_Start(String start) {
        return needRepository.findByPath_Start(start).stream()
                .map(needModelConverter::fromNeedtoNeedModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<NeedModel> findByDateAfter(Date date) {
        return needRepository.findByDateAfter(date).stream()
                .map(needModelConverter::fromNeedtoNeedModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<NeedModel> findByDateBefore(Date date) {
        return needRepository.findByDateBefore(date).stream()
                .map(needModelConverter::fromNeedtoNeedModel)
                .collect(Collectors.toList());
    }

    @Override
    public void updateNeed(NeedModel needModel) {
        Need updatedNeed = needModelConverter.fromNeedModelToNeed(needModel);
        updatedNeed.setUser(needRepository.findOne(updatedNeed.getId()).getUser());
        pathRepository.save(updatedNeed.getPath());
        needRepository.save(updatedNeed);
    }

    @Override
    public void createNeed(NeedModel needModel) {
        Need newNeed = needModelConverter.fromNeedModelToNeed(needModel);
        pathRepository.save(newNeed.getPath());
        needRepository.save(newNeed);
    }
}
