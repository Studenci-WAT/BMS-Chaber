package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.StanAmoSpwEntity;
import pl.edu.wat.mspw_frontend.model.StanAmoSpwDto;

public class StanAmoSpwService extends GenericService<StanAmoSpwEntity, StanAmoSpwDto> {
    public StanAmoSpwService() {
        super(StanAmoSpwEntity.class,
                e -> new StanAmoSpwDto(e.getId(), e.getSpwFk(), e.getAmoFk(), e.getStanNormatyw()),
                d -> new StanAmoSpwEntity(d.getId(), d.getSpwFk(), d.getAmoFk(), d.getStanNormatyw())
        );
    }
}
