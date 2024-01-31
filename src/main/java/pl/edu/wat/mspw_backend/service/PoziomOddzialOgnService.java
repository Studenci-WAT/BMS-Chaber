package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.PoziomOddzialOgnEntity;
import pl.edu.wat.mspw_frontend.model.PoziomOddzialOgnDto;

public class PoziomOddzialOgnService extends GenericService<PoziomOddzialOgnEntity, PoziomOddzialOgnDto> {
    public PoziomOddzialOgnService() {
        super(PoziomOddzialOgnEntity.class,
                e -> new PoziomOddzialOgnDto(e.getId(), e.getNazwa(), e.getSkrot()),
                d -> new PoziomOddzialOgnEntity(d.getId(), d.getNazwa(), d.getSkrot())
        );
    }
}
