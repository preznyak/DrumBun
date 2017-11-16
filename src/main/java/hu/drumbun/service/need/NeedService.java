package hu.drumbun.service.need;

import hu.drumbun.controller.need.model.NeedModel;

import java.util.List;

public interface NeedService {
    List<NeedModel> findAll();
    NeedModel findById(long id);
}
