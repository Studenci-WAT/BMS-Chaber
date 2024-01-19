package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.RodzajGlowicyBojEntity;
import pl.edu.wat.mspw_frontend.model.RodzajGlowicyBojDto;

public class RodzajGlowicyBojService extends GenericService<RodzajGlowicyBojEntity, RodzajGlowicyBojDto> {
    public RodzajGlowicyBojService() {
        super(RodzajGlowicyBojEntity.class,
                e -> new RodzajGlowicyBojDto(e.getId(), e.getNazwa(), e.getSkrot()),
                d -> new RodzajGlowicyBojEntity(d.getId(), d.getNazwa(), d.getSkrot())
        );
    }
}
