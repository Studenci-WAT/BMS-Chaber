package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.MpsEntity;
import pl.edu.wat.mspw_frontend.model.MpsDto;


public class MpsService extends GenericService<MpsEntity, MpsDto> {
    public MpsService() {
        super(MpsEntity.class,
                e -> new MpsDto(e.getId(), e.getNazwa(), e.getSkrot(), e.getKod()),
                d -> new MpsEntity(d.getId(), d.getNazwa(), d.getSkrot(), d.getKod())
        );
    }
}

