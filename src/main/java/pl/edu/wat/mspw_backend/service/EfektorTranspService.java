package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.EfektorTranspEntity;
import pl.edu.wat.mspw_frontend.model.EfektorTranspDto;

public class EfektorTranspService extends GenericService<EfektorTranspEntity, EfektorTranspDto> {
    public EfektorTranspService() {
        super(EfektorTranspEntity.class,
                e -> new EfektorTranspDto(e.getId(), e.getDesant(), e.getLadowMasa(),
                        e.getLadowWymX(), e.getLadowWymY(), e.getLadowWymZ(),
                        e.getPojem(), e.getTransportWody()),
                d -> new EfektorTranspEntity(d.getId(), d.getDesant(), d.getLadowMasa(),
                        d.getLadowWymX(), d.getLadowWymY(), d.getLadowWymZ(),
                        d.getPojem(), d.getTransportWody())
        );
    }
}
