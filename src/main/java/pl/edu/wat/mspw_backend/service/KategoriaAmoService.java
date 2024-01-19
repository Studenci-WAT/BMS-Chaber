package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.KategoriaAmoEntity;
import pl.edu.wat.mspw_frontend.model.KategoriaAmoDto;

public class KategoriaAmoService extends GenericService<KategoriaAmoEntity, KategoriaAmoDto> {
    public KategoriaAmoService() {
        super(KategoriaAmoEntity.class,
                e -> new KategoriaAmoDto(e.getId(), e.getNazwa(), e.getSkrot()),
                d -> new KategoriaAmoEntity(d.getId(), d.getNazwa(), d.getSkrot())
        );
    }
}
