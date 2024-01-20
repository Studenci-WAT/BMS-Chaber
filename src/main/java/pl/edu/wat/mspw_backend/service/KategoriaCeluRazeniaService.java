package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.KategoriaCeluRazeniaEntity;
import pl.edu.wat.mspw_frontend.model.KategoriaCeluRazeniaDto;

public class KategoriaCeluRazeniaService extends GenericService<KategoriaCeluRazeniaEntity, KategoriaCeluRazeniaDto> {
    public KategoriaCeluRazeniaService() {
        super(KategoriaCeluRazeniaEntity.class,
                e -> new KategoriaCeluRazeniaDto(e.getId(), e.getNazwa(), e.getSkrot()),
                d -> new KategoriaCeluRazeniaEntity(d.getId(), d.getNazwa(), d.getSkrot())
        );
    }
}
