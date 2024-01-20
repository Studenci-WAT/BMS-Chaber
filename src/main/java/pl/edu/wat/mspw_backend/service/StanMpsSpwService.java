package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.StanMpsSpwEntity;
import pl.edu.wat.mspw_frontend.model.StanMpsSpwDto;

public class StanMpsSpwService extends GenericService<StanMpsSpwEntity, StanMpsSpwDto> {
    public StanMpsSpwService() {
        super(StanMpsSpwEntity.class,
                e -> new StanMpsSpwDto(e.getId(), e.getSpwFk(), e.getMpsFk(), e.getStanNormatyw()),
                d -> new StanMpsSpwEntity(d.getId(), d.getSpwFk(), d.getMpsFk(), d.getStanNormatyw())
        );
    }
}
