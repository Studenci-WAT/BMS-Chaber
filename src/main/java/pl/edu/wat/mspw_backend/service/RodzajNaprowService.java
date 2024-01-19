package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.RodzajNaprowEntity;
import pl.edu.wat.mspw_frontend.model.RodzajNaprowDto;

public class RodzajNaprowService extends GenericService<RodzajNaprowEntity, RodzajNaprowDto> {
    public RodzajNaprowService() {
        super(RodzajNaprowEntity.class,
                e -> new RodzajNaprowDto(e.getId(), e.getNazwa(), e.getSkrot()),
                d -> new RodzajNaprowEntity(d.getId(), d.getNazwa(), d.getSkrot())
        );
    }
}
