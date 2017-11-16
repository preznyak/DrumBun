package hu.drumbun.service.need;

import hu.drumbun.controller.need.NeedModel;
import hu.drumbun.entities.Need;

import java.util.List;

public interface NeedService {
    List<NeedModel> findAll();
    NeedModel findById(long id);
}
