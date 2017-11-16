package hu.drumbun.service.need.impl;

import hu.drumbun.controller.need.model.NeedModel;
import hu.drumbun.repository.need.NeedRepository;
import hu.drumbun.service.need.NeedService;
import hu.drumbun.service.need.converter.NeedModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NeedServiceImpl implements NeedService{

    private final NeedRepository needRepository;
    private final NeedModelConverter needModelConverter;

    @Autowired
    public NeedServiceImpl(NeedRepository needRepository,NeedModelConverter needModelConverter) {
        this.needRepository = needRepository;
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
}
