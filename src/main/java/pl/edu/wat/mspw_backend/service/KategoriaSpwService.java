package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.KategoriaSpwEntity;
import pl.edu.wat.mspw_frontend.model.KategoriaSpwDto;

public class KategoriaSpwService extends GenericService<KategoriaSpwEntity, KategoriaSpwDto> {
    public KategoriaSpwService() {
        super(KategoriaSpwEntity.class,
                e -> new KategoriaSpwDto(e.getId(), e.getKategCeluRazeniaFk(), e.getNazwa(), e.getSkrot()),
                d -> new KategoriaSpwEntity(d.getId(), d.getKategCeluRazeniaFk(), d.getNazwa(), d.getSkrot())
        );
    }
}
