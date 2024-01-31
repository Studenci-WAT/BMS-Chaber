package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.RodzajSystemuOgnEntity;
import pl.edu.wat.mspw_frontend.model.RodzajSystemuOgnDto;

public class RodzajSystemuOgnService extends GenericService<RodzajSystemuOgnEntity, RodzajSystemuOgnDto> {
    public RodzajSystemuOgnService() {
        super(RodzajSystemuOgnEntity.class,
                e -> new RodzajSystemuOgnDto(e.getId(), e.getNazwa(), e.getSkrot()),
                d -> new RodzajSystemuOgnEntity(d.getId(), d.getNazwa(), d.getSkrot())
        );
    }
}
