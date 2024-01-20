package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.TypKlimatuEntity;
import pl.edu.wat.mspw_frontend.model.TypKlimatuDto;

public class TypKlimatuService extends GenericService<TypKlimatuEntity, TypKlimatuDto>{
    public TypKlimatuService() {
        super(TypKlimatuEntity.class,
                e -> new TypKlimatuDto(
                        e.getId(), e.getNazwa(), e.getSkrot()
                ),
                d -> new TypKlimatuEntity(
                        d.getId(), d.getNazwa(), d.getSkrot()
                )
        );
    }
}
