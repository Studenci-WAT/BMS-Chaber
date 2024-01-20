package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.RodzajGlowicyNaprowEntity;
import pl.edu.wat.mspw_frontend.model.RodzajGlowicyNaprowDto;

public class RodzajGlowicyNaprowService extends GenericService<RodzajGlowicyNaprowEntity, RodzajGlowicyNaprowDto> {
    public RodzajGlowicyNaprowService() {
        super(RodzajGlowicyNaprowEntity.class,
                e -> new RodzajGlowicyNaprowDto(e.getId(), e.getNazwa(), e.getSkrot()),
                d -> new RodzajGlowicyNaprowEntity(d.getId(), d.getNazwa(), d.getSkrot())
        );
    }
}
